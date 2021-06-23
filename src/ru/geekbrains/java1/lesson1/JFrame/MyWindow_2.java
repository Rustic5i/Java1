package ru.geekbrains.java1.lesson1.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow_2 extends JFrame {

    public MyWindow_2(){
        setSize(500,555);
        setResizable(false);
        setLocation(800,200);
        setTitle("Пиу-пиу");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.orange);
        JPanel panelButt = new JPanel(new GridLayout());
        panelButt.setBackground(Color.BLUE);
        panelButt.setPreferredSize(new Dimension(2,50));
        JButton buttonStart = new JButton("START");
        JButton buttonEnd = new JButton("END");
        panelButt.add(buttonStart);
        panelButt.add(buttonEnd);

        buttonEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });


        add(panel, BorderLayout.CENTER);
        add(panelButt, BorderLayout.SOUTH);




        setVisible(true);
    }
}
