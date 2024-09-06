package business;

import java.time.LocalDate;

public class Magazine extends Document {
    private int numero;

    public Magazine(String id, String title, String author, LocalDate publicationDate, int numberOfPages, int numero) {
        super(id, title, author, publicationDate, numberOfPages);
        this.numero = numero;
    }

    @Override
    public void borrow() {
        this.borrowed = true;
        System.out.println("[+] Magazine \""+ title +"\" borrowed successfully.");
    }

    @Override
    public void returnDocument() {
        this.borrowed = false;
        System.out.println("[+] Magazine \""+title+"\" returned successfully.");
    }

    @Override
    public void displayDetails() {
        System.out.printf("%-10s | %-15s | %-20s | %-20s | %-25s | %-15s | %-10s | Issue No: %-15d%n", 
                          "Magazine", id, title, author, publicationDate, numberOfPages, borrowed ? "YES" : "NO", numero);
}
}
