package com.servlets;

        import com.bean.User;
        import com.global.Global_var;

        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

public class User_manage extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ID = request.getParameter("id");
        String Pass = request.getParameter("pass");
        String Option = request.getParameter("option");
        User user = new User();
        user.setPass(Pass);
        user.setUser(ID);
        switch (Option) {
            case "delete":
                Global_var.User_delete(user.getUser());
                break;
            case "modify":
                Global_var.User_modify(user);
                break;
        }
        response.sendRedirect("user_management.jsp");
    }
}
