package com.servlets;

import com.bean.State;
import com.global.Global_var;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class State_add extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("id");
        int State_id = Integer.parseInt(request.getParameter("state_id"));
        int Cost = Integer.parseInt(request.getParameter("cost"));
        String Name = request.getParameter("name");
        String Time = request.getParameter("time");
        State state = new State();
        state.setState_ID(State_id);
        state.setCost(Cost);
        state.setID(ID);
        state.setState_name(Name);
        state.setArrive_time(Time);
        Global_var.State_add(state);
        request.setAttribute("train", state.getID());
        request.setAttribute("ID", state.getState_ID() + 1);
        request.getRequestDispatcher("state_add.jsp").forward(request, response);
    }
}

