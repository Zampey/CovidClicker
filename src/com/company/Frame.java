package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements MouseListener{
    MoneyRW moneyRW = new MoneyRW();
    String actualMoney = moneyRW.getData();
    long actualMoneyAsLong = Long.parseLong(actualMoney);

    JLabel click;
     BgLabel bgLabel = new com.company.BgLabel();
    JFrame mainFrame = new JFrame("Covid-Clicker");

    IconsInstances iconInstances = new IconsInstances();
    Shortcuts shortcuts = new Shortcuts();
    SideMenu sideMenu = new SideMenu();
    ShopPanel shopPanel = new ShopPanel();

    Color backgroundColor = new Color(145,33,33);



        Frame(){


        //big icon in the center of frame
            click = new JLabel();
            click.setBounds(580, 260, 100, 100);
            click.setOpaque(true);
            click.addMouseListener((MouseListener) this);
            click.setBackground(backgroundColor);
            click.setIcon(iconInstances.getBigCovidIcon());
            click.setHorizontalAlignment(JLabel.CENTER);
            click.setVerticalAlignment(JLabel.CENTER);



            mainFrame.getContentPane().setBackground(backgroundColor);
            mainFrame.setIconImage(new ImageIcon("src/com/company/bigCovid.png").getImage().getScaledInstance(30, 30,  Image.SCALE_SMOOTH));
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(1280, 720);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
            mainFrame.setResizable(false);


            mainFrame.add(click);
            mainFrame.add(shortcuts.getCoins());
            mainFrame.add(sideMenu.getSidePanel());
            mainFrame.add(shopPanel.getShopPanel());
            mainFrame.add(bgLabel);

            shortcuts.moneyShortcutSetter();
        }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

        Image bigCovidOnPressed = new ImageIcon("src/icons/bigCovid.png").getImage().getScaledInstance(120, 120,  Image.SCALE_SMOOTH);
        ImageIcon bigCovidIconOnPressed = new ImageIcon(bigCovidOnPressed);
        click.setIcon(bigCovidIconOnPressed);
        click.setBounds(570, 250, 120, 120);

        actualMoneyAsLong = actualMoneyAsLong+1;
        moneyRW.setActualMoney(actualMoneyAsLong);
        moneyRW.write();

        shortcuts.setActualMoneyAsLong(actualMoneyAsLong);
        shortcuts.moneyShortcutSetter();




    }

    @Override
    public void mouseReleased(MouseEvent e) {
        click.setIcon(iconInstances.getBigCovidIcon());
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }




}
