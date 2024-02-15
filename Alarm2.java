import java.util.Scanner;

class Alarm {
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void visualize() {
        System.out.println("Visualization: " + message);
    }

    public void checkTemperature(int temperature) {
        if (temperature > 150) {
            setMessage("Danger: High Temperature Detected! Temperature is above 150.");
        } else {
            setMessage("Temperature is within safe limits.");
        }
    }
}

public class Alarm2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Alarm alarmSystem = new Alarm();

        System.out.print("Enter the current temperature: ");
        int temperature = scanner.nextInt();

        alarmSystem.checkTemperature(temperature);
        alarmSystem.visualize();
    }
}
