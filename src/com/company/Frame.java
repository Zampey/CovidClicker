package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextLayout;

public class Frame extends JFrame implements MouseListener {
    Money money = new Money();
    String actualMoney = money.getData();
    long actualMoneyAsLong = Long.parseLong(actualMoney);

    JLabel click, coins;

     BgLabel bgLabel = new com.company.BgLabel();
    JFrame mainFrame = new JFrame("Covid-Clicker");


    Image bigCovid = new ImageIcon("src/com/company/bigCovid.png").getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH);
    ImageIcon bigCovidIcon = new ImageIcon(bigCovid);

    Color backgroundColor = new Color(145,33,33);

    Font textFont = new Font("Serif",0, 40);

    Image coinsImg = new ImageIcon("src/com/company/coins.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    ImageIcon coinIcon = new ImageIcon(coinsImg);


        Frame(){




            //number of coins you have
            coins = new JLabel();
            coins.setText(actualMoney);
            coins.setIcon(coinIcon);
            coins.setBounds(495, 15, 250, 50);
            coins.setForeground(Color.WHITE);
            coins.setFont(textFont);
            coins.setVerticalAlignment(JLabel.CENTER);
            coins.setHorizontalAlignment(JLabel.CENTER);


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
            mainFrame.add(coins);
            mainFrame.add(bgLabel);

            this.moneyShortcutSetter();
        }


    @Override
    public void mouseClicked(MouseEvent e) {

        actualMoneyAsLong = actualMoneyAsLong+1;
        money.setActualMoney(actualMoneyAsLong);
        money.write();
        coins.setText(String.valueOf(actualMoneyAsLong));

        this.moneyShortcutSetter();


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



    public void moneyShortcutSetter(){
        String[] shortcuts = {"K","M", "B", "T", "Qa", "Qi"};

        textFont = new Font("Serif",0, 35);
        coins.setFont(textFont);

        if (actualMoneyAsLong >= 100000){
            double actualMoneyAsDouble = Math.round((((float)actualMoneyAsLong)/1000) * 100.0) / 100.0;
            coins.setText(Double.toString(actualMoneyAsDouble) + shortcuts[0]);

        }


        if (actualMoneyAsLong >= 1000000){
            double actualMoneyAsDouble = Math.round((((float)actualMoneyAsLong)/1000000) * 100.0) / 100.0;
            coins.setText(Double.toString(actualMoneyAsDouble) + shortcuts[1]);
        }


        if (actualMoneyAsLong >= 1000000000){
            double actualMoneyAsDouble = Math.round((((float)actualMoneyAsLong)/1000000000) * 100.0) / 100.0;
            coins.setText(Double.toString(actualMoneyAsDouble) + shortcuts[2]);
        }

        if (actualMoneyAsLong >= Math.pow(10, 12)){
            double actualMoneyAsDouble = Math.round((((float)actualMoneyAsLong)/Math.pow(10, 12)) * 100.0) / 100.0;
            coins.setText(Double.toString(actualMoneyAsDouble) + shortcuts[3]);
        }

        if (actualMoneyAsLong >= Math.pow(10, 15)){
            double actualMoneyAsDouble = Math.round((((float)actualMoneyAsLong)/Math.pow(10, 15)) * 100.0) / 100.0;
            coins.setText(Double.toString(actualMoneyAsDouble) + shortcuts[4]);
        }

        if (actualMoneyAsLong >= Math.pow(10, 18)){
            double actualMoneyAsDouble = Math.round((((float)actualMoneyAsLong)/Math.pow(10, 18)) * 100.0) / 100.0;
            coins.setText(Double.toString(actualMoneyAsDouble) + shortcuts[5]);
        }



    }


}
