package main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPanel extends JPanel implements MouseListener {

    private JLabel label;

    private boolean mine;
    private int mineCount; //mines in the surrounding area
    private int imageState; //marked mine with right mouse click
    private boolean revealed; //got revealed with left mouse click
    private boolean gameOver;
    private int currentImageCode;

    private int x;
    private int y;

    private MyPanel[] nextPanels = new MyPanel[8]; //Panels in surrounding Area


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
        this.setBackground(Color.DARK_GRAY);

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
            if (e.getButton() == MouseEvent.BUTTON1) { //right click
                if (getImageState() != 1) {
                    if (isMine()) {
                        label.setIcon(images.getIMage(10, getWidth(), getHeight()));
                        currentImageCode = 10;
                        gameOver = true;


                        revealBombs(true);
                        mainFrame.setTitle("Mine Sweeper  ####Game Over####");

                    } else {
                        switchLabel(mineCount);
                    }
                    setRevealed(true);
                }


            } else if (e.getButton() == MouseEvent.BUTTON3) { //left click
                if (!isRevealed()) {
                    if (getImageState() == 1) { // if marked with mine
                        label.setIcon(null);
                        setImageState(0);
                        mainFrame.setAllMines(mainFrame.getAllMines()+1);
                    } else { //if field is unrevealed and not marked with mine
                        label.setIcon(images.getIMage(9, getWidth(), getHeight()));
                        currentImageCode = 9;
                        setImageState(1);
                        mainFrame.setAllMines(mainFrame.getAllMines()-1);
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
        this.setBackground(Color.gray);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Color.DARK_GRAY);
    }

    public void revealArea() {
        if (getMineCount() == 0) { //reveals the clicked fields and the fields next to it if its empty
            label.setIcon(images.getIMage(11, getWidth(), getHeight()));
            currentImageCode = 11;
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
            case 0 :
                revealArea();
                break;
            case 1 :
                label.setIcon(images.getIMage(1, getWidth(), getHeight()));
                currentImageCode = 1;
                break;
            case 2 :
                label.setIcon(images.getIMage(2, getWidth(), getHeight()));
                currentImageCode = 2;
                break;
            case 3 :
                label.setIcon(images.getIMage(3, getWidth(), getHeight()));
                currentImageCode = 3;
                break;
            case 4 :
                label.setIcon(images.getIMage(4, getWidth(), getHeight()));
                currentImageCode = 4;
                break;
            case 5 :
                label.setIcon(images.getIMage(5, getWidth(), getHeight()));
                currentImageCode = 5;
                break;
            case 6 :
                label.setIcon(images.getIMage(6, getWidth(), getHeight()));
                currentImageCode = 6;
                break;
            case 7 :
                label.setIcon(images.getIMage(7, getWidth(), getHeight()));
                currentImageCode = 7;
                break;
            case 8 :
                label.setIcon(images.getIMage(8, getWidth(), getHeight()));
                currentImageCode = 8;
                break;
        }
    }

    public void revealBombs(boolean boom) {
        MyPanel[][] p = mainFrame.getFields();
        for (int i = 0; i <= p.length - 1; i++) {
            for (int j = 0; j <= p[i].length - 1; j++) {
                if (p[i][j].isMine()) {
                    if (!boom) {
                        p[i][j].getLabel().setIcon(images.getIMage(10, p[i][j].getWidth(), p[i][j].getHeight()));
                        currentImageCode = 10;
                    } else {
                        p[i][j].getLabel().setIcon(images.getIMage(12, p[i][j].getWidth(), p[i][j].getHeight()));
                        currentImageCode = 12;
                    }

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
                if ((!p[i][j].isRevealed())) {
                    if (p[i][j].isMine() && p[i][j].getImageState() == 1) {

                    } else {
                        victory = false;
                    }
                }

            }
        }

        if (victory) {
            revealBombs(false);
            mainFrame.setTitle("Mine Sweeper  ****Victory****");
        }
    }

    public void refreshImage(){
        if(!(!isRevealed() && imageState == 0)){
            label.setIcon(images.getIMage(currentImageCode,getWidth(),getHeight()));
        }
    }

}
