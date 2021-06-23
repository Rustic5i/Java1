package ru.geekbrains.java1.lesson1.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyWindow extends JFrame {

    public MyWindow(){
        setTitle("Супер-пупер Приложиение");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500,500,400,400);
        JButton[] jbs = new JButton[5];
        for (int i = 0; i < jbs.length; i++) {
            jbs[i] = new JButton(" "+i);
        }
        setLayout(new FlowLayout());
        JLabel lb = new JLabel("Label");
        JTextField test = new JTextField(25);
        add(lb);
        add(test);
        add(jbs[0]);

        jbs[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Нажали кнопку");
            }
        });
        test.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Нажали Entr");
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.out.println("Щелк по мышки");
            }
        });

        setVisible(true);
    }
}
