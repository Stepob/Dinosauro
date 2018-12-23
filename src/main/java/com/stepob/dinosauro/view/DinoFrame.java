package com.stepob.dinosauro.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DinoFrame extends JFrame implements PropertyChangeListener {

    public DinoFrame(String title) throws HeadlessException {
        super(title);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        tabbedPane.addTab("Dino", getDinoPanel());

        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        setJMenuBar(new DinoMenu());

        //Display the window.
        pack();
        setVisible(true);
    }


    private JPanel getDinoPanel() {
        final JPanel dinoPanel = new JPanel(new BorderLayout());

        final ScrollCanvas scrollCanvas = new ScrollCanvas(true);
        dinoPanel.add(scrollCanvas, BorderLayout.CENTER);

        JButton upButton = new JButton("U");
        JButton downButton = new JButton("D");
        JButton leftButton = new JButton("L");
        JButton rightButton = new JButton("R");

        upButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scrollCanvas.imgUp();
            }
        });
        downButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scrollCanvas.imgDown();
            }
        });
        leftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scrollCanvas.imgLeft();
            }
        });
        rightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scrollCanvas.imgRight();
            }
        });


        JPanel southPanel = new JPanel(new GridLayout(3, 3));
        southPanel.add(new JPanel());
        southPanel.add(upButton);
        southPanel.add(new JPanel());
        southPanel.add(leftButton);
        southPanel.add(new JPanel());
        southPanel.add(rightButton);
        southPanel.add(new JPanel());
        southPanel.add(downButton);
        southPanel.add(new JPanel());

        dinoPanel.add(southPanel, BorderLayout.SOUTH);

        return dinoPanel;
    }

    public void propertyChange(PropertyChangeEvent evt) {
    }
}
