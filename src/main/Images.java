package main;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Images {

    public Images() {

    }

    public ImageIcon getIMage(int imageCode, int width, int height) {
        switch (imageCode) {
            case 1 :
                return new ImageIcon(getImageIcon("pictures/pixel 1.png",this).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

            case 2 :
                return new ImageIcon(getImageIcon("pictures/pixel 2.png",this).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

            case 3 :
                return new ImageIcon(getImageIcon("pictures/pixel 3.png",this).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

            case 4 :
                return new ImageIcon(getImageIcon("pictures/pixel 4.png",this).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

            case 5 :
                return new ImageIcon(getImageIcon("pictures/pixel 5.png",this).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

            case 6 :
                return new ImageIcon(getImageIcon("pictures/pixel 6.png",this).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

            case 7 :
                return new ImageIcon(getImageIcon("pictures/pixel 7.png",this).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

            case 8 :
                return new ImageIcon(getImageIcon("pictures/pixel 8.png",this).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

            case 9 :
                return new ImageIcon(getImageIcon("pictures/pixel mine.png",this).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

            case 10 :
                return new ImageIcon(getImageIcon("pictures/pixel bomb.png",this).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

            case 11 :
                return new ImageIcon(getImageIcon("pictures/pixel empty.png",this).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));

            case 12 :
                return new ImageIcon(getImageIcon("pictures/pixel boom 2.png",this).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));


            default :
                return null;

        }
    }

    static ImageIcon getImageIcon(String name, Object instance) {
        ImageIcon icon = null;
        try {
            icon = new ImageIcon(Objects.requireNonNull(instance.getClass().getClassLoader().getResource(name)));
        } catch (NullPointerException e) {
            System.out.println("Not all resource files were found.");
            System.exit(1);
        }
        return icon;
    }
}
