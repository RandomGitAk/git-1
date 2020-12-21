package servlets;

import dao.*;
import model.Book;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookUpdateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("listG", new GenreList().listGenre());
        req.setAttribute("listA", new AuthorList().listAuthorsNames());
        req.setAttribute("listP", new PublisherList().listPublishersNames());
        BookList bookList = new BookList();
        Integer id = Integer.valueOf(req.getParameter("id"));
        Book book = bookList.getBookById(id);
        req.setAttribute("book", book);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/pages/update.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("submit") != null) {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
           String content = req.getParameter("content");
            int pageCount = Integer.parseInt(req.getParameter("pageCount"));
            String isbn = req.getParameter("isbn");
            int genreId = Integer.parseInt(req.getParameter("genre"));
            int authorId = Integer.parseInt(req.getParameter("author"));
            int publishDate = Integer.parseInt(req.getParameter("publishDate"));
            int publisherId = Integer.parseInt(req.getParameter("publisher"));
            String image = req.getParameter("image");

            Book book = new Book(id,name,content,pageCount,isbn,genreId,authorId,publishDate,publisherId,image);
            BookList bookList = new BookList();
           bookList.updateBook(book);

            resp.sendRedirect("/courses");
        }
    }

}
