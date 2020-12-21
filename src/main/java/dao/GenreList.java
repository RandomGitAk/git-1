package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import db.ConnectionFactory;
import model.Genre;


public class GenreList {

    private ArrayList<Genre> genreList = new ArrayList<Genre>();

    private ArrayList<Genre> getGenres() {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from genre order by name_genre");
            while (rs.next()) {
                Genre genre = new Genre();
                genre.setName(rs.getString("name_genre"));
                genre.setId(rs.getLong("id"));
                genreList.add(genre);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return genreList;
    }
//+1

    public Map<Long, String> listGenre() {
        List<Genre> list = getGenres();
        Map<Long, String> map = new HashMap<>();
        for (Genre l: list) {
            map.put(l.getId(), l.toString());
        }
        return map;
    }

    public void saveGenre(Genre genre) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("insert into genre(name_genre) values (?)");
            pst.setString(1,genre.getName());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public ArrayList<Genre> getGenreList() {
        if (!genreList.isEmpty()) {
            return genreList;
        } else {
            return getGenres();
        }
    }
}
