package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextLayout;

public class Frame extends JFrame implements MouseListener {
    JLabel click, money;

     BgLabel bgLabel = new BgLabel();
    JFrame mainFrame = new JFrame("Covid-Clicker");


    Image bigCovid = new ImageIcon("src/com/company/bigCovid.png").getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH);
    ImageIcon bigCovidIcon = new ImageIcon(bigCovid);

    Color backgroundColor = new Color(145,33,33);

    Font textFont = new Font("Serif",0, 40);

    Image coinsImg = new ImageIcon("src/com/company/coins.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    ImageIcon coinIcon = new ImageIcon(coinsImg);
    String text = "9587";
        Frame(){




            //number of coins you have
            money = new JLabel();
            money.setText(text);
            money.setIcon(coinIcon);
            money.setBounds(540, 15, 150, 50);
            money.setForeground(Color.WHITE);
            money.setFont(textFont);
            money.setVerticalAlignment(JLabel.CENTER);
            money.setHorizontalAlignment(JLabel.CENTER);


        //big icon in the center of frame
            click = new JLabel();
            click.setBounds(580, 260, 100, 100);
            click.setOpaque(true);
            click.addMouseListener((MouseListener) this);
            click.setBackground(backgroundColor);
            click.setIcon(bigCovidIcon);
            click.setHorizontalAlignment(JLabel.CENTER);
            click.setVerticalAlignment(JLabel.CENTER);



            mainFrame.getContentPane().setBackground(backgroundColor);
            mainFrame.setIconImage(new ImageIcon("src/com/company/bigCovid.png").getImage().getScaledInstance(90, 90,  Image.SCALE_SMOOTH));
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(1280, 720);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
            mainFrame.setResizable(false);


            mainFrame.add(click);
            mainFrame.add(money);
            mainFrame.add(bgLabel);

        }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Image bigCovidOnPressed = new ImageIcon("src/com/company/bigCovid.png").getImage().getScaledInstance(120, 120,  Image.SCALE_SMOOTH);
        ImageIcon bigCovidIconOnPressed = new ImageIcon(bigCovidOnPressed);
        click.setIcon(bigCovidIconOnPressed);
        click.setBounds(570, 250, 120, 120);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        click.setIcon(bigCovidIcon);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
