// Interface to represent a check on book availability
interface BookAvailability {
    boolean checkAvailability(Book book, int numberOfCopies);
}

// Book class with modifications
class Book {
    private String title;
    private int availableCopies;

    public Book(String title, int availableCopies) {
        this.title = title;
        this.availableCopies = availableCopies;
    }

    public String getTitle() {
        return title;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }
}

public class LibraryBookLambdaCheck {
    public static void main(String[] args) {
        // Creating Book instances
        Book javaProgramming = new Book("Java Programming", 20);
        Book algorithmsBook = new Book("Introduction to Algorithms", 10);

        // Lambda expressions to check book availability
        BookAvailability enoughCopiesCheck = (book, numberOfCopies) -> book.getAvailableCopies() >= numberOfCopies;
        BookAvailability popularBookCheck = (book, numberOfCopies) -> book.getTitle().contains("Java");

        // Checking book availability
        int numberOfCopiesToBorrow = 3;

        System.out.println("Enough copies available for Java Programming? " + enoughCopiesCheck.checkAvailability(javaProgramming, numberOfCopiesToBorrow));
        System.out.println("Enough copies available for Introduction to Algorithms? " + enoughCopiesCheck.checkAvailability(algorithmsBook, numberOfCopiesToBorrow));

        System.out.println("Is Java Programming a popular book? " + popularBookCheck.checkAvailability(javaProgramming, numberOfCopiesToBorrow));
        System.out.println("Is Introduction to Algorithms a popular book? " + popularBookCheck.checkAvailability(algorithmsBook, numberOfCopiesToBorrow));
    }
}