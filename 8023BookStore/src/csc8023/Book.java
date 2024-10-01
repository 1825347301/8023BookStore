package csc8023;

public class Book {
    private String id;
    private String title;
    private int yearPublished;
    private double value;

    public Book(String id, String title, int yearPublished, double value) {
        this.id = id;
        this.title = title;
        this.yearPublished = yearPublished;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Book Id: " + id + ", Title: " + title + ", Year published: " + yearPublished + ", Value: £" + value;
    }
}

