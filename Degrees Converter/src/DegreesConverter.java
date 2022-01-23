import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class DegreesConverter implements ActionListener {
    JFrame frame;
    String[] degrees = {"Celsius", "Fahrenheit", "Kelvin", "Rankine"};
    JComboBox degreesOne;
    JTextField inputDegree;
    JButton submitButton;
    double inputtedDegrees;
    JLabel finalResult, titleText, equalText;
    JComboBox degreesTwo = new JComboBox(degrees);
    Font textFont = new Font("Calibri", Font.PLAIN, 35);
    Font smallTextFont = new Font("Calibri", Font.PLAIN, 20);
    Object[] options = {"Okay"};

    DegreesConverter() {
        submitButton = new JButton("Convert");
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitButton.setBounds(180, 300, 100, 50);

        finalResult = new JLabel();
        finalResult.setFont(smallTextFont);
        finalResult.setBounds(100, 400, 350, 50);

        equalText = new JLabel(" To: ");
        equalText.setFont(smallTextFont);
        equalText.setBounds(200, 200, 50, 50);

        titleText = new JLabel("Convert degrees");
        titleText.setBounds(110, 100, 500, 50);
        titleText.setFont(textFont);

        inputDegree = new JTextField();
        inputDegree.setBounds(10, 200, 50, 50);

        degreesOne = new JComboBox(degrees);
        degreesOne.setBounds(60, 200, 100, 50);

        degreesTwo = new JComboBox(degrees);
        degreesTwo.setBounds(300, 200, 100, 50);

        frame = new JFrame("Degrees Converter");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setBackground(Color.white);
        frame.setSize(new Dimension(500, 500));

        frame.add(degreesOne);
        frame.add(degreesTwo);
        frame.add(submitButton);
        frame.add(inputDegree);
        frame.add(titleText);
        frame.add(equalText);
        frame.add(finalResult);
        frame.setVisible(true);
    }
    public double celsiusToFahrenheit(double celsius) {
        return 1.8 * celsius + 32;
    }
    public double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
    public double celsiusToRankine(double celsius) {
        return (celsius + 273.15) * 1.8;
    }

    public double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }
    public double kelvinToFahrenheit(double kelvin) {
        return 1.8 * kelvin - 459.67;
    }
    public double kelvinToRankine(double kelvin) {
        return (kelvin) *1.8;
    }

    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) *  0.555555555556;
    }
    public double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit + 459.67) * 0.555555555556;
    }
    public double fahrenheitToRankine(double fahrenheit) {
        return fahrenheit + 459.67;
    }

    public double rankineToCelsius(double rankine) {
        return (rankine - 491.67) * 0.555555555556;
    }
    public double rankineToKelvin(double rankine) {
        return rankine * 0.555555555556;
    }
    public double rankineToFahrenheit(double rankine) {
        return (rankine) -459.67;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String typeOfDegreeOne = (String) degreesOne.getSelectedItem();
            String typeOfDegreeTwo = (String) degreesTwo.getSelectedItem();
            String stringDegrees = inputDegree.getText();

            try {
                inputtedDegrees = Double.parseDouble(stringDegrees);
            } catch (NumberFormatException ae) {
                JOptionPane.showOptionDialog(null, "Invalid input.", "Error",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
                        options[0]);
                inputDegree.setText("");
                finalResult.setText("");
                return;
            }

            if (typeOfDegreeOne.equals(typeOfDegreeTwo)) {
                finalResult.setText(stringDegrees + " degrees " + typeOfDegreeTwo);
            }
            if (typeOfDegreeOne.equals("Celsius")) {
                if (typeOfDegreeTwo.equals("Fahrenheit")) {
                    finalResult.setText("" + celsiusToFahrenheit(inputtedDegrees) + " degrees "
                            + typeOfDegreeTwo);
                }
                if (typeOfDegreeTwo.equals("Kelvin")) {
                    finalResult.setText(
                            "" + celsiusToKelvin(inputtedDegrees) + " degrees " + typeOfDegreeTwo);
                }
                if (typeOfDegreeTwo.equals("Rankine")) {
                    finalResult.setText("" + celsiusToRankine(inputtedDegrees) + " degrees "
                            + typeOfDegreeTwo);
                }
            }
            if (typeOfDegreeOne.equals("Kelvin")) {
                if (typeOfDegreeTwo.equals("Celsius")) {
                    finalResult.setText(
                            "" + kelvinToCelsius(inputtedDegrees) + " degrees " + typeOfDegreeTwo);
                }
                if (typeOfDegreeTwo.equals("Fahrenheit")) {
                    finalResult.setText(
                            kelvinToFahrenheit(inputtedDegrees) + " degrees " + typeOfDegreeTwo);
                }
                if (typeOfDegreeTwo.equals("Rankine")) {
                    finalResult.setText(
                            "" + kelvinToRankine(inputtedDegrees) + " degrees " + typeOfDegreeTwo);
                }
            }
            if (typeOfDegreeOne.equals("Fahrenheit")) {
                if (typeOfDegreeTwo.equals("Celsius")) {
                    finalResult.setText("" + fahrenheitToCelsius(inputtedDegrees) + " degrees "
                            + typeOfDegreeTwo);
                }
                if (typeOfDegreeTwo.equals("Kelvin")) {
                    finalResult.setText("" + fahrenheitToKelvin(inputtedDegrees) + " degrees "
                            + typeOfDegreeTwo);
                }
                if (typeOfDegreeTwo.equals("Rankine")) {
                    finalResult.setText("" + fahrenheitToRankine(inputtedDegrees) + " degrees "
                            + typeOfDegreeTwo);
                }
            }
            if (typeOfDegreeOne.equals("Rankine")) {
                if (typeOfDegreeTwo.equals("Celsius")) {
                    finalResult.setText("" + rankineToCelsius(inputtedDegrees) + " degrees "
                            + typeOfDegreeTwo);
                }
                if (typeOfDegreeTwo.equals("Kelvin")) {
                    finalResult.setText(
                            "" + rankineToKelvin(inputtedDegrees) + " degrees " + typeOfDegreeTwo);
                }
                if (typeOfDegreeTwo.equals("Fahrenheit")) {
                    finalResult.setText("" + rankineToFahrenheit(inputtedDegrees) + " degrees "
                            + typeOfDegreeTwo);
                }
            }
        }
    }
}