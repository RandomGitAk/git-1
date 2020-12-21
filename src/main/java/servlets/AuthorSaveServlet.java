package servlets;


import model.Author;
import dao.AuthorList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("submit") != null) {
            String name = req.getParameter("name_auth");
           Author author = new Author(name, 0);
            new AuthorList().saveAuthor(author);
        }
        resp.sendRedirect("/courses");
    }
}
