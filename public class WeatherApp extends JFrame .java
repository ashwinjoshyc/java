import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeatherApp extends JFrame {

    private JRadioButton temperatureRadioButton, humidityRadioButton;
    private JTextField cityTextField;

    public WeatherApp() {
        super("Weather App");

        // Create radio buttons
        temperatureRadioButton = new JRadioButton("Temperature");
        humidityRadioButton = new JRadioButton("Humidity");

        // Create text field
        cityTextField = new JTextField(20);

        // Group radio buttons
        ButtonGroup metricGroup = new ButtonGroup();
        metricGroup.add(temperatureRadioButton);
        metricGroup.add(humidityRadioButton);

        // Create submit button
        JButton submitButton = new JButton("Get Weather");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayWeatherDetails();
            }
        });

        // Create layout using GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Add components to the layout
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Select Metric:"), gbc);

        gbc.gridy++;
        add(temperatureRadioButton, gbc);

        gbc.gridy++;
        add(humidityRadioButton, gbc);

        gbc.gridy++;
        add(new JLabel("Enter City:"), gbc);

        gbc.gridy++;
        add(cityTextField, gbc);

        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        add(submitButton, gbc);

        // Set default metric selection
        temperatureRadioButton.setSelected(true);

        // Set default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set default size and visibility
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void displayWeatherDetails() {
        String metric = temperatureRadioButton.isSelected() ? "Temperature" : "Humidity";
        String city = cityTextField.getText();

        // Perform API call or data retrieval to get actual weather information
        // For simplicity, we just display a message with the entered data
        JOptionPane.showMessageDialog(this,
                "City: " + city + "\n" +
                        "Selected Metric: " + metric + "\n" +
                        "Weather Data: (Actual data retrieval not implemented in this example)",
                "Weather Details",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WeatherApp();
            }
        });
    }
}
