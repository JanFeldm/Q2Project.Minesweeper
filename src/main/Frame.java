package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame{

    private int gameSize = 5;
    private MyPanel[][] fields = new MyPanel[gameSize][gameSize];
    private JFrame frame;
    public Frame(){


        frame = new JFrame("Mine Sweeper");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(600,600);
        frame.setResizable(true);
        frame.setMinimumSize(new Dimension(550,600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);



        frame.add(mainPanel);



        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
        mainPanel.add(topPanel,BorderLayout.PAGE_START);

        JButton resetButton = new JButton();
        resetButton.setText("reset");
        topPanel.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                Frame newFrame = new Frame();
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
        mainPanel.add(bottomPanel,BorderLayout.PAGE_END);

        JPanel mineField = new JPanel(new GridLayout(gameSize,gameSize,50/gameSize,50/gameSize));
        mineField.setPreferredSize(new Dimension(500,500));
        mineField.setBackground(Color.BLACK);

        bottomPanel.add(mineField);



        for(int i = 0; i <= gameSize-1;i++){

            for(int j = 0; j <= gameSize-1;j++){
                fields[i][j] = new MyPanel(i,j,this);
                mineField.add(fields[i][j]);
            }
        }
        Minefield mines = new Minefield(fields);

        frame.setVisible(true);



    }

    public boolean isGameOver() {
        boolean isGameOver = false;
        for (MyPanel[] xFields : fields) {
            for (MyPanel yField : xFields) {
                if(yField.isGameOver()) {
                    isGameOver = true;
                }
            }
        }
        return isGameOver;
    }

    public MyPanel[][] getFields (){
        return fields;
    }

    public MyPanel getFieldAt(int x,int y){
        return fields[x][y];
    }


}
