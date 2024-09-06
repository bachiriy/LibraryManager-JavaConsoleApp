package business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private ArrayList<Document> documents;
    private HashMap<String, Document> documentMap;

    public Library() {
        documents = new ArrayList<>();
        documentMap = new HashMap<>();
    }

    public void addDocument(Document document) {
        documents.add(document);
        documentMap.put(document.getId(), document);
        System.out.println("  ");
        System.out.println("[+] Added document: \"" + document.title + "\"");
    }

    public void borrowDocument(String id) {
        Document document = documentMap.get(id);
        if (document != null) {
            document.borrow();
        } else {
            System.out.println("[-] Document not found.");
        }
    }

    public void returnDocument(String id) {
        Document document = documentMap.get(id);
        if (document != null) {
            document.returnDocument();
        } else {
            System.out.println("[-] Document not found.");
        }
    }

    public void displayAllDocuments() {
        tableStyleUp();
        for (Document document : documents) {
            document.displayDetails();
        }
        if (documents.size() == 0) {
            System.out.println("                                           LIST EMPTY.");
        }
        tableStyleDown();
    }

    public void idSearchDoc(String id) {
        Document document = documentMap.get(id);
        if (document != null) {
            tableStyleUp();
            document.displayDetails();
            tableStyleDown();
        } else {
            System.out.println("[-] Document not found.");
        }
    }

    public void titleSearchDoc(String title) {
        List<Document> filteredDocs = documents.stream()
                .filter(doc -> doc.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());

        if (filteredDocs.isEmpty()) {
            System.out.println("[-] No documents found with the title containing: " + title);
        } else {
            tableStyleUp();
            filteredDocs.forEach(Document::displayDetails);
            tableStyleDown();
        }
    }

    public void afterYearFilter(int year) {
        tableStyleUp();
        List<Document> filteredDocs = documents.stream()
                .filter(doc -> doc.getPubDate().getYear() > year)
                .collect(Collectors.toList());
            filteredDocs.forEach(Document::displayDetails);
        tableStyleDown();
    }


    // table upper and down styles
    public void tableStyleUp() {
        System.out.println(" ");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-15s | %-20s | %-20s | %-25s | %-15s | %-10s | %-15s%n", "Type", "ID", "Title",
                "Author", "Bup Date", "Num of Pages", "Borrowed", "Details");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void tableStyleDown() {
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
    }
}
