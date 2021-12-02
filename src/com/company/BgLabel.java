package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BgLabel extends JLabel implements ActionListener {

    final int LABEL_WIDTH =  1280;
    final int LABEL_HEIGHT =  720;
    Image covid;
    Timer timer;
    int yVelocity =1;
    int x =10;
    int y1 =0;
    int y2 =0;

    boolean heightHelper2 = false;

    Color backgroundColor = new Color(145,33,33);

    BgLabel(){

        this.setPreferredSize(new Dimension(LABEL_WIDTH, LABEL_HEIGHT));
        this.setBackground(backgroundColor);
        covid = new ImageIcon("src/com/company/virus.png").getImage().getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
        timer = new Timer(17, e -> {
            if(y1>= LABEL_HEIGHT+620){
                y1 =0;
            }
            if (y2 >= LABEL_HEIGHT+620){
                y2 =0;
            }


            if (y1 == 600){
                heightHelper2 = true;
            }

            if (heightHelper2){
                y2 = y2 + yVelocity;

            }

            y1 = y1 + yVelocity;

            repaint();
        });

        timer.start();

    }

    public void paint(Graphics g){
        super.paint(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.drawImage(covid, x, y1-50, null);
        g2D.drawImage(covid, x+130, y1-320, null);
        g2D.drawImage(covid, x+210, y1-620, null);
        g2D.drawImage(covid, x+310, y1-450, null);
        g2D.drawImage(covid, x+460, y1-210, null);
        //g2D.drawImage(covid, x+600, y1-450, null);
        g2D.drawImage(covid, x+750, y1-550, null);
        g2D.drawImage(covid, x+850, y1-256, null);
        g2D.drawImage(covid, x+1000, y1-330, null);
        g2D.drawImage(covid, x+1200, y1-570, null);


        g2D.drawImage(covid, x, y2-50, null);
        g2D.drawImage(covid, x+130, y2-320, null);
        g2D.drawImage(covid, x+210, y2-620, null);
        g2D.drawImage(covid, x+310, y2-450, null);
        g2D.drawImage(covid, x+460, y2-210, null);
        //g2D.drawImage(covid, x+600, y2-450, null);
        g2D.drawImage(covid, x+750, y2-550, null);
        g2D.drawImage(covid, x+850, y2-256, null);
        g2D.drawImage(covid, x+1000, y2-330, null);
        g2D.drawImage(covid, x+1200, y2-570, null);


    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
