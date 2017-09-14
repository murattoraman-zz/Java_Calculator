package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.String;

public class Calculator_App_Class extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1234;

    private JMenuBar menuBar;
    private JMenu file ;
    private JMenu edit;
    private JMenu help;
    private JMenuItem close;
    private JMenuItem copy;
    private JMenuItem view;
    private JMenuItem about;
    private JTextField display;
    private JButton zero,one,two,three,four,five,six,seven, eight , nine ;
    private JButton clear,dod,plus,equals,negative,multiplication,division;
    private boolean[] operation =new boolean[4];
    private double tempFirst = 0.0;
    private int i;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            JFrame.setDefaultLookAndFeelDecorated(true);
        } catch (Exception e) {
            System.out.println("Could not load System look.");
        }

        new Calculator_App_Class();
    }

    public Calculator_App_Class() {

    super("Calculator_v1.0");
    sendMenuBar();
    sendDisplay();
    sendButtons();
    sendUI(this);

    }

    private void sendMenuBar() {
        menuBar = new JMenuBar();
        file = new JMenu(" File ");
        edit = new JMenu(" Edit ");
        help = new JMenu(" Help ");
        close = new JMenuItem("Close");
        copy = new JMenuItem("Copy");
        view = new JMenuItem("View Help");
        about = new JMenuItem("About Calculator");

        setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);

        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);

            }
        });

        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String tempDisplay = display.getText();
                StringSelection string = new StringSelection(tempDisplay);
                Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
                system.setContents(string,string);
            }
        });

        view.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Errors and deficiencies will be corrected later. " +
                                "\n Contact : \n" + "-> @murat_toramann" + "\n -> murattoraman@protonmail.com","Calculator",JOptionPane.INFORMATION_MESSAGE);
            }
        });

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,"Calculator_v1.0 \n Created by " +
                        "\n @murat_toramann" + "\n Thanks " + "\n StartJavaToday Youtube channel","About",JOptionPane.INFORMATION_MESSAGE);

            }
        });

        file.add(close);
        edit.add(copy);
        help.add(view);
        help.add(about);

    }

    private void sendDisplay() {
        display = new JTextField("0");
        display.setBounds(10,10,324,40);
        display.setEditable(false);
        display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        display.setFont(new Font("Arial",Font.PLAIN,32));
        add(display);
    }

    private void sendButtons() {

        multiplication = new JButton("X");
        multiplication.setBounds(226,210,65,55);
        multiplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().equalsIgnoreCase("0"))
                    return;
                if (display.getText().length() > 13 )
                    return;
                if (display.getText().endsWith("."))
                    display.setText(display.getText().replace(".0",""));

                setTempFirst(Double.parseDouble(display.getText()));
                display.setText("0");
                operation[2] = true;

            }
        });
        add(multiplication);

        division = new JButton("/");
        division.setBounds(226,280,65,55);
        division.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().equalsIgnoreCase("0"))
                    return;
                if (display.getText().length() > 13 )
                    return;
                if (display.getText().endsWith("."))
                    display.setText(display.getText().replace(".0",""));

                setTempFirst(Double.parseDouble(display.getText()));
                display.setText("0");
                operation[3] = true;
            }
        });
        add(division);

        negative = new JButton("-");
        negative.setBounds(226,140,65,55);
        negative.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().equalsIgnoreCase("0"))
                    return;
                if (display.getText().length() > 13 )
                    return;
                if (display.getText().endsWith("."))
                    display.setText(display.getText().replace(".0",""));

                setTempFirst(Double.parseDouble(display.getText()));
                display.setText("0");
                operation[1] = true;
            }
        });
        add(negative);

        plus = new JButton("+");
        plus.setBounds(226,70,65,55);
        plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().equalsIgnoreCase("0")) {
                    return;
                }
                if (display.getText().length() > 13)
                    return;
                if (display.getText().endsWith("."))
                    display.setText(display.getText().replace(".0",""));

                setTempFirst(Double.parseDouble(display.getText()));
                display.setText("0");
                operation[0] = true;
            }
        });
        add(plus);

        dod = new JButton(".");

        dod.setBounds(154,280,65,55);
        dod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().contains(".")){
                    return;
                }
                if (display.getText().length() > 13)
                    return;
                display.setText(display.getText() + ".");
            }
        });
        add(dod);

        clear = new JButton("C");
        clear.setBounds(10,280,65,55);
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                display.setText("0");
                setTempFirst(Double.valueOf(0.0));
                for (i=0;i<=3;i++)
                    operation[i] = false;
            }
        });
        add(clear);

        zero = new JButton("0");
        zero.setBounds(82,280,65,55);
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().equalsIgnoreCase("0")){
                    display.setText("0");
                    return;
                }
                if (display.getText().length() > 13)
                    return;
                display.setText(display.getText() + "0");
            }
        });
        add(zero);

        one = new JButton("1");
        one.setBounds(154,210,65,55);
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().equalsIgnoreCase("0")){
                    display.setText("1");
                    return;
                }
                if (display.getText().length() > 13)
                    return;
                display.setText(display.getText() + "1");
            }
        });
        add(one);

        two = new JButton("2");
        two.setBounds(82,210,65,55);
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().equalsIgnoreCase("0")){
                    display.setText("2");
                    return;
                }
                if (display.getText().length() > 13)
                    return;
                display.setText(display.getText() + "2");
            }
        });
        add(two);

        three = new JButton("3");
        three.setBounds(10,210,65,55);
        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().equalsIgnoreCase("0")){
                    display.setText("3");
                    return;
                }
                if (display.getText().length() > 13)
                    return;
                display.setText(display.getText() + 3);
            }
        });
        add(three);

        four = new JButton("4");
        four.setBounds(154,140,65,55);
        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().equalsIgnoreCase("0")){
                    display.setText("4");
                    return;
                }
                if (display.getText().length() > 13)
                    return;
                display.setText(display.getText() + "4");
            }
        });
        add(four);

        five = new JButton("5");
        five.setBounds(82,140,65,55);
        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().equalsIgnoreCase("0")){
                    display.setText("5");
                    return;
                }
                if (display.getText().length() > 13)
                    return;
                display.setText(display.getText() + "5");
            }
        });
        add(five);

        six = new JButton("6");
        six.setBounds(10,140,65,55);
        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().equalsIgnoreCase("0")){
                    display.setText("6");
                    return;
                }
                if (display.getText().length() > 13)
                    return;
                display.setText(display.getText() + "6");
            }
        });
        add(six);

        seven = new JButton("7");
        seven.setBounds(10,70,65,55);
        seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (display.getText().length() > 13)
                    return;
                if (display.getText().equalsIgnoreCase("0")){
                    display.setText("7");
                    return;
                }
                else
                display.setText(display.getText()+"7");
            }
        });
        add(seven);

        eight = new JButton("8");
        eight.setBounds(82,70,65,55);
        eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().length() > 13)
                    return;
                if (display.getText().equalsIgnoreCase("0")){
                    display.setText("8");
                    return;
                }
                display.setText(display.getText()+"8");
            }
        });
        add(eight);

        nine = new JButton("9");
        nine.setBounds(154,70,65,55);
        nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (display.getText().length() > 13)
                    return;
                if (display.getText().equalsIgnoreCase("0")){
                    display.setText("9");
                    return;
                }
                display.setText(display.getText()+"9");
            }
        });
        add(nine);

        equals = new JButton("=");
        equals.setBounds(298,70,65,265);
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (operation[0]){
                    display.setText(Double.toString(getTempFirst() + Double.parseDouble(display.getText())));
                }
                else if (operation[1]){
                    display.setText(Double.toString(getTempFirst() - Double.parseDouble(display.getText())));
                }
                else if (operation[2]){
                    display.setText(Double.toString(getTempFirst() * Double.parseDouble(display.getText())));
                }
                else if (operation[3]){
                    display.setText(Double.toString(getTempFirst() / Double.parseDouble(display.getText())));
                }

                if (display.getText().endsWith(".0"))
                    display.setText(display.getText().replace(".0",""));

                if (display.getText().length() > 13)
                    return;

                setTempFirst(0);
                for (i=0;i<=3;i++)
                    operation[i] = false;
            }
        });
        add(equals);
            }

    private void sendUI(Calculator_App_Class app1) {

        app1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app1.setSize(400,400);
        app1.setResizable(false);
        app1.setLayout(null);
        app1.setLocationRelativeTo(null);
        app1.setVisible(true);

    }

    public double getTempFirst() {
        return tempFirst;
    }

    public void setTempFirst(double tempFirst) {
        this.tempFirst = tempFirst;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

    }
}
