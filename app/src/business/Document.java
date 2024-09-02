package business;

import java.time.LocalDate;

public abstract class Document {
    protected String id;
    protected String title;
    protected String author;
    protected LocalDate publicationDate;
    protected int numberOfPages;
    protected boolean borrowed = false;

    public Document(String id, String title, String author, LocalDate publicationDate, int numberOfPages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
    }

    public abstract void borrow();

    public abstract void returnDocument();

    public abstract void displayDetails();

    public void setDoc (String id, String title, String author, LocalDate publicationDate, int numberOfPages){
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
    }

    public Object[] getDoc(){
        return new Object[]{id, title, author, publicationDate, numberOfPages};
    }
    public void setDoc(String title, String author, LocalDate publicationDate, int numberOfPages){
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
    }
    public String getId(){
        return this.id;
    }
}
