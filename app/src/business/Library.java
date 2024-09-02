package business;

import java.util.ArrayList;
import java.util.HashMap;

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

    public void tableStyleUp() {
        System.out.println(" ");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-15s | %-20s | %-20s | %-15s | %-15s | %-15s | %-15s%n", "Type", "ID", "Title",
                "Author", "Bup Date", "Num of Pages", "Borrowed", "Details");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public void tableStyleDown() {
        System.out.println(
                "------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(" ");
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
}
