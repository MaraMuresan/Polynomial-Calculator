package org.example;

import org.example.view.CalculatorView;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new CalculatorView("Polynomial Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.pack();
        frame.setBounds(400, 200, 900, 550);
        frame.getContentPane().setBackground(Color.PINK);
        frame.setVisible(true);
    }
}