package dao;

import model.Book;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    public void getId() {
        Book book  = new Book(2, "Собаче серце","http/",17, "954-88", 2,
        2,1976,2, "String image" );
        assertEquals(2,book.getId());
    }

    @Test
    public void setId() {
        Book book  = new Book(2, "Собаче серце","http/",17, "954-88", 2,
                2,1976,2, "String image" );
        book.setId(6);
        assertEquals(6,book.getId());


    }


    @Test
    public void getName() {
        Book book  = new Book(2, "Собаче серце","http/",17, "954-88", 2,
                2,1976,2, "String image" );
        assertEquals("Собаче серце",book.getName());
    }

    @Test
    public void setName() {
        Book book  = new Book(2, "Собаче серце","http/",17, "954-88", 2,
                2,1976,2, "String image" );
       book.setName("Старий і море");
        assertEquals("Гоголь",book.getName());
    }

    @Test
    public void getContent() {
        Book book  = new Book(2, "Собаче серце","http/",17, "954-88", 2,
                2,1976,2, "String image" );
        assertEquals("http/",book.getContent());
    }

    @Test
    public void setContent() {
        Book book  = new Book(2, "Собаче серце","http/",17, "954-88", 2,
                2,1976,2, "String image" );
        book.setContent("http/");
        assertEquals("http/",book.getContent());
    }


}