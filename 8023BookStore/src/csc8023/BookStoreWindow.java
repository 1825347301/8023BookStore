package csc8023;

import java.util.ArrayList;
import java.util.List;

public class BookStoreWindow {
    private String name;
    private List<Book> books;

    public BookStoreWindow(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book findMostValuableBook() {
        Book mostValuable = null;
        for (Book book : books) {
            if (mostValuable == null || book.getValue() > mostValuable.getValue()) {
                mostValuable = book;
            }
        }
        return mostValuable;
    }

    public Book findOldestBook() {
        Book oldest = null;
        for (Book book : books) {
            if (oldest == null || book.getYearPublished() < oldest.getYearPublished()) {
                oldest = book;
            }
        }
        return oldest;
    }

    public double calculateAverageValue() {
        if (books.isEmpty()) {
            return 0;
        }
        double totalValue = 0;
        for (Book book : books) {
            totalValue += book.getValue();
        }
        return totalValue / books.size();
    }
}

