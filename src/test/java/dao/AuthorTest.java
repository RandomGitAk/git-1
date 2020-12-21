package dao;

import model.Author;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {

    @Test
    public void getId() {
        Author author  = new Author("Шекспір",5);
        assertEquals(5,author.getId());
    }

    @Test
    public void setId() {
        Author author  = new Author("Шекспір",5);
        author.setId(6);
        assertEquals(6,author.getId());
    }


    @Test
    public void getName() {
        Author author  = new Author("Шекспір",5);
        assertEquals("Шекспір",author.getName());
    }

    @Test
    public void setName() {
        Author author  = new Author("Шекспір",5);
        author.setName("Гоголь");
        assertEquals("Гоголь",author.getName());
    }

}