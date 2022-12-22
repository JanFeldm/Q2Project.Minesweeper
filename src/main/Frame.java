package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame{

    private int gameSize = 9;
    private MyPanel[][] fields = new MyPanel[gameSize][gameSize];
    private JFrame frame;
    public Frame(){


        frame = new JFrame();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(500,600);
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
                fields[i][j] = new MyPanel(i,j);
                mineField.add(fields[i][j]);
            }
        }
        Minefield mines = new Minefield(fields);

        frame.setVisible(true);



    }

    public MyPanel[][] getFields (){
        return fields;
    }

    public MyPanel getFieldAt(int x,int y){
        return fields[x][y];
    }

}
