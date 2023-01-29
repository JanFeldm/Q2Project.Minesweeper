package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame{

    private int gameSize; // size of the minefield (gameSize x gameSize)
    private MyPanel[][] fields;
    private JFrame frame;
    private Minefield mines;
    private int allMines;
    private JPanel mineField;
    private JLabel mineLabel;

    private JPanel mainPanel;

    private JPanel topPanel;
    private JButton resetButton;
    private GridLayout gridLayout;
    private JButton chooseDifficulty;

    private JPanel bottomPanel;

    public Frame(String name,int gameSize,Dimension size,int x,int y) {

        super(name);
        setSize(size);
        setLocation(x,y);
        setResizable(true);
        setMinimumSize(new Dimension(400, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.gameSize = gameSize;
        fields = new MyPanel[gameSize][gameSize];

        //minefield
        gridLayout = new GridLayout(gameSize, gameSize, 1+50 / gameSize, 1+50 / gameSize);
        mineField = new JPanel(gridLayout);
        if(getWidth()>getHeight()){
            mineField.setPreferredSize(new Dimension(getHeight()-100, getHeight()-100));
        }else{
            mineField.setPreferredSize(new Dimension(getWidth()-100, getWidth()-100));
        }

        mineField.setBackground(Color.BLACK);

        createPanels();
        allMines = mines.getallMines();

        topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);


        mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);
        mainPanel.add(topPanel, BorderLayout.PAGE_START);
        add(mainPanel);


        //reset button
        resetButton = new JButton();
        resetButton.setText("RESET");
        resetButton.setBackground(Color.DARK_GRAY);
        if(getWidth()>getHeight()){
            resetButton.setPreferredSize(new Dimension((getHeight()-100)/3-5,30));
        }else{
            resetButton.setPreferredSize(new Dimension((getWidth()-100)/3-5,30));
        }
        resetButton.setFont(new Font("Stencil",Font.PLAIN,30));
        resetButton.setFocusPainted(false);
        resetButton.setForeground(Color.WHITE);
        topPanel.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Frame frame = new Frame("Mine Sweeper",gameSize,getSize(),getX(),getY());

            }
        });

        //mine label
        mineLabel = new JLabel(" "+allMines+" ",SwingConstants.CENTER);
        mineLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,3));
        mineLabel.setBackground(Color.DARK_GRAY);
        if(getWidth()>getHeight()){
            mineLabel.setPreferredSize(new Dimension((getHeight()-100)/3-5,30));
        }else{
            mineLabel.setPreferredSize(new Dimension((getWidth()-100)/3-5,30));
        }
        mineLabel.setFont(new Font("Stencil",Font.PLAIN,30));
        mineLabel.setForeground(Color.WHITE);
        topPanel.add(mineLabel);
        topPanel.setPreferredSize(new Dimension(this.getWidth(),40));

        //choose difficulty button

        chooseDifficulty = new JButton("DIFFICULTY");
        chooseDifficulty.setBackground(Color.DARK_GRAY);
        if(getWidth()>getHeight()){
            chooseDifficulty.setPreferredSize(new Dimension((getHeight()-100)/3-5,30));
        }else{
            chooseDifficulty.setPreferredSize(new Dimension((getWidth()-100)/3-5,30));
        }
        chooseDifficulty.setFont(new Font("Stencil",Font.PLAIN,30));
        chooseDifficulty.setFocusPainted(false);
        chooseDifficulty.setForeground(Color.WHITE);
        topPanel.add(chooseDifficulty);
        chooseDifficulty.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StartMenu startMenu = new StartMenu();
            }
        });

        //bottom Panel
        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);
        bottomPanel.add(mineField);

        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                if(getWidth()>getHeight()){
                    mineField.setPreferredSize(new Dimension(getHeight()-100, getHeight()-100));
                    resetButton.setPreferredSize(new Dimension((getHeight()-100)/3-5, resetButton.getHeight()));
                    mineLabel.setPreferredSize(new Dimension((getHeight()-100)/3-5,mineLabel.getHeight()));
                    chooseDifficulty.setPreferredSize(new Dimension((getHeight()-100)/3-5,chooseDifficulty.getHeight()));
                }else{
                    mineField.setPreferredSize(new Dimension(getWidth()-100, getWidth()-100));

                    resetButton.setPreferredSize(new Dimension((getWidth()-100)/3-5, resetButton.getHeight()));
                    mineLabel.setPreferredSize(new Dimension((getWidth()-100)/3-5,mineLabel.getHeight()));
                    chooseDifficulty.setPreferredSize(new Dimension((getWidth()-100)/3-5,chooseDifficulty.getHeight()));
                }

                if(getHeight()%4 == 0 || getWidth()%4 == 0) {
                    for (int i = 0; i <= gameSize - 1; i++) {

                        for (int j = 0; j <= gameSize - 1; j++) {
                            fields[i][j].refreshImage();
                        }
                    }
                }
            }

        });
        this.addWindowStateListener(new WindowAdapter() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                super.windowStateChanged(e);
                if(getWidth()>getHeight()){
                    mineField.setPreferredSize(new Dimension(getHeight()-100, getHeight()-100));
                    resetButton.setPreferredSize(new Dimension((getHeight()-100)/3-5, resetButton.getHeight()));
                    mineLabel.setPreferredSize(new Dimension((getHeight()-100)/3-5,mineLabel.getHeight()));
                    chooseDifficulty.setPreferredSize(new Dimension((getHeight()-100)/3-5,chooseDifficulty.getHeight()));
                }else{
                    mineField.setPreferredSize(new Dimension(getWidth()-100, getWidth()-100));

                    resetButton.setPreferredSize(new Dimension((getWidth()-100)/3-5, resetButton.getHeight()));
                    mineLabel.setPreferredSize(new Dimension((getWidth()-100)/3-5,mineLabel.getHeight()));
                    chooseDifficulty.setPreferredSize(new Dimension((getWidth()-100)/3-5,chooseDifficulty.getHeight()));
                }

                if(getHeight()%4 == 0 || getWidth()%4 == 0) {
                    for (int i = 0; i <= gameSize - 1; i++) {

                        for (int j = 0; j <= gameSize - 1; j++) {
                            fields[i][j].refreshImage();
                        }
                    }
                }
            }
        });

        setVisible(true);

    }


    private void createPanels(){
        for (int i = 0; i <= gameSize - 1; i++) {

            for (int j = 0; j <= gameSize - 1; j++) {
                fields[i][j] = new MyPanel(i, j, this);
                mineField.add(fields[i][j]);
            }
        }
        mines = new Minefield(fields);
    }

    public void setAllMines(int allMines){
        this.allMines = allMines;
        String t = Integer.toString(allMines);
        mineLabel.setText(t);
    }

    public int getAllMines() {
        return allMines;
    }

    public MyPanel[][] getFields() {
        return fields;
    }

    public MyPanel getFieldAt(int x, int y) {
        return fields[x][y];
    }


}
