package com.servlets;

import com.dbc.DbOp;
import com.global.Global_var;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Register extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        String re_pass = request.getParameter("repass");
        String sex = request.getParameter("sex");
        String ID_card = request.getParameter("ID_card");
        String sql = null;
        ResultSet rs;
        boolean flag = false;
        sql = "call user_check(\"" + user + "\");";
        rs = DbOp.executeQuery(sql);
        assert rs != null;
        try {
            if (rs.next()) {
                if (rs.getString("choose").equals("0")) {
                    flag = true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (!flag) {
            request.setAttribute("wrong", "UserHaveExist");
            request.getRequestDispatcher("notRight.jsp").forward(request, response);
        }
        if (!pass.equals(re_pass)) {
            flag = false;
            request.setAttribute("wrong", "PassNotSame");
            request.getRequestDispatcher("notRight.jsp").forward(request, response);
        }
        sql = "call account_insert(" + "\"" + user + "\"," + "\"" + pass + "\","  + "\"" + sex + "\"," + "\"" + ID_card +  "\");";
        DbOp.executeUpdate(sql);
        Global_var.setUser(user);
        response.sendRedirect("search.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
