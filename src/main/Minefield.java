package main;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Minefield {

    private MyPanel[][] mineField;
    private Random rand = new Random();

    public Minefield(MyPanel[][] mineField) {

        this.mineField = mineField;
        for (int i = 0; i <= mineField.length - 1; i++) {
            for (int j = 0; j <= mineField[i].length - 1; j++) {
                int randNumber = rand.nextInt(7);
                if (1 == randNumber) {
                    mineField[i][j].setMine(true);

                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            try {
                                if (!(k == i && l == j)) {
                                    mineField[k][l].setMineCount(mineField[k][l].getMineCount() + 1);
                                }

                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                            ;
                        }
                    }

                } else {
                    mineField[i][j].setMine(false);
                }

                if (i <= mineField.length - 2) {
                    mineField[i][j].setNextPanels(0, mineField[i + 1][j]);
                }

                if (i > 0) {
                    mineField[i][j].setNextPanels(2, mineField[i - 1][j]);
                }

                if (j <= mineField[i].length - 2) {
                    mineField[i][j].setNextPanels(1, mineField[i][j + 1]);
                }

                if (j > 0) {
                    mineField[i][j].setNextPanels(3, mineField[i][j - 1]);
                }


            }
        }
    }

}
