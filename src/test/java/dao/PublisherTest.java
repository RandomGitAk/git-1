package dao;

import model.Publisher;
import org.junit.Test;

import static org.junit.Assert.*;

public class PublisherTest {

    @Test
    public void getId() {
        Publisher publisher  = new Publisher("Ранок",5);
        assertEquals(5,publisher.getId());
    }

    @Test
    public void setId() {
        Publisher publisher  = new Publisher("Ранок",5);
        publisher.setId(6);
        assertEquals(6,publisher.getId());
    }


    @Test
    public void getName() {
        Publisher publisher  = new Publisher("Ранок",5);
        assertEquals("Ранок",publisher.getName());
    }

    @Test
    public void setName() {
        Publisher publisher  = new Publisher("Ранок",5);
        publisher.setName("Світ");
        assertEquals("Світ",publisher.getName());
    }
}