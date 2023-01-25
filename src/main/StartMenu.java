package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame implements ActionListener {

    private int difficulty = 9;
    private JButton difficultyLow;
    private JButton difficultyMid;
    private JButton difficultyHard;
    private JButton startButton;
    private int secretModeCounter = 0;

    public StartMenu() {
        createPanel();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setTitle("Mine Sweeper");
        setSize(600, 200);
        setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight() / 2);
        setResizable(false);
        setMinimumSize(new Dimension(550, 200));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void createPanel() {
        JPanel mainPanel = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        mainPanel.setLayout(borderLayout);
        add(mainPanel);
        JPanel upperPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(1, 3);
        upperPanel.setLayout(gridLayout);
        JPanel lowerPanel = new JPanel(new GridLayout(1, 1));

        difficultyLow = new JButton("Easy (9x9)");
        difficultyLow.setFont(new Font("Stencil",Font.PLAIN,20));
        difficultyLow.setFocusPainted(false);
        difficultyLow.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        difficultyLow.addActionListener(this);
        difficultyLow.setBackground(Color.WHITE);
        difficultyLow.setForeground(Color.BLACK);

        difficultyMid = new JButton("Medium (16x16)");
        difficultyMid.setFont(new Font("Stencil",Font.PLAIN,20));
        difficultyMid.setFocusPainted(false);
        difficultyMid.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        difficultyMid.addActionListener(this);
        difficultyMid.setBackground(Color.WHITE);
        difficultyMid.setForeground(Color.BLACK);

        difficultyHard = new JButton("Hard (25x25)");
        difficultyHard.setFont(new Font("Stencil",Font.PLAIN,20));
        difficultyHard.setFocusPainted(false);
        difficultyHard.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        difficultyHard.addActionListener(this);
        difficultyHard.setBackground(Color.WHITE);
        difficultyHard.setForeground(Color.BLACK);

        startButton = new JButton("Start");
        startButton.setFont(new Font("Stencil",Font.PLAIN,30));
        startButton.setFocusPainted(false);
        startButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        startButton.addActionListener(this);
        startButton.setBackground(Color.WHITE);
        startButton.setForeground(Color.BLACK);
        startButton.setEnabled(false);

        upperPanel.add(difficultyLow);
        upperPanel.add(difficultyMid);
        upperPanel.add(difficultyHard);

        lowerPanel.add(startButton);
        JLabel label = new JLabel("Select Difficulty", SwingConstants.CENTER);
        label.setFont(new Font("Stencil",Font.PLAIN,20));
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK,2));
        label.setForeground(Color.BLACK);

        mainPanel.add(label, BorderLayout.PAGE_START);
        mainPanel.add(upperPanel, BorderLayout.CENTER);
        mainPanel.add(lowerPanel, BorderLayout.PAGE_END);
        mainPanel.setBackground(Color.WHITE);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == difficultyLow) {
            secretModeCounter = 0;
            difficulty = 9;
            difficultyLow.setBackground(Color.DARK_GRAY);
            difficultyLow.setForeground(Color.WHITE);
            difficultyMid.setBackground(Color.WHITE);
            difficultyMid.setForeground(Color.BLACK);
            difficultyHard.setBackground(Color.WHITE);
            difficultyHard.setForeground(Color.BLACK);
            startButton.setEnabled(true);
        }
        if (e.getSource() == difficultyMid) {
            secretModeCounter = 0;
            difficulty = 16;
            difficultyLow.setBackground(Color.WHITE);
            difficultyLow.setForeground(Color.BLACK);
            difficultyMid.setBackground(Color.DARK_GRAY);
            difficultyMid.setForeground(Color.WHITE);
            difficultyHard.setBackground(Color.WHITE);
            difficultyHard.setForeground(Color.BLACK);
            startButton.setEnabled(true);
        }
        if (e.getSource() == difficultyHard) {
            secretModeCounter++;
            if(secretModeCounter == 10){
                this.dispose();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                Frame frame = new Frame("SECRET MODE",100,new Dimension(900,900),screenSize.width / 2 - 900 / 2, screenSize.height / 2 - 900 / 2);
            }
            difficulty = 25;
            difficultyLow.setBackground(Color.WHITE);
            difficultyLow.setForeground(Color.BLACK);
            difficultyMid.setBackground(Color.WHITE);
            difficultyMid.setForeground(Color.BLACK);
            difficultyHard.setBackground(Color.DARK_GRAY);
            difficultyHard.setForeground(Color.WHITE);
            startButton.setEnabled(true);
        }
        if (e.getSource() == startButton) {
            this.dispose();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            Frame frame = new Frame("Mine Sweeper", difficulty,new Dimension(900,900),screenSize.width / 2 - 900 / 2, screenSize.height / 2 - 900 / 2); //creating the game frame
        }

    }
}
