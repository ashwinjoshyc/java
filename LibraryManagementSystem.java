
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BookWriter implements Runnable {
    private String bookName;

    public BookWriter(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public void run() {
        try {
            // Simulate some file creation process
            FileWriter fileWriter = new FileWriter(bookName + ".txt");
            fileWriter.write("Content for book: " + bookName);
            fileWriter.close();

            System.out.println("File created for book: " + bookName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Assuming you have a list of books
        String[] books = {"Book1", "Book2", "Book3", "Book4", "Book5"};

        // Create a fixed thread pool with 5 threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Submit tasks for each book
        for (String book : books) {
            executorService.submit(new BookWriter(book));
        }

        // Shutdown the executor service when done
        executorService.shutdown();
    }
}
