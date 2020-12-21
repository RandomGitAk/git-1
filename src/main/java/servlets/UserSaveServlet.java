package servlets;


import dao.UserDaoImpl;
import model.Role;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("submit") != null) {
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String email = req.getParameter("email");
            User user = new User(0, login,password, Role.USER,email);
            new UserDaoImpl().saveUser(user);
        }
        resp.sendRedirect("/courses");
    }

}
