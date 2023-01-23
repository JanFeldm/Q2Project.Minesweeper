package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame implements ActionListener {

    private int difficulty = 1;
    private JButton difficultyLow;
    private JButton difficultyMid;
    private JButton difficultyHard;
    private JButton startButton;

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

        difficultyLow = new JButton("Easy");
        difficultyLow.addActionListener(this);
        difficultyLow.setBackground(Color.WHITE);

        difficultyMid = new JButton("Medium");
        difficultyMid.addActionListener(this);
        difficultyMid.setBackground(Color.WHITE);

        difficultyHard = new JButton("Hard");
        difficultyHard.addActionListener(this);
        difficultyHard.setBackground(Color.WHITE);

        startButton = new JButton("Start");
        startButton.addActionListener(this);
        startButton.setBackground(Color.WHITE);

        upperPanel.add(difficultyLow);
        upperPanel.add(difficultyMid);
        upperPanel.add(difficultyHard);

        lowerPanel.add(startButton);
        JLabel label = new JLabel("Select Difficulty", SwingConstants.CENTER);
        label.setBackground(Color.WHITE);

        mainPanel.add(label, BorderLayout.PAGE_START);
        mainPanel.add(upperPanel, BorderLayout.CENTER);
        mainPanel.add(lowerPanel, BorderLayout.PAGE_END);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == difficultyLow) {
            difficulty = 9;
            difficultyLow.setBackground(Color.gray);
            difficultyMid.setBackground(Color.WHITE);
            difficultyHard.setBackground(Color.WHITE);
        }
        if (e.getSource() == difficultyMid) {
            difficulty = 16;
            difficultyLow.setBackground(Color.WHITE);
            difficultyMid.setBackground(Color.gray);
            difficultyHard.setBackground(Color.WHITE);
        }
        if (e.getSource() == difficultyHard) {
            difficulty = 25;
            difficultyLow.setBackground(Color.WHITE);
            difficultyMid.setBackground(Color.WHITE);
            difficultyHard.setBackground(Color.gray);
        }
        if (e.getSource() == startButton) {
            this.dispose();
            Frame frame = new Frame("Mine Sweeper", difficulty); //creating the game frame
        }

    }
}
