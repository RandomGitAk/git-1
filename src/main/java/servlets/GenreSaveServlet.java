package servlets;

import model.Genre;
import dao.GenreList;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GenreSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("submit") != null) {
            String name = req.getParameter("name_gen");
            Genre genre = new Genre(name, 0);
            new GenreList().saveGenre(genre);
        }
        resp.sendRedirect("/courses");
    }
}
