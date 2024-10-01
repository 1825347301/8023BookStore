/*
Credit by Nick
01/10/2024
Claim before copying
 */


package csc8023;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BookStoreWindowIO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // monitor keyboard of bookstore
        System.out.print("Please enter the BookStore name: ");
        String storeName = scanner.nextLine();
        BookStoreWindow bookStore = new BookStoreWindow(storeName);

        // Read of file :books.csv
        try (BufferedReader br = new BufferedReader(new FileReader("books.csv"))) {
            // Ignore the first line
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String id = values[0];
                String title = values[1];
                int year = Integer.parseInt(values[2]);
                double value = Double.parseDouble(values[3]);
                bookStore.addBook(new Book(id, title, year, value));
            }
        } catch (IOException e) {
            System.out.println("File IO failed: " + e.getMessage());
        }

        // 菜单选项
        while (true) {
            System.out.println("1. Show BookStore Information");
            System.out.println("2. Show Summary of books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Book shop name: " + bookStore.getName());
                    for (Book book : bookStore.getBooks()) {
                        System.out.println(book);
                    }
                    break;
                case 2:
                    System.out.println("Summary of books：");
                    Book mostValuable = bookStore.findMostValuableBook();
                    Book oldestBook = bookStore.findOldestBook();
                    double averageValue = bookStore.calculateAverageValue();
                    System.out.printf("Highest value book: %s, £%.2f\n", mostValuable.getTitle(), mostValuable.getValue());
                    System.out.printf("Oldest book: %s, %d\n", oldestBook.getTitle(), oldestBook.getYearPublished());
                    System.out.printf("Average value of books: £%.2f\n", averageValue);
                    break;
                case 3:
                    System.out.println("Exit Success!");
                    return;
                default:
                    System.out.println("Invalid choice!Please try again");
            }
        }
    }
}
