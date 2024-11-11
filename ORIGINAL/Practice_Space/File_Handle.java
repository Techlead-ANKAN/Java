import java.io.*;
import java.util.Scanner;

public class File_Handle{
    public static void main(String[] args) {
        String fileName = "example.txt";
        String content = "Hello, this is a sample text written to the file.";

        // Step 1: Create and write to the file
        createAndWriteFile(fileName, content);

        // Step 2: Read file using FileReader
        System.out.println("\nReading file using FileReader:");
        readFileUsingFileReader(fileName);

        // Step 3: Read file using BufferedReader
        System.out.println("\nReading file using BufferedReader:");
        readFileUsingBufferedReader(fileName);

        // Step 4: Read file using Scanner
        System.out.println("\nReading file using Scanner:");
        readFileUsingScanner(fileName);
    }

    // Method to create and write to the file
    public static void createAndWriteFile(String fileName, String content) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(content);
            System.out.println("File created and content written successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred during file creation or writing: " + e.getMessage());
        }
    }

    // Method to read file using FileReader
    public static void readFileUsingFileReader(String fileName) {
        try (FileReader fileReader = new FileReader(fileName)) {
            int ch;
            while ((ch = fileReader.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Method to read file using BufferedReader
    public static void readFileUsingBufferedReader(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Method to read file using Scanner
    public static void readFileUsingScanner(String fileName) {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
