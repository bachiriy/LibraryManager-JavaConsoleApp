package business;

import java.time.LocalDate;

public class Book extends Document {
    private String isbn;

    public Book(String id, String title, String author, LocalDate publicationDate, int numberOfPages, String isbn) {
        super(id, title, author, publicationDate, numberOfPages);
        this.isbn = isbn;
    }

    @Override
    public void borrow() {
        this.borrowed = true;
        System.out.println("[+] Book \"" + title +"\" borrowed successfully.");
    }

    @Override
    public void returnDocument() {
        this.borrowed = false;
        System.out.println("[+] Book \"" + title + "\" returned successfully.");
    }

    @Override
    public void displayDetails() {
        System.out.printf("%-10s | %-15s | %-20s | %-20s | %-15s | %-15s | %-15s | ISBN: %-15s%n", 
                          "Book ", id, title, author, publicationDate, numberOfPages, borrowed ? "YES" : "NO", isbn);
    }
    
}
