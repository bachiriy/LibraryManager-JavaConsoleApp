package ui;

import business.Library;
import business.Book;
import business.Magazine;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.Instant;

public class ConsoleUI {

    private Library library;
    private Scanner scanner;

    public ConsoleUI() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        clear();
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            clear();
            handleChoice(choice);
        } while (choice != 6);
    }

    private void displayMenu() {
        System.out.println("--------------------------------------------------------------");
        System.out.println("                 Library Management System                   -");
        System.out.println("-                                                            -");
        System.out.println("-  1. Add a document                                         -");
        System.out.println("-  2. Borrow a document                                      -");
        System.out.println("-  3. Return a document                                      -");
        System.out.println("-  4. Display all documents                                  -");
        System.out.println("-  5. Search for a document                                  -");
        System.out.println("-  6. Exit                                                   -");
        System.out.println("--------------------------------------------------------------");
    }

    private int getUserChoice() {
        System.out.print("-> Enter your choice (1-6): ");
        return scanner.nextInt();
    }

    public void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleChoice(int choice) {
        scanner.nextLine();
        switch (choice) {
            case 1:
                addDocument();
                break;
            case 2:
                borrowDocument();
                break;
            case 3:
                returnDocument();
                break;
            case 4:
                displayAllDocuments();
                break;
            case 5:
                searchDocument();
                break;
            case 6:
                System.out.println("Exiting...");
                break;
            default:
                System.out.println("[-] Invalid choice. Please enter a number between 1 and 6.");
        }
    }

    private void addDocument() {
        System.out.println("-> Enter document type (1 for Book, 2 for Magazine): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        String id = generateUniqueId();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        System.out.print("Enter author: ");
        String author = scanner.nextLine();

        System.out.print("Enter publication date (YYYY-MM-DD): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter number of pages: ");
        int pages = scanner.nextInt();
        scanner.nextLine();

        if (type == 1) {
            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();
            Book book = new Book(id, title, author, date, pages, isbn);
            library.addDocument(book);
            System.out.println("[+] Book added successfully with ID: " + id);
        } else if (type == 2) {
            System.out.print("Enter issue number: ");
            int issueNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Magazine magazine = new Magazine(id, title, author, date, pages, issueNumber);
            library.addDocument(magazine);
            System.out.println("[+] Magazine added successfully with ID: " + id);
        } else {
            System.out.println("[-] Invalid document type.");
        }
    }

    private String generateUniqueId() {
        return String.valueOf(Instant.now().toEpochMilli());
    }

    private void borrowDocument() {
        System.out.println("Typ document ID to borrow: ");
        String id = scanner.nextLine();
        library.borrowDocument(id);
    }

    private void returnDocument() {
        System.out.println("Type document ID to be returned: ");
        String id = scanner.nextLine();
        library.returnDocument(id);
    }

    private void displayAllDocuments() {
        library.displayAllDocuments();
    }

    private void searchDocument() {
        System.out.println("Enter the ID of the document to search : ");
        String id = scanner.nextLine();
        library.idSearchDoc(id);

    }
}
