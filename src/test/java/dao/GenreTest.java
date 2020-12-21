package dao;

import model.Genre;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenreTest {

    @Test
    public void getId() {
        Genre genre  = new Genre("Фантастика",5);
        assertEquals(5,genre.getId());
    }

    @Test
    public void setId() {
        Genre genre  = new Genre("Фантастика",5);
        genre.setId(6);
        assertEquals(6,genre.getId());
    }


    @Test
    public void getName() {
        Genre genre  = new Genre("Фантастика",5);
        assertEquals("Фантастика",genre.getName());
    }

    @Test
    public void setName() {
        Genre genre  = new Genre("Фантастика",5);
        genre.setName("Казки");
        assertEquals("Казки",genre.getName());
    }
}