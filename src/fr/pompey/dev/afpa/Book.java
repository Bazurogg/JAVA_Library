package fr.pompey.dev.afpa;

public class Book {

    private String title;
    private String author;
    private Integer nbPages;
    private boolean available;

    public Book(String title, String author, Integer nbPages) {

        this.title = title;
        this.author = author;
        this.nbPages = nbPages;
        this.available = true;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getNbPages() {
        return nbPages;
    }

    public void setNbPages(Integer nbPages) {
        this.nbPages = nbPages;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
