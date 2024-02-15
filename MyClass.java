public class MyClass {
    // Instance variables
    private int number;
    private String text;

    // Default constructor (no parameters)
    public MyClass() {
        number = 0;
        text = "Default Text";
    }

    // Method to display values
    public void display() {
        System.out.println("Number: " + number);
        System.out.println("Text: " + text);
    }

    public static void main(String[] args) {
        // Creating an object of MyClass using the default constructor
        MyClass obj = new MyClass();

        // Calling the display method to show the values
        obj.display();
    }
}
