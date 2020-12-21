package model;

import java.io.Serializable;

public class Book implements Serializable{

    private int id;
    private String name;
    private String content;
    private int pageCount;
    private String isbn;
    private String genre;
    private String author;
    private int publishDate;
    private String publisher;
    private String image;
    private int genreId;
    private  int authorId;
    private  int publisherId;

    public Book(){

    }

    public Book(int id, String name,String content, int pageCount, String isbn, int genreId,
   int authorId, int publishDate, int publisherId, String image ){
        this.id =id;
        this.name =name;
        this.content =content;
        this.pageCount =pageCount;
        this.isbn =isbn;
        this.genreId =genreId;
        this.authorId =authorId;
        this.publishDate =publishDate;
        this.publisherId =publisherId;
        this.image =image;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() { return content; }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(int publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
