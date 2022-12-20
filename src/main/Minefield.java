package main;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Minefield {

    private Random rand = new Random();
    public Minefield(MyPanel[][] mineField){

        for(int i = 0;i<=mineField.length-1;i++){
            for(int j = 0;j<=mineField[i].length-1;j++){
                int randNumber = rand.nextInt(5);
                if(1 ==randNumber){
                    mineField[i][j].setMine(true);

                    for(int k = i-1;k<=i+1;k++){
                        for(int l = j-1;l<=j+1;l++){
                            try {
                                if (!(k == i && l == j)) {
                                    mineField[k][l].setMineCount(mineField[k][l].getMineCount() + 1);
                                }
                            }catch(ArrayIndexOutOfBoundsException ignored){};
                        }
                    }

                }else{
                    mineField[i][j].setMine(false);



                }
            }
        }





    }
}
