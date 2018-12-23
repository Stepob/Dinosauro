package com.stepob.dinosauro;

import com.stepob.dinosauro.view.DinoFrame;

/**
 * Hello world!
 */
public class App {

    private static void createAndShowGUI() {
        new DinoFrame("Stepob - Dino");
    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() {
                        /*try {
                            handleSplash();
                        } catch (Exception e) {
                            e.printStackTrace();
                            System.exit(1);
                        }*/
                        createAndShowGUI();
                    }

                    /*private void handleSplash() {
                        SplashScreen splash = SplashScreen.getSplashScreen();
                        if (splash != null) {
                            Graphics2D graphics = splash.createGraphics();
                            if (graphics != null) {
                                drawInSplash(splash, graphics);
                            } else {
                                logger.error("graphics is null");
                            }
                        }
                    }*/

                    /*private void drawInSplash(SplashScreen splash, Graphics2D g) {
                        Rectangle splashBounds = splash.getBounds();

                        logger.debug("splashbounds: " + splashBounds);

                        g.setComposite(AlphaComposite.Clear);
                        g.setPaintMode();
                        g.setColor(Color.BLACK);

                        splash.update();
                    }*/
                });
    }
}
