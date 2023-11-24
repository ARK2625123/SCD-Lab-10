/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author Arkstar
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SimpleCalculator extends JFrame {
    private JTextField display;
    private double firstOperand;
    private String operator;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (Character.isDigit(command.charAt(0))) {
                display.setText(display.getText() + command);
            } else if (command.equals("C")) {
                display.setText("");
                firstOperand = 0;
                operator = null;
            } else if (command.equals("=")) {
                if (operator != null && !display.getText().isEmpty()) {
                    double secondOperand = Double.parseDouble(display.getText());
                    double result = calculate(firstOperand, secondOperand, operator);
                    display.setText(String.valueOf(result));
                }
            } else if ("+-*/".contains(command)) {
                firstOperand = Double.parseDouble(display.getText());
                operator = command;
                display.setText("");
            }
        }
    }

    public double calculate(double a, double b, String op) {
        switch (op) {
            case "+" -> {
                return a + b;
            }
            case "-" -> {
                return a - b;
            }
            case "*" -> {
                return a * b;
            }
            case "/" -> {
                if (b != 0) {
                    return a / b;
                } else {
                    return Double.NaN; // Handle division by zero
                }
            }
            default -> {
                return Double.NaN; // Invalid operator
            }
        }
    }
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleCalculator calculator = new SimpleCalculator();
            calculator.setVisible(true);
        });
    }
}

