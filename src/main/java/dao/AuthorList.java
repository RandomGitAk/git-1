package dao;

import db.ConnectionFactory;
import model.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AuthorList {

    private ArrayList<Author> authorList = new ArrayList<Author>();

    private ArrayList<Author> getAuthors() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from author order by name_auth");
            while (rs.next()) {
                Author author = new Author();
                author.setId(rs.getLong("id"));
                author.setName(rs.getString("name_auth"));

                authorList.add(author);
            }

        } catch (SQLException ex) {
            Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt!=null) stmt.close();
                if (rs!=null)rs.close();
                if (conn!=null)conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return authorList;
    }

  public void saveAuthor(Author author) {

      try (Connection connection = ConnectionFactory.getConnection()) {
          PreparedStatement pst;
          pst = connection.prepareStatement("insert into author(name_auth) values (?)");
          pst.setString(1,author.getName());
          pst.executeUpdate();
      } catch (SQLException throwables) {
          throwables.printStackTrace();
      }
  }

    public Map<Long, String> listAuthorsNames() {
        List<Author> list = getAuthors();
        Map<Long, String> map = new HashMap<>();
        for (Author l: list) {
            map.put(l.getId(), l.toString());
        }
        return map;
    }

    public ArrayList<Author> getAuthorList() {
        if (!authorList.isEmpty()) {
            return authorList;
        } else {
            return getAuthors();
        }
    }
}
