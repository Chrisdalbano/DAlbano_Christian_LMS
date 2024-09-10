import java.io.*;

public class FileHandler {
    private final File bookFile;

    // Constructor for FileHandler
    public FileHandler(String fileLocation) {
        // Initializing file location and file object
        this.bookFile = new File(fileLocation);
    }

    // Method to read the file content and return as a String
    public String readFileContents() throws IOException {
        StringBuilder content = new StringBuilder();

        // ensuring BufferedReader closes properly
        try (BufferedReader br = new BufferedReader(new FileReader(bookFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new IOException("Error reading the file: " + e.getMessage(), e);
        }

        return content.toString(); // Return the file content as a single String
    }
}
