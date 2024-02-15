import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class BankManagementSystem extends JFrame {
    private JTextField employeeIdField, nameField, ageField, designationField, departmentField;
    private JButton registerButton, searchByNameButton, searchByDepartmentButton;
    private JTextArea resultArea;

    public BankManagementSystem() {
        setTitle("Bank Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2, 10, 10));

        add(new JLabel("Employee ID:"));
        employeeIdField = new JTextField();
        add(employeeIdField);

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Age:"));
        ageField = new JTextField();
        add(ageField);

        add(new JLabel("Designation:"));
        designationField = new JTextField();
        add(designationField);

        add(new JLabel("Department/Section:"));
        departmentField = new JTextField();
        add(departmentField);

        registerButton = new JButton("Register");
        add(registerButton);
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerEmployee();
            }
        });

        add(new JLabel(""));
        add(new JLabel(""));

        add(new JLabel("Search by Name:"));
        searchByNameButton = new JButton("Search");
        add(searchByNameButton);
        searchByNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchByName();
            }
        });

        add(new JLabel("Search by Department:"));
        searchByDepartmentButton = new JButton("Search");
        add(searchByDepartmentButton);
        searchByDepartmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchByDepartment();
            }
        });

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane);

        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void registerEmployee() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            String query = "INSERT INTO Bank (EmployeeID, Name, Age, Designation, Department) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employeeIdField.getText());
            preparedStatement.setString(2, nameField.getText());
            preparedStatement.setInt(3, Integer.parseInt(ageField.getText()));
            preparedStatement.setString(4, designationField.getText());
            preparedStatement.setString(5, departmentField.getText());

            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(this, "Employee registered successfully.");

            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error registering employee.");
        }
    }

    private void searchByName() {
        String name = JOptionPane.showInputDialog(this, "Enter Name:");
        search("Name", name);
    }

    private void searchByDepartment() {
        String department = JOptionPane.showInputDialog(this, "Enter Department:");
        search("Department", department);
    }

    private void search(String columnName, String value) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            String query = "SELECT * FROM Bank WHERE " + columnName + "=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, value);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultArea.setText("");
            while (resultSet.next()) {
                resultArea.append("Employee ID: " + resultSet.getString("EmployeeID") + "\n");
                resultArea.append("Name: " + resultSet.getString("Name") + "\n");
                resultArea.append("Age: " + resultSet.getInt("Age") + "\n");
                resultArea.append("Designation: " + resultSet.getString("Designation") + "\n");
                resultArea.append("Department: " + resultSet.getString("Department") + "\n\n");
            }

            preparedStatement.close();
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error searching for employee.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BankManagementSystem();
            }
        });
    }
}
