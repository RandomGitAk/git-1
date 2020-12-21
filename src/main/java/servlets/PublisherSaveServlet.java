package servlets;
import model.Publisher;
import dao.PublisherList;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PublisherSaveServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("submit") != null) {
            String name = req.getParameter("name_pub");
           Publisher publisher = new Publisher(name, 0);
            new PublisherList().savePublisher(publisher);
        }
        resp.sendRedirect("/courses");
    }
}
