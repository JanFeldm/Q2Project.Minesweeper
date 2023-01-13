package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame{

    private int gameSize = 15; // size of the minefield (gameSize x gameSize)
    private MyPanel[][] fields = new MyPanel[gameSize][gameSize];
    private JFrame frame;
    public Frame(String name){

        super(name);

        Dimension screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
        setSize(600,600);
        setLocation(screenSize.width/2 - getWidth()/2 ,screenSize.height/2 -getHeight()/2);
        setResizable(true);
        setMinimumSize(new Dimension(550,600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);



        add(mainPanel);



        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
        mainPanel.add(topPanel,BorderLayout.PAGE_START);

        JButton resetButton = new JButton();
        resetButton.setText("reset");
        topPanel.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Frame newFrame = new Frame("Mine Sweeper");
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.darkGray);
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

        setVisible(true);



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
