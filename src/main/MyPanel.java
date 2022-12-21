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
    private int imageState;


    private Images images = new Images();


    public MyPanel(int x,int y){
        super();
        this.setLayout(new GridBagLayout());

        label = new JLabel();
        add(label);



        addMouseListener(this);
        this.setBackground(Color.white);

    }
    public void setMine(boolean mine){
        this.mine = mine;
    }
    public boolean isMine(){
        return mine;
    }

    public void setMineCount(int mineCount){
        this.mineCount = mineCount;
    }
    public int getMineCount(){
        return mineCount;
    }

    public void setImageState(int imageState){
        this.imageState = imageState;
    }
    public int getImageState(){
        return imageState;
    }


    @Override
    public void mouseClicked(MouseEvent e) {


        if(e.getButton() == MouseEvent.BUTTON1) {
            if (isMine()) {
                System.out.println("Game Over");
            } else {
                switch (mineCount) {
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
        }else if(e.getButton() == MouseEvent.BUTTON3){
            if(getImageState() == 1){
                label.setIcon(new ImageIcon());
            }else {
                label.setIcon(images.getIMage(9, getWidth(), getHeight()));
            }
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

        this.setBackground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Color.white);
    }
}
