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
            label.setIcon(imageMine);
        }else{
            switch(mineCount){
                case 1 ->{label.setIcon(image1);}
                case 2 ->{label.setIcon(image2);}
                case 3 ->{label.setIcon(image3);}
                case 4 ->{label.setIcon(image4);}
                case 5 ->{label.setIcon(image5);}
                case 6 ->{label.setIcon(image6);}
                case 7 ->{label.setIcon(image7);}
                case 8 ->{label.setIcon(image8);}
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



        image1 = new ImageIcon(new ImageIcon("pictures/pixel 1.png").getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH));
        image2 = new ImageIcon(new ImageIcon("pictures/pixel 2.png").getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH));
        image3 = new ImageIcon(new ImageIcon("pictures/pixel 3.png").getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH));
        image4 = new ImageIcon(new ImageIcon("pictures/pixel 4.png").getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH));
        image5 = new ImageIcon(new ImageIcon("pictures/pixel 5.png").getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH));
        image6 = new ImageIcon(new ImageIcon("pictures/pixel 6.png").getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH));
        image7 = new ImageIcon(new ImageIcon("pictures/pixel 7.png").getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH));
        image8 = new ImageIcon(new ImageIcon("pictures/pixel 8.png").getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH));
        imageMine = new ImageIcon(new ImageIcon("pictures/pixel mine.png").getImage().getScaledInstance(getWidth(),getHeight(),Image.SCALE_SMOOTH));

        this.setBackground(Color.BLUE);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        this.setBackground(Color.white);
    }
}
