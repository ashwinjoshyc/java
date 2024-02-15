// Abstract class
abstract class Shape {
    // Abstract method (no implementation)
    public abstract double calculateArea();
}

// Concrete subclass implementing the abstract method
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Implementation of the abstract method
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

public class Main {
    public static void main(String[] args) {
        // Cannot instantiate Shape directly, but can instantiate its subclass Circle
        Circle circle = new Circle(5.0);
        System.out.println("Area of the circle: " + circle.calculateArea());
    }
}
