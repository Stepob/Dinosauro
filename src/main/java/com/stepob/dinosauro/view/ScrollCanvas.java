package com.stepob.dinosauro.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScrollCanvas extends JPanel implements Runnable, MouseListener, KeyListener {

    private static final long SLEEP_TIME = 1;
    private boolean isScrolling = false;

    private final static String BACKGROUND_FILE_NAME = "sand-background.jpg";
    private final static String DINO_FILE_NAME = "dinosauro.jpg";

    private BufferedImage backgroundImg = null;
    private BufferedImage dinoImg = null;

    private int backgroundImgX = 0;
    private int backgroundImgY = 0;
    private int dinoImgX = 50;
    private int dinoImgY = 80;

    public ScrollCanvas(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
        setPreferredSize(new Dimension(800, 600));
        setSize(new Dimension(800, 600));

        addMouseListener(this);
        addKeyListener(this);

        backgroundImg = loadImage(BACKGROUND_FILE_NAME);
        dinoImg = loadImage(DINO_FILE_NAME);

        revalidate();
        repaint();
    }

    private BufferedImage loadImage(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        File imageFile = new File(classLoader.getResource(fileName).getFile());

        BufferedImage img = null;
        try {
            img = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.out.println("ERROR");
            e.printStackTrace();
        }
        return img;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        setBackground(Color.BLACK);

        g2.drawImage(backgroundImg, null, backgroundImgX, backgroundImgY);
        g2.drawImage(backgroundImg, null, backgroundImgX + 800, backgroundImgY);

        g2.drawImage(dinoImg, null, dinoImgX, 600 - dinoImgY);

    }

    public void run() {

        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        isScrolling = true;

        while (isScrolling) {

            imgLeft();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = SLEEP_TIME - timeDiff;

            if (sleep < 0) {
                sleep = 2;
            }

            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {

            }

            beforeTime = System.currentTimeMillis();
        }
    }

    public void stop() {
        isScrolling = false;
    }


    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked - X: " + e.getX() + ", Y: " + e.getY());
    }

    public void mousePressed(MouseEvent e) {

        System.out.println("Mouse Pressed");
        dinoImgY = 160;
    }

    public void mouseReleased(MouseEvent e) {

        System.out.println("Mouse Released");
        dinoImgY = 80;
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited");
    }

    public void imgUp() {
        backgroundImgY--;
        revalidate();
        repaint();
    }

    public void imgDown() {
        backgroundImgY++;
        revalidate();
        repaint();
    }

    public void imgLeft() {
        backgroundImgX--;
        backgroundImgX = backgroundImgX % 800;
        revalidate();
        repaint();
    }

    public void imgRight() {
        backgroundImgX++;
        revalidate();
        repaint();
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            dinoImgY = 160;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            dinoImgY = 80;
        }
    }
}
