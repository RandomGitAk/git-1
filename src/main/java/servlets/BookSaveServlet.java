package servlets;

import model.Book;
import dao.BookList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BookSaveServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      if (req.getParameter("submit") != null) {

          String name = req.getParameter("name");
          String content = req.getParameter("content");
          int pageCount = Integer.parseInt(req.getParameter("pageCount"));
          String isbn = req.getParameter("isbn");
          int genreId = Integer.parseInt(req.getParameter("genre"));
          int authorId = Integer.parseInt(req.getParameter("author"));
          int publishDate = Integer.parseInt(req.getParameter("publishDate"));
          int publisherId = Integer.parseInt(req.getParameter("publisher"));
          String image = req.getParameter("file");
         Book book = new Book(0, name,content,pageCount, isbn,genreId,authorId,publishDate,publisherId,image);
          new BookList().saveBook(book);
      }
      resp.sendRedirect("/courses");
  }
}
