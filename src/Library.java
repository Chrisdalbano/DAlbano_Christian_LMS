import java.io.IOException;
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> myBooks;

    public Library() {

        //Initialize a myBooks library that will take the dynamic ArrayList to store the books
        myBooks = new ArrayList<>();
    }

    // This method will take the file location and add the book from that file to the library
    public void addBook(String bookLocation) {

        //We call the fileHandler class to find and scan the book location
        FileHandler fileHandler = new FileHandler(bookLocation);
        try {
            // Read the content from the file
            String fileContents = fileHandler.readFileContents();

            // Split the content into lines
            String[] lines = fileContents.split(System.lineSeparator());

            // Process each line assuming the format: Title, Author
            //Example of file contents '1984, George Orwell'
            for (String line : lines) {
                String[] titleAuthor = line.split(",");
                if (titleAuthor.length == 2) {
                    String title = titleAuthor[0].trim();
                    String author = titleAuthor[1].trim();

                    // Automatically assign the next available ID based on the number of books
                    int id = myBooks.size() + 1;

                    // Creating the new Book object and add it to the library
                    Book newBook = new Book(id, title, author);
                    myBooks.add(newBook);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the book file: " + e.getMessage());
        }
    }

    // remove a book by its ID
    public void removeBook(int id) {
        myBooks.removeIf(book -> book.getId() == id);
    }

    //  display a specific book by its ID
    public void displayBook(int id) {
        for (Book book : myBooks) {
            if (book.getId() == id) {
                System.out.println(book);
                return;
            }
        }
        System.out.println("Book with ID " + id + " not found.");
    }

    // display all books in the library
    public void displayAllBooks() {
        if (myBooks.isEmpty()) {
            System.out.println("No books in the library just yet.");
        } else {
            for (Book book : myBooks) {
                System.out.println(book);
            }
        }
    }
}
