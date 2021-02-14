package com.servlets;

import com.bean.Item;
import com.global.Global_var;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Search extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from = request.getParameter("from");
        String to = request.getParameter("to");
        String Option = request.getParameter("Submit");
        List<Item> itemList = new ArrayList<>();
        try {
            itemList = Global_var.getItem(from, to);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(Option.equals("Sort by Time"))
        {
            itemList.sort(new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                            return o1.getTime() > o2.getTime()? 1 : -1;
                }
            });
        }
        else if(Option.equals("Sort by Price"))
        {
            itemList.sort(new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    return o1.getCost() > o2.getCost()? 1 : -1;
                }
            });
        }
        request.setAttribute("results", itemList);
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.getRequestDispatcher("show.jsp").forward(request,response);
    }
}
