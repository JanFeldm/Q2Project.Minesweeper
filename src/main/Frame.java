package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame {

    private int gameSize; // size of the minefield (gameSize x gameSize)
    private MyPanel[][] fields;
    private JFrame frame;
    private Minefield mines;
    private int allMines;
    private JPanel mineField;
    private JLabel mineLabel;

    public Frame(String name,int gameSize) {

        super(name);

        this.gameSize = gameSize;
        fields = new MyPanel[gameSize][gameSize];
        //minefield
        mineField = new JPanel(new GridLayout(gameSize, gameSize, 50 / gameSize, 50 / gameSize));
        mineField.setPreferredSize(new Dimension(800, 800));
        mineField.setBackground(Color.BLACK);

        createPanels();
        allMines = mines.getallMines();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(900, 900);
        setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
        setResizable(true);
        setMinimumSize(new Dimension(850, 900));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.BLACK);


        add(mainPanel);


        JPanel topPanel = new JPanel();
        topPanel.setBackground(Color.BLACK);
        mainPanel.add(topPanel, BorderLayout.PAGE_START);

        //reset button

        JButton resetButton = new JButton();
        resetButton.setText("RESET");
        resetButton.setBackground(Color.DARK_GRAY);
        resetButton.setPreferredSize(new Dimension(300,30));
        resetButton.setFont(new Font("Stencil",Font.PLAIN,30));
        resetButton.setFocusPainted(false);
        resetButton.setForeground(Color.WHITE);
        topPanel.add(resetButton);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Frame newFrame = new Frame("Mine Sweeper",gameSize);
            }
        });

        mineLabel = new JLabel(" "+allMines+" ",SwingConstants.CENTER);
        mineLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY,3));
        mineLabel.setBackground(Color.DARK_GRAY);
        mineLabel.setPreferredSize(new Dimension(200,30));
        mineLabel.setFont(new Font("Stencil",Font.PLAIN,30));
        mineLabel.setForeground(Color.WHITE);
        topPanel.add(mineLabel);

        //choose difficulty button

        JButton chooseDifficulty = new JButton("DIFFICULTY");
        chooseDifficulty.setBackground(Color.DARK_GRAY);
        chooseDifficulty.setPreferredSize(new Dimension(300,30));
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
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.BLACK);
        mainPanel.add(bottomPanel, BorderLayout.CENTER);
        bottomPanel.add(mineField);


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
