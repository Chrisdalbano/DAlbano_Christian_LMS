import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        displayMenu();
    }

    public static void displayMenu() {

        //We initialize the Library on the Menu
        Library myLibrary = new Library();

        //Define the Instructions to print
        String instructions = "(1) to Add Book\n(2) to Remove Book by ID\n(3) to Display a book by ID\n(4) to Display ALL Books\n(-1) to Cancel.";

        //Define a boolean to control when the program keeps looping or ends
        boolean isRunning = true;
        /*
         * The menu will have the following options:
         * 1. Add Book
         * 2. Remove Book
         * 3. Display Book
         * 4. Display All books
         * User can type -1 to cancel their current operation, if on the Main menu, then, it will exit the program.
         * */

        //We start the program with the loop to repeat instructions
        while (isRunning) {

            //Initialize first scanner to read user input
            Scanner userScanner = new Scanner(System.in);
            System.out.println(instructions);
            System.out.println("Type your selection #");

            //We read the user input
            String userChoice = userScanner.nextLine();

            //If selecting -1 this will cancel the selection.
            if (!userChoice.equals("-1")) {
                System.out.println("User choice is: " + userChoice);

                //Initializing switch statements by user choice
                switch (userChoice) {
                    case "1": //Add Book
                        System.out.println("To add a book type the book's file location");
                        System.out.println("Example: path/to/your/book.txt ");


                        String inputLocation = userScanner.nextLine();
                        if (!inputLocation.equals("-1")) {
                            try {
                                myLibrary.addBook(inputLocation);
                                System.out.println("Book added!");
                            } catch (Exception e) {
                                System.out.println("Can't add book. Location not found.");
                            }

                        }

                        break;

                    case "2": // Remove Book
                        System.out.println("Type the book ID that you wish to delete: ");

                        try {
                            int inputId = userScanner.nextInt();
                            myLibrary.removeBook(inputId);
                            System.out.println("Book removed");
                        } catch (Exception e) {
                            System.out.println("Not a valid id.");
                        }


                        break;

                    case "3": // Display Book
                        System.out.println("Type the book ID that you wish to display: ");
                        try {
                            int inputId = userScanner.nextInt();
                            myLibrary.displayBook(inputId);
                        } catch (Exception e) {
                            System.out.println("Not a valid id.");
                        }
                        break;

                    case "4": // Display ALL Books
                        System.out.println("Displaying all books:\n");
                        myLibrary.displayAllBooks();
                        break;
                }
            } else {
                System.out.println("Exiting by user selection...");

                //Will end program when False
                isRunning = false;
            }
        }

    }
}