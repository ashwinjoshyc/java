import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WeatherReporter1 implements Runnable {
    private String location;

    public WeatherReporter1(String location) {
        this.location = location;
    }

    @Override
    public void run() {
        try {
            // Simulate some weather reporting process
            FileWriter fileWriter = new FileWriter(location + "_weather.txt");
            fileWriter.write("Weather report for location: " + location);
            fileWriter.close();

            System.out.println("Weather report created for location: " + location);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class WeatherApp1 {
    public static void main(String[] args) {
        // Assuming you have a list of locations
        String[] locations = {"City1", "City2", "City3", "City4", "City5"};

        // Create a fixed thread pool with 5 threads
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Submit tasks for each location
        for (String location : locations) {
            executorService.submit(new WeatherReporter1(location));
        }

        // Shutdown the executor service when done
        executorService.shutdown();
    }
}
