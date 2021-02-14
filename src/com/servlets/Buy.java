package com.servlets;

import com.bean.Order;
import com.global.Global_var;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class Buy extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = new String(req.getParameter("buy"));
        String from = new String(req.getParameter("from"));
        String to = new String(req.getParameter("to"));
        Order order = new Order();
        order.setID(id);
        order.setState_from(from);
        order.setState_to(to);
        order.setUser(Global_var.getUser());
        if(Global_var.getUser().equals("guest"))
        {
            req.setAttribute("wrong", "NoLogin" );
            req.getRequestDispatcher("notRight.jsp").forward(req, resp);
        }
        try {
            Global_var.insert_order(order);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.setAttribute("right", "CreateSuccess" );
        req.getRequestDispatcher("right.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
