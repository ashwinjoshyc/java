public class Example {
    // Method with return type int
    public int add(int a, int b) {
        return a + b;
    }

    // Method with return type double
    public double divide(int numerator, int denominator) {
        // Check if denominator is not zero to avoid division by zero
        if (denominator != 0) {
            return (double) numerator / denominator;
        } else {
            // Handle division by zero error
            System.out.println("Error: Division by zero.");
            return 0.0;
        }
    }

    public static void main(String[] args) {
        Example example = new Example();

        // Calling a method with return type int
        int sum = example.add(5, 3);
        System.out.println("Sum: " + sum);

        // Calling a method with return type double
        double result = example.divide(10, 2);
        System.out.println("Result of division: " + result);
    }
}
