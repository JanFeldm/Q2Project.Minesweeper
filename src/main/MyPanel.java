package main;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyPanel extends JPanel implements MouseListener {

    JLabel label;

    private ImageIcon image1;
    private ImageIcon image2;
    private ImageIcon image3;
    private ImageIcon image4;
    private ImageIcon image5;
    private ImageIcon image6;
    private ImageIcon image7;
    private ImageIcon image8;
    private ImageIcon imageMine;

    private boolean mine;
    private int mineCount;

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


    @Override
    public void mouseClicked(MouseEvent e) {

        if(isMine()) {
            label.setIcon(images.getIMage(9,getWidth(),getHeight()));
        }else{
            switch(mineCount){
                case 1 ->{label.setIcon(images.getIMage(1,getWidth(),getHeight()));}
                case 2 ->{label.setIcon(images.getIMage(2,getWidth(),getHeight()));}
                case 3 ->{label.setIcon(images.getIMage(3,getWidth(),getHeight()));}
                case 4 ->{label.setIcon(images.getIMage(4,getWidth(),getHeight()));}
                case 5 ->{label.setIcon(images.getIMage(5,getWidth(),getHeight()));}
                case 6 ->{label.setIcon(images.getIMage(6,getWidth(),getHeight()));}
                case 7 ->{label.setIcon(images.getIMage(7,getWidth(),getHeight()));}
                case 8 ->{label.setIcon(images.getIMage(8,getWidth(),getHeight()));}
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
