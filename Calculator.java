public class Calculator {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two doubles
    public double add(double a, double b) {
        return a + b;
    }

    // Overloaded method to concatenate two strings
    public String concatenate(String str1, String str2) {
        return str1 + str2;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int sum1 = calculator.add(5, 3);
        System.out.println("Sum of two integers: " + sum1);

        int sum2 = calculator.add(2, 4, 6);
        System.out.println("Sum of three integers: " + sum2);

        double sum3 = calculator.add(2.5, 3.7);
        System.out.println("Sum of two doubles: " + sum3);

        String result = calculator.concatenate("Hello, ", "world!");
        System.out.println("Concatenated string: " + result);
    }
}
