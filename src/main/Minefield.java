package main;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Minefield {

    private MyPanel[][] mineField;
    private Random rand = new Random();
    private int allMines = 0;

    public Minefield(MyPanel[][] mineField) {

        this.mineField = mineField;
        for (int i = 0; i <= mineField.length - 1; i++) {
            for (int j = 0; j <= mineField[i].length - 1; j++) {
                int randNumber = rand.nextInt(7); // mine with 1/7 chance
                if (1 == randNumber) {
                    mineField[i][j].setMine(true); // places mine on field
                    allMines++;

                    for (int k = i - 1; k <= i + 1; k++) {
                        for (int l = j - 1; l <= j + 1; l++) {
                            try {
                                if (!(k == i && l == j)) {
                                    mineField[k][l].setMineCount(mineField[k][l].getMineCount() + 1); // increase minecount for neighboring fields
                                }

                            } catch (ArrayIndexOutOfBoundsException ignored) {
                            }
                            ;
                        }
                    }

                } else {
                    mineField[i][j].setMine(false);
                }

                // adding the surrounding minefields to nextFields

                if (i <= mineField.length - 2) { // north
                    mineField[i][j].setNextPanels(0, mineField[i + 1][j]);
                }

                if (i <= mineField.length - 2 && j <= mineField[i].length - 2) {  //northeast
                    mineField[i][j].setNextPanels(1, mineField[i + 1][j + 1]);
                }

                if (j <= mineField[i].length - 2) { //east
                    mineField[i][j].setNextPanels(2, mineField[i][j + 1]);
                }

                if (j <= mineField[i].length - 2 && i > 0) { // southeast
                    mineField[i][j].setNextPanels(3, mineField[i - 1][j + 1]);
                }

                if (i > 0) { //south
                    mineField[i][j].setNextPanels(4, mineField[i - 1][j]);
                }

                if (i > 0 && j > 0) { // southwest
                    mineField[i][j].setNextPanels(5, mineField[i - 1][j - 1]);
                }

                if (j > 0) { //west
                    mineField[i][j].setNextPanels(6, mineField[i][j - 1]);
                }

                if (i <= mineField.length - 2 && j > 0) { //northwest
                    mineField[i][j].setNextPanels(7, mineField[i + 1][j - 1]);
                }


            }
        }
    }

    public int getallMines(){
        return allMines;
    }

}
