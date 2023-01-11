package main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPanel extends JPanel implements MouseListener {

    private JLabel label;

    private boolean mine;
    private int mineCount;
    private int imageState; //marked mine
    private boolean revealed;
    private boolean gameOver;

    private int x;
    private int y;

    private MyPanel[] nextPanels = new MyPanel[4];


    private Images images = new Images();
    private Frame mainFrame;


    public MyPanel(int x, int y, Frame mainFrame) {
        super();

        this.mainFrame = mainFrame;
        this.x = x;
        this.y = y;

        this.setLayout(new GridBagLayout());
        label = new JLabel();
        add(label);


        addMouseListener(this);
        this.setBackground(Color.gray);

    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    public int getMineCount() {
        return mineCount;
    }

    public void setImageState(int imageState) {
        this.imageState = imageState;
    }

    public int getImageState() {
        return imageState;
    }

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public boolean isRevealed() {
        return revealed;
    }

    public MyPanel[] getNextPanels() {
        return nextPanels;
    }

    public void setNextPanels(int direction, MyPanel nextPanel) {
        nextPanels[direction] = nextPanel;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (!gameOver) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (getImageState() != 1) {
                    if (isMine()) {
                        label.setIcon(images.getIMage(10, getWidth(), getHeight()));
                        gameOver = true;


                        revealBombs();
                        JFrame gameOverF = new JFrame("game Over");
                        gameOverF.setVisible(true);
                        gameOverF.setSize(new Dimension(100, 50));
                        JLabel l = new JLabel("Game over");
                        gameOverF.add(l);
                        gameOverF.setLocationRelativeTo(null);

                    } else {
                        switchLabel(mineCount);
                    }
                    setRevealed(true);
                }

            } else if (e.getButton() == MouseEvent.BUTTON3) {
                if (!isRevealed()) {
                    if (getImageState() == 1) {
                        label.setIcon(images.getIMage(12, getWidth(), getHeight()));
                        setImageState(0);
                    } else {
                        label.setIcon(images.getIMage(9, getWidth(), getHeight()));
                        setImageState(1);
                    }
                }
            }
            checkForVictory();
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBackground(Color.lightGray);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Color.gray);
    }

    public void revealArea() {
        if (getMineCount() == 0) {
            label.setIcon(images.getIMage(11, getWidth(), getHeight()));
            setRevealed(true);
            for (int i = 0; i <= nextPanels.length - 1; i++) {
                if (nextPanels[i] != null && !nextPanels[i].isRevealed()) {
                    nextPanels[i].revealArea();
                }

            }
        } else {
            switchLabel(mineCount);
            setRevealed(true);
        }
    }

    public void switchLabel(int z) {
        switch (z) {
            case 0 -> {
                revealArea();
            }
            case 1 -> {
                label.setIcon(images.getIMage(1, getWidth(), getHeight()));
            }
            case 2 -> {
                label.setIcon(images.getIMage(2, getWidth(), getHeight()));
            }
            case 3 -> {
                label.setIcon(images.getIMage(3, getWidth(), getHeight()));
            }
            case 4 -> {
                label.setIcon(images.getIMage(4, getWidth(), getHeight()));
            }
            case 5 -> {
                label.setIcon(images.getIMage(5, getWidth(), getHeight()));
            }
            case 6 -> {
                label.setIcon(images.getIMage(6, getWidth(), getHeight()));
            }
            case 7 -> {
                label.setIcon(images.getIMage(7, getWidth(), getHeight()));
            }
            case 8 -> {
                label.setIcon(images.getIMage(8, getWidth(), getHeight()));
            }
        }
    }

    public void revealBombs() {
        MyPanel[][] p = mainFrame.getFields();
        for (int i = 0; i <= p.length - 1; i++) {
            for (int j = 0; j <= p[i].length - 1; j++) {
                if (p[i][j].isMine()) {
                    p[i][j].getLabel().setIcon(images.getIMage(10, p[i][j].getWidth(), p[i][j].getHeight()));

                }
                p[i][j].setGameOver(true);
            }
        }

    }

    public void checkForVictory() {
        MyPanel[][] p = mainFrame.getFields();
        boolean victory = true;
        for (int i = 0; i <= p.length - 1; i++) {
            for (int j = 0; j <= p[i].length - 1; j++) {
                if((!p[i][j].isRevealed())){
                    if(p[i][j].isMine() && p[i][j].getImageState() == 1){

                    }else{
                        victory = false;
                    }
                }

            }
        }

        if(victory){
            revealBombs();
            JFrame f = new JFrame("Victory");
            f.setVisible(true);
            f.setSize(new Dimension(100, 50));
            JLabel l = new JLabel("Victory");
            f.add(l);
            f.setLocationRelativeTo(null);
        }
    }

}
