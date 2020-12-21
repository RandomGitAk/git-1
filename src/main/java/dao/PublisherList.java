package dao;

import db.ConnectionFactory;
import model.Publisher;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PublisherList {

        private ArrayList<Publisher> publisherList = new ArrayList<Publisher>();

        private ArrayList<Publisher> getPublishers() {
            Statement stmt = null;
            ResultSet rs = null;
            Connection conn = null;
            try {
                conn = ConnectionFactory.getConnection();

                stmt = conn.createStatement();
                rs = stmt.executeQuery("select * from publisher order by name_pub");
                while (rs.next()) {
                    Publisher publisher = new Publisher();
                    publisher.setId(rs.getLong("id"));
                    publisher.setName(rs.getString("name_pub"));

                    publisherList.add(publisher);
                }

            } catch (SQLException ex) {
                Logger.getLogger(dao.AuthorList.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (stmt!=null) stmt.close();
                    if (rs!=null)rs.close();
                    if (conn!=null)conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(dao.AuthorList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            return publisherList;
        }
//+1

        public Map<Long, String> listPublishersNames() {
            List<Publisher> list = getPublishers();
            Map<Long, String> map = new HashMap<>();
            for (Publisher l: list) {
                map.put(l.getId(), l.toString());
            }
            return map;
        }

    public void savePublisher(Publisher publisher) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement pst;
            pst = connection.prepareStatement("insert into publisher(name_pub) values (?)");
            pst.setString(1,publisher.getName());
            pst.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

        ///
        public ArrayList<Publisher> getAuthorList() {
            if (!publisherList.isEmpty()) {
                return publisherList;
            } else {
                return getPublishers();
            }
        }
}
