// Interface to represent a check on weather conditions
interface WeatherConditionCheck {
    boolean checkCondition(WeatherReport weatherReport, int threshold);
}

// WeatherReport class with modifications
class WeatherReport {
    private String location;
    private int temperature;

    public WeatherReport(String location, int temperature) {
        this.location = location;
        this.temperature = temperature;
    }

    public String getLocation() {
        return location;
    }

    public int getTemperature() {
        return temperature;
    }
}

public class WeatherAppLambdaCheck {
    public static void main(String[] args) {
        // Creating WeatherReport instances
        WeatherReport sunnyWeather = new WeatherReport("City1", 30);
        WeatherReport rainyWeather = new WeatherReport("City2", 15);

        // Lambda expressions to check weather conditions
        WeatherConditionCheck hotWeatherCheck = (weatherReport, threshold) -> weatherReport.getTemperature() > threshold;
        WeatherConditionCheck popularLocationCheck = (weatherReport, threshold) -> weatherReport.getLocation().contains("City1");

        // Checking weather conditions
        int temperatureThreshold = 25;

        System.out.println("Is it hot in City1? " + hotWeatherCheck.checkCondition(sunnyWeather, temperatureThreshold));
        System.out.println("Is it hot in City2? " + hotWeatherCheck.checkCondition(rainyWeather, temperatureThreshold));

        System.out.println("Is City1 a popular location? " + popularLocationCheck.checkCondition(sunnyWeather, temperatureThreshold));
        System.out.println("Is City2 a popular location? " + popularLocationCheck.checkCondition(rainyWeather, temperatureThreshold));
    }
}
