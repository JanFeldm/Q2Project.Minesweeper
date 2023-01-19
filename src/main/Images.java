package main;

import javax.swing.*;
import java.awt.*;

public class Images {

    public Images() {

    }

    public ImageIcon getIMage(int imageCode, int width, int height) {
        switch (imageCode) {
            case 1 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel 1.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
            case 2 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel 2.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
            case 3 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel 3.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
            case 4 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel 4.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
            case 5 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel 5.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
            case 6 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel 6.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
            case 7 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel 7.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
            case 8 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel 8.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
            case 9 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel mine.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
            case 10 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel bomb.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
            case 11 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel empty.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
            case 12 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel unrevealed.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }
            case 13 -> {
                return new ImageIcon(new ImageIcon("pictures/pixel boom.png").getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
            }

            default -> {
                return null;
            }
        }
    }
}
