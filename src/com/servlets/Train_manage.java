package com.servlets;

import com.bean.Train;
import com.global.Global_var;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Train_manage extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("id");
        String Type = request.getParameter("type");
        String Seat = request.getParameter("seat");
        String Option = request.getParameter("option");
        Train  train = new Train();
        train.setType(Type);
        train.setSeat(Seat);
        train.setID(ID);
        if ("delete".equals(Option)) {
            Global_var.train_delete(train.getID());
        } else if ("add".equals(Option)) {
            Global_var.train_add(train);
            request.setAttribute("train", train.getID());
            request.setAttribute("ID", 0);
            request.getRequestDispatcher("state_add.jsp").forward(request, response);
        } else if ("modify".equals(Option)) {
            Global_var.train_modify(train);
        } else if ("find".equals(Option)) {
            try {
                request.setAttribute("results", Global_var.train_find(train));
                request.getRequestDispatcher("find.jsp").forward(request,response);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        response.sendRedirect("train_management.jsp");
    }
}
