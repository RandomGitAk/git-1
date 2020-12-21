package dao;

import db.ConnectionFactory;
import model.Book;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BookList {

    private ArrayList<Book> bookList = new ArrayList<Book>();

    private ArrayList<Book> getBooks(String str) {

        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.createStatement();

            rs = stmt.executeQuery(str);
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setGenre(rs.getString("genre"));
                book.setIsbn(rs.getString("isbn"));
                book.setAuthor(rs.getString("author"));
                book.setPageCount(rs.getInt("page_count"));
                book.setPublishDate(rs.getInt("publish_year"));
                book.setPublisher(rs.getString("publisher"));
                book.setImage(rs.getString("image"));
                book.setContent(rs.getString("content"));
                bookList.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return bookList;
    }

    public ArrayList<Book> getAllBooks() {

            return getBooks("select b.id,b.name,b.content,b.isbn,b.page_count,b.publish_year, p.name_pub as publisher,\n" +
                    "  a.name_auth as author, g.name_genre as genre, b.image from book b inner join author a on b.author_id=a.id\n" +
                    "inner join genre g on b.genre_id=g.id inner join publisher p on b.publisher_id=p.id order by b.name");

    }

    public ArrayList<Book> getBooksByGenre(long id) {
        if (id == 0) {
            return getAllBooks();
        } else {
            return getBooks("select b.id,b.name,b.content,b.isbn,b.page_count,b.publish_year, p.name_pub as publisher, a.name_auth\n" +
                    "    as author, g.name_genre as genre,  b.image from book b inner join author a on b.author_id=a.id\n" +
                    "        inner join genre g on b.genre_id=g.id inner join publisher p on b.publisher_id=p.id\n" +
                    "                    where genre_id= " + id + " order by b.name limit 0.5;");

        }
    }

    public ArrayList<Book> getBooksByLetter(String letter) {
        return getBooks("select b.id,b.name,b.content,b.isbn,b.page_count,b.publish_year, p.name_pub as publisher, a.name_auth as author, g.name_genre as \n" +
                " genre, b.image from book b inner join author a on b.author_id=a.id inner join \n" +
                "     genre g on b.genre_id=g.id inner join publisher p on b.publisher_id=p.id \n" +
                "where substr(b.name,1,1)='" + letter + "' order by b.name limit 0.5;");

    }


   public ArrayList<Book> getBooksBySearch(String searchStr) {
    return getBooks("select b.id,b.name,b.content,b.isbn,b.page_count,b.publish_year, p.name_pub as publisher, a.name_auth as author, g.name_genre as genre, b.image from book b\n" +
            "             inner join author a on b.author_id=a.id\n" +
            "             inner join genre g on b.genre_id=g.id\n" +
            "           inner join publisher p on b.publisher_id=p.id where lower(b.name) like '%" + searchStr.toLowerCase() + "%' order by b.name limit 0.5; ");




   }

public List<Book> listBooks() {

    List<Book> list = new ArrayList<>();
    ResultSet resultSet;

    try (Connection connection = ConnectionFactory.getConnection()) {
        resultSet = connection.createStatement().executeQuery("select b.id,b.name,b.content, b.page_count,b.isbn,b.genre_id,g.name_genre,b.author_id, a.name_auth,b.publish_year,\n" +
                "      b.publisher_id, p.name_pub,b.image from book b inner join genre g on g.id = b.genre_id inner join author a on\n" +
                "a.id = b.author_id inner join publisher p on p.id = b.publisher_id order by id;");
        while (resultSet.next()) {
           Book book = new Book();
           book.setId(resultSet.getInt("id"));
           book.setName(resultSet.getString("name"));
           book.setContent(resultSet.getString("content"));
           book.setPageCount(resultSet.getInt("page_count"));
           book.setIsbn(resultSet.getString("isbn"));
           book.setGenreId(resultSet.getInt("genre_id"));
           book.setAuthorId(resultSet.getInt("author_id"));
           book.setPublishDate(resultSet.getInt("publish_year"));
           book.setPublisherId(resultSet.getInt("publisher_id"));
           book.setImage(resultSet.getString("image"));

           String genre =
           resultSet.getString("name_genre");
           book.setGenre(genre);
            String author =
                    resultSet.getString("name_auth");
            book.setAuthor(author);
            String publisher =
                    resultSet.getString("name_pub");
            book.setPublisher(publisher);
            list.add(book);
        }
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
    return list;
}

    private static final String SAVE_DIR= "images";
    public void saveBook(Book book) {
        String savePath= ""+ File.separator + SAVE_DIR;
        //File fileSaveDir= new File(savePath);
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("insert into book(name, content, page_count,isbn,genre_id," +
                    "author_id,publish_year,publisher_id,image) values (?,?,?,?,?,?,?,?,?)");
            pst.setString(1, book.getName());
            pst.setString(2, book.getContent());
            pst.setInt(3, book.getPageCount());
            pst.setString(4, book.getIsbn());
            pst.setInt(5, book.getGenreId());
            pst.setInt(6, book.getAuthorId());
            pst.setInt(7, book.getPublishDate());
            pst.setInt(8, book.getPublisherId());

            String filePath=  savePath+ File.separator+ book.getImage();
            pst.setString(9, filePath);
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateBook(Book book) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("update book set name = ?, content = ?, page_count = ?," +
                    "isbn = ?, genre_id = ?, author_id = ?, publish_year = ?, publisher_id = ?," +
                    "image = ? where id = ?");
            pst.setString(1, book.getName());
            pst.setString(2, book.getContent());
            pst.setInt(3, book.getPageCount());
            pst.setString(4, book.getIsbn());
            pst.setInt(5, book.getGenreId());
            pst.setInt(6, book.getAuthorId());
            pst.setInt(7, book.getPublishDate());
            pst.setInt(8, book.getPublisherId());
            pst.setString(9, book.getImage());
            pst.setInt(10, book.getId());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Book getBookById(int id) {
        ResultSet resultSet;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst =
                    connection.prepareStatement("select b.id,b.name,b.content, b.page_count,b.isbn,b.genre_id,g.name_genre,b.author_id, a.name_auth,b.publish_year,\n" +
                            "    b.publisher_id, p.name_pub,b.image from book b inner join genre g on g.id = b.genre_id inner join author a on\n" +
                            "a.id = b.author_id inner join publisher p on p.id = b.publisher_id  where b.id=?;");
            pst.setInt(1, id);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setContent(resultSet.getString("content"));
                book.setPageCount(resultSet.getInt("page_count"));
                book.setIsbn(resultSet.getString("isbn"));
                book.setGenreId(resultSet.getInt("genre_id"));
                book.setAuthorId(resultSet.getInt("author_id"));
                book.setPublishDate(resultSet.getInt("publish_year"));
                book.setPublisherId(resultSet.getInt("publisher_id"));
                book.setImage(resultSet.getString("image"));

                String genre =
                        resultSet.getString("name_genre");
                book.setGenre(genre);
                String author =
                        resultSet.getString("name_auth");
                book.setAuthor(author);
                String publisher =
                        resultSet.getString("name_pub");
                book.setPublisher(publisher);
                return book;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Book();
    }

}
