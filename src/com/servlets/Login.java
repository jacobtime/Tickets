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
import java.util.Objects;

public class Login extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String try_pass = request.getParameter("pass");
        String sql = null;

        String pass = null;
        String is_admin = null;
        ResultSet rs;
        boolean flag = false;
        sql = "call user_check(\"" + user + "\");";
        rs = DbOp.executeQuery(sql);
        assert rs != null;
        try {
            if(rs.next()) {
                if (rs.getString(1).equals("1")) {
                    flag = true;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(!flag)
        {
            request.setAttribute("wrong", "UserNotExist" );
            request.getRequestDispatcher("notRight.jsp").forward(request, response);
        }
        sql = "call login_check(\"" + user + "\");";
        rs = DbOp.executeQuery(sql);
        assert rs != null;
        try {
            if(rs.next()) {
                pass = rs.getString("pass");
                is_admin = rs.getString("is_admin");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if(Objects.equals(pass, try_pass))
        {
            Global_var.setUser(user);
            assert is_admin != null;
            if(is_admin.equals("1"))
                response.sendRedirect("management.jsp");
            else
                response.sendRedirect("user.jsp");
        }
        else
        {
            request.setAttribute("wrong", "PassWrong" );
            request.getRequestDispatcher("notRight.jsp").forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
