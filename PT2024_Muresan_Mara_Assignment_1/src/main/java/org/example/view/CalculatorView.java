package org.example.view;

import org.example.controller.CalculatorController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class CalculatorView extends JFrame{

    private JLabel labelTitle;
    private JLabel labelP1;
    private JLabel labelP2;
    private JLabel labelR;
    private JLabel labelResult;
    private JLabel labelResult2;

    private JTextField textFieldPolynomial1;
    private JTextField textFieldPolynomial2;

    private JButton buttonAdd;
    private JButton buttonSub;
    private JButton buttonMul;
    private JButton buttonDiv;
    private JButton buttonDeriv;
    private JButton buttonIntegr;
    private JButton buttonClear;

    private CalculatorController controller;

    public CalculatorView(String name) {

        super(name);

        controller = new CalculatorController(this);

        labelTitle = new JLabel("Polynomimal Calculator");
        labelTitle.setFont(new Font("Georgia", Font.BOLD, 30));
        labelTitle.setForeground(Color.BLUE);
        labelTitle.setBounds(0, 50, 900, 35);
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setVerticalAlignment(SwingConstants.CENTER);
        add(labelTitle);

        labelP1 = new JLabel("P1:");
        labelP1.setFont(new Font("Georgia", Font.BOLD, 20));
        labelP1.setForeground(Color.BLUE);
        labelP1.setBounds(80, 160, 100, 30);
        add(labelP1);

        textFieldPolynomial1 = new JTextField(60);
        textFieldPolynomial1.setBounds(160, 160, 350, 30);
        textFieldPolynomial1.setFont(new Font("Georgia", Font.BOLD, 15));
        textFieldPolynomial1.setHorizontalAlignment(JTextField.CENTER);
        add(textFieldPolynomial1);

        labelP2 = new JLabel("P2:");
        labelP2.setFont(new Font("Georgia", Font.BOLD, 20));
        labelP2.setForeground(Color.BLUE);
        labelP2.setBounds(80, 240, 100, 30);
        add(labelP2);

        textFieldPolynomial2 = new JTextField(60);
        textFieldPolynomial2.setBounds(160, 240, 350, 30);
        textFieldPolynomial2.setFont(new Font("Georgia", Font.BOLD, 15));
        textFieldPolynomial2.setHorizontalAlignment(JTextField.CENTER);
        add(textFieldPolynomial2);

        labelR = new JLabel("Result:");
        labelR.setFont(new Font("Georgia", Font.BOLD, 20));
        labelR.setForeground(Color.BLUE);
        labelR.setBounds(60, 370, 170, 30);
        add(labelR );

        labelResult = new JLabel();
        labelResult.setFont(new Font("Georgia", Font.BOLD, 20));
        labelResult.setForeground(Color.BLACK);
        labelResult.setBounds(160, 370, 700, 30);
        //labelResult.setHorizontalAlignment(JLabel.CENTER);
        add(labelResult);

        labelResult2 = new JLabel();
        labelResult2.setFont(new Font("Georgia", Font.BOLD, 20));
        labelResult2.setForeground(Color.BLACK);
        labelResult2.setBounds(160, 420, 700, 30);
        //labelResult2.setHorizontalAlignment(JLabel.CENTER);
        add(labelResult2);


        buttonAdd = new JButton("+");
        buttonAdd.setFont(new Font("Georgia", Font.BOLD, 20));
        buttonAdd.setForeground(Color.BLUE);
        buttonAdd.setBounds(620, 120, 50, 50);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelResult.setText("");
                labelResult2.setText("");
                String polynomial1 = textFieldPolynomial1.getText();
                String polynomial2 = textFieldPolynomial2.getText();
                String result = controller.addition(polynomial1,polynomial2);
                labelResult.setText(result);
            }
        });
        add(buttonAdd);

        buttonSub = new JButton("-");
        buttonSub.setFont(new Font("Georgia", Font.BOLD, 20));
        buttonSub.setForeground(Color.BLUE);
        buttonSub.setBounds(720, 120, 50, 50);
        buttonSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelResult.setText("");
                labelResult2.setText("");
                String polynomial1 = textFieldPolynomial1.getText();
                String polynomial2 = textFieldPolynomial2.getText();
                String result = controller.subtraction(polynomial1,polynomial2);
                labelResult.setText(result);
            }
        });
        add(buttonSub);

        buttonMul = new JButton("*");
        buttonMul.setFont(new Font("Georgia", Font.BOLD, 20));
        buttonMul.setForeground(Color.BLUE);
        buttonMul.setBounds(620, 180, 50, 50);
        buttonMul.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelResult.setText("");
                labelResult2.setText("");
                String polynomial1 = textFieldPolynomial1.getText();
                String polynomial2 = textFieldPolynomial2.getText();
                String result = controller.multiplication(polynomial1,polynomial2);
                labelResult.setText(result);
            }
        });
        add(buttonMul);

        buttonDiv = new JButton(":");
        buttonDiv.setFont(new Font("Georgia", Font.BOLD, 20));
        buttonDiv.setForeground(Color.BLUE);
        buttonDiv.setBounds(720, 180, 50, 50);
        buttonDiv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelResult.setText("");
                labelResult2.setText("");
                String polynomial1 = textFieldPolynomial1.getText();
                String polynomial2 = textFieldPolynomial2.getText();
                String[] result = controller.division(polynomial1, polynomial2);
                String quotient = result[0];
                String reminder = result[1];
                labelResult.setText("Q = " + quotient);
                labelResult2.setText("R = " + reminder);
            }
        });
        add(buttonDiv);

        buttonDeriv = new JButton("'");
        buttonDeriv.setFont(new Font("Georgia", Font.BOLD, 20));
        buttonDeriv.setForeground(Color.BLUE);
        buttonDeriv.setBounds(620, 240, 50, 50);
        buttonDeriv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelResult.setText("");
                labelResult2.setText("");
                String polynomial1 = textFieldPolynomial1.getText();
                String polynomial2 = textFieldPolynomial2.getText();
                String result1 = "D1 = " + controller.derivative(polynomial1);
                String result2 = "D2 = " + controller.derivative(polynomial2);
                labelResult.setText(result1);
                labelResult2.setText(result2);
            }
        });
        add(buttonDeriv);

        buttonIntegr = new JButton("∫");
        buttonIntegr.setFont(new Font("Georgia", Font.BOLD, 20));
        buttonIntegr.setForeground(Color.BLUE);
        buttonIntegr.setBounds(720, 240, 50, 50);
        buttonIntegr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelResult.setText("");
                labelResult2.setText("");
                String polynomial1 = textFieldPolynomial1.getText();
                String polynomial2 = textFieldPolynomial2.getText();
                String result1 = "I1 = " + controller.integration(polynomial1);
                String result2 = "I2 = " + controller.integration(polynomial2);
                labelResult.setText(result1);
                labelResult2.setText(result2);
            }
        });
        add(buttonIntegr);

        buttonClear = new JButton("Clear");
        buttonClear.setFont(new Font("Georgia", Font.BOLD, 20));
        buttonClear.setForeground(Color.BLUE);
        buttonClear.setBounds(620, 300, 150, 50);
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldPolynomial1.setText("");
                textFieldPolynomial2.setText("");
                labelResult.setText("");
                labelResult2.setText("");
            }
        });
        add(buttonClear);
    }

}