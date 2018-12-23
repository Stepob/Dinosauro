package com.stepob.dinosauro.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DinoFrame extends JFrame implements PropertyChangeListener {

    private ScrollCanvas scrollCanvas;

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

        scrollCanvas = new ScrollCanvas(true);

        scrollCanvas.setFocusable(true);
        scrollCanvas.requestFocus();

        dinoPanel.add(scrollCanvas, BorderLayout.CENTER);

        JButton upButton = new JButton("U");
        JButton downButton = new JButton("D");
        JButton leftButton = new JButton("L");
        JButton rightButton = new JButton("R");
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

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

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Thread t = new Thread(scrollCanvas);
                t.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                scrollCanvas.stop();
            }
        });

        JPanel southPanel = new JPanel(new GridLayout(4, 3));
        southPanel.add(new JPanel());
        southPanel.add(upButton);
        southPanel.add(new JPanel());
        southPanel.add(leftButton);
        southPanel.add(new JPanel());
        southPanel.add(rightButton);
        southPanel.add(new JPanel());
        southPanel.add(downButton);
        southPanel.add(new JPanel());
        southPanel.add(startButton);
        southPanel.add(stopButton);
        southPanel.add(new JPanel());

        dinoPanel.add(southPanel, BorderLayout.SOUTH);

        return dinoPanel;
    }

    public void propertyChange(PropertyChangeEvent evt) {
    }
}
