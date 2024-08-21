package fr.pompey.dev.afpa.vue.swing;

import javax.swing.*;
import java.awt.*;


class ImagePanel extends JPanel {

    private final Image backgroundImage;

    // Constructor pour charger l'image de fond
    public ImagePanel(String fileName) {
        // Chargement de l'image
        backgroundImage = new ImageIcon(fileName).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessiner l'image en arrière-plan
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}


