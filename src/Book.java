public class Book {
    private int id;
    private String title;
    private String author;

    //Constructor for the book that takes id, title and author
    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    //Book methods to return its properties

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    //We define an override function to format the string
    @Override
    public String toString() {
        return id + ": " + title + ", " + author;
    }
}
