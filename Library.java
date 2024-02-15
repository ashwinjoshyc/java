import java.util.ArrayList;
import java.util.List;

// Generic class representing a Book
class Book<T> {
    private T bookInfo;

    public Book(T bookInfo) {
        this.bookInfo = bookInfo;
    }

    public T getBookInfo() {
        return bookInfo;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookInfo=" + bookInfo +
                '}';
    }
}

// Generic interface for Library management
interface LibraryManager<T> {
    void addBook(Book<T> book);

    List<Book<T>> getAllBooks();
}

// Library class implementing LibraryManager interface for a specific type of book information (e.g., String)
class Library<T> implements LibraryManager<T> {
    private List<Book<T>> books = new ArrayList<>();

    @Override
    public void addBook(Book<T> book) {
        books.add(book);
        System.out.println("Book added to the library: " + book);
    }

    @Override
    public List<Book<T>> getAllBooks() {
        return books;
    }
}

public class Library {
    public static void main(String[] args) {
        // Create a library for String-based book information
        Library<String> stringLibrary = new Library<>();

        // Add books to the library
        stringLibrary.addBook(new Book<>("Introduction to Java"));
        stringLibrary.addBook(new Book<>("Data Structures and Algorithms"));

        // Get all books in the library
        List<Book<String>> allBooks = stringLibrary.getAllBooks();
        System.out.println("All Books in the Library: " + allBooks);
    }
}
