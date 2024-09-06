package ui;

import business.Library;
import business.Book;
import business.Magazine;
import util.DateUtils;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            choice = getUserChoice(7);
            clear();
            handleChoice(choice);
        } while (choice != 6);
    }

    private void displayMenu() {
        System.out.println("  ");
        System.out.println("--------------------------------------------------------------");
        System.out.println("                 Library Management System                   -");
        System.out.println("-                                                            -");
        System.out.println("-  1. Add a document                                         -");
        System.out.println("-  2. Borrow a document                                      -");
        System.out.println("-  3. Return a document                                      -");
        System.out.println("-  4. Display all documents                                  -");
        System.out.println("-  5. Search for a document                                  -");
        System.out.println("-  6. Exit                                                   -");
        System.out.println("-                                                            -");
        System.out.println("-  7. Clear                                                  -");
        System.out.println("--------------------------------------------------------------");
        System.out.println("  ");
    }

    private int getUserChoice(int finalChoiceNum) {
        System.out.print(">>> Enter your choice (1-" + finalChoiceNum + "): ");
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else
            return 0;
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
        scanner.nextLine(); // consume the new line
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
                System.out.println(">>> Exiting...");
                break;
            case 7:
                clear();
                break;
            default:
                System.out.println("[-] Invalid choice. Please enter a number between 1 and 6.");
        }
    }

    private void addDocument() {
        System.out.println(">>> Enter document type (1 for Book, 2 for Magazine): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        String id = generateUniqueId();

        System.out.print(">>> Enter title: ");
        String title = scanner.nextLine();

        System.out.print(">>> Enter author: ");
        String author = scanner.nextLine();

        System.out.print(">>> Enter publication date (DD/MM/YYYY): ");
        String inputDate = scanner.nextLine();
        LocalDate date;
        if (DateUtils.isValiDate(inputDate)) {
            date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } else {
            System.out.println(" ");
            System.out.println("[-] Invalide Date, try a valide date next time!");
            System.out.println(" ");
            return;
        }

        System.out.print(">>> Enter number of pages: ");
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
        System.out.println(">>> Typ document ID to borrow: ");
        String id = scanner.nextLine();
        library.borrowDocument(id);
    }

    private void returnDocument() {
        System.out.println(">>> Type document ID to be returned: ");
        String id = scanner.nextLine();
        library.returnDocument(id);
    }

    private void displayAllDocuments() {
        library.displayAllDocuments();
    }

    private void displaySearchMenu() {
        System.out.println("  ");
        System.out.println("--------------------------------------------");
        System.out.println("              Search & Filter              -");
        System.out.println("-                                          -");
        System.out.println("-  1. Search by ID                         -");
        System.out.println("-  2. Search by Title                      -");
        System.out.println("-  3. Filter by year                       -");
        System.out.println("-  4. Return Home                          -");
        System.out.println("--------------------------------------------");
        System.out.println("  ");
    }

    private void searchDocument() {
        clear();
        displaySearchMenu();
        int choice = getUserChoice(4);
        scanner.nextLine();
        handleSearchChoice(choice);
    }

    private void handleSearchChoice(int choice) {
        switch (choice) {
            case 1:
                searchByID();
                break;
            case 2:
                searchByTitle();
                break;
            case 3:
                filterByYear();
                break;
            case 4:
                start();
                break;

            default:
                searchDocument();
                break;
        }
    }

    private void searchByTitle() {
        System.out.println(">>> Enter Title to seacrch a document: ");
        String title = scanner.nextLine();
        library.titleSearchDoc(title);

    }

    private void filterByYear() {
        System.out.println(">>> Enter a year to disoplay Documents published after that year: ");
        int year = scanner.nextInt();
        scanner.nextLine();
        library.afterYearFilter(year);
    }

    private void searchByID() {
        System.out.println(">>> Enter the ID of the document to search : ");
        String id = scanner.nextLine();
        library.idSearchDoc(id);
    }
}
