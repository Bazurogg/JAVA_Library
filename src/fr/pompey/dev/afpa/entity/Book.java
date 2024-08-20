package fr.pompey.dev.afpa.entity;

public class Book {

private String title;
private String author;
private Integer nbPages;
private boolean available;

public Book(String title, String author, Integer nbPages, boolean available) {

    this.title = title;
    this.author = author;
    this.nbPages = nbPages;
    this.available = available;

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

    // Methods

    // Display book
    @Override
    public String toString() {

        String availability = available ? "Available" : "Not Available";

        return getTitle() + " | " + getAuthor() + " | " + getNbPages() + " pages" + " | \u001B[32m" + availability + "\u001B[0m";

    }

}