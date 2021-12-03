package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements MouseListener{
    MoneyRW moneyRW = new MoneyRW();
    String actualMoney = moneyRW.getData();
    long actualMoneyAsLong = Long.parseLong(actualMoney);

    JLabel click, shop, achievements, skins, rebirth, settings;
     BgLabel bgLabel = new com.company.BgLabel();
    JFrame mainFrame = new JFrame("Covid-Clicker");
    JPanel sidePanel = new JPanel();
    IconsInstances iconInstances = new IconsInstances();
    Shortcuts shortcuts = new Shortcuts();


    Color backgroundColor = new Color(145,33,33);
    Color sideBarBorderColor = new Color(114, 21, 21);
    Color sideBarBackgroundColor = new Color(182, 41, 41);



    boolean openShop = false;
    boolean openAchievements = false;
    boolean openSkins = false;
    boolean openRebirth = false;
    boolean openSettings = false;

        Frame(){

            //Item-shop
            shop = new JLabel();
            shop.setIcon(iconInstances.getShopIcon());
            shop.setBounds(0, 0, 96, 100);
            shop.setVerticalAlignment(JLabel.CENTER);
            shop.setHorizontalAlignment(JLabel.CENTER);
            shop.setBackground(sideBarBackgroundColor);
            shop.setOpaque(true);
            shop.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    shopSetter();
                }
            });


            //Achievements
                achievements = new JLabel();
                achievements.setIcon(iconInstances.getAchievementsIcon());
                achievements.setBounds(0, 110, 96, 100);
                achievements.setBackground(sideBarBackgroundColor);
                achievements.setOpaque(true);
                achievements.setVerticalAlignment(JLabel.CENTER);
                achievements.setHorizontalAlignment(JLabel.CENTER);
                achievements.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {achievementsSetter();
                    }
                });


                //skins
                skins = new JLabel();
                skins.setIcon(iconInstances.getSkinsIcon());
                skins.setBounds(0, 220, 96, 100);
                skins.setBackground(sideBarBackgroundColor);
                skins.setOpaque(true);
                skins.setVerticalAlignment(JLabel.CENTER);
                skins.setHorizontalAlignment(JLabel.CENTER);
                skins.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {skinsSetter();
                    }
                });


            //rebirths
            rebirth = new JLabel();
            rebirth.setIcon(iconInstances.getRebirthIcon());
            rebirth.setBounds(0, 330, 96, 100);
            rebirth.setBackground(sideBarBackgroundColor);
            rebirth.setOpaque(true);
            rebirth.setVerticalAlignment(JLabel.CENTER);
            rebirth.setHorizontalAlignment(JLabel.CENTER);
            rebirth.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    rebirthSetter();
                }
            });

            //settings
            settings = new JLabel();
            settings.setIcon(iconInstances.getSettingsIcon());
            settings.setBounds(0, 581, 96, 100);
            settings.setBackground(sideBarBackgroundColor);
            settings.setOpaque(true);
            settings.setVerticalAlignment(JLabel.CENTER);
            settings.setHorizontalAlignment(JLabel.CENTER);
            settings.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    settingsSetter();
                }
            });




            //side panel
            sidePanel.setBackground(sideBarBackgroundColor);
            sidePanel.setBounds(0, 0, 100, 720);
            sidePanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 4, sideBarBorderColor));
            sidePanel.setLayout(null);
            sidePanel.add(shop);
            sidePanel.add(achievements);
            sidePanel.add(skins);
            sidePanel.add(rebirth);
            sidePanel.add(settings);



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
            mainFrame.setIconImage(new ImageIcon("src/com/company/bigCovid.png").getImage().getScaledInstance(90, 90,  Image.SCALE_SMOOTH));
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(1280, 720);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
            mainFrame.setResizable(false);


            mainFrame.add(click);
            mainFrame.add(shortcuts.getCoins());
            mainFrame.add(sidePanel);
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


    public void shopSetter(){

        if (openShop == false){
            openShop = true;
            shop.setBackground(sideBarBorderColor);
        }else{
            openShop = false;
            shop.setBackground(sideBarBackgroundColor);
        }
        openAchievements = false;
        achievements.setBackground(sideBarBackgroundColor);
        openSkins= false;
        skins.setBackground(sideBarBackgroundColor);
        openRebirth = false;
        rebirth.setBackground(sideBarBackgroundColor);
        openSettings = false;
        settings.setBackground(sideBarBackgroundColor);
    }

    public void achievementsSetter(){
        if (openAchievements == false){
            openAchievements = true;
            achievements.setBackground(sideBarBorderColor);
        }else{
            openAchievements = false;
            achievements.setBackground(sideBarBackgroundColor);
        }

        openShop = false;
        shop.setBackground(sideBarBackgroundColor);
        openSkins= false;
        skins.setBackground(sideBarBackgroundColor);
        openRebirth = false;
        rebirth.setBackground(sideBarBackgroundColor);
        openSettings = false;
        settings.setBackground(sideBarBackgroundColor);
    }

    public void skinsSetter(){
        if (openSkins == false){
            openSkins = true;
            skins.setBackground(sideBarBorderColor);
        }else{
            openSkins = false;
            skins.setBackground(sideBarBackgroundColor);
        }

        openShop = false;
        shop.setBackground(sideBarBackgroundColor);
        openAchievements= false;
        achievements.setBackground(sideBarBackgroundColor);
        openRebirth = false;
        rebirth.setBackground(sideBarBackgroundColor);
        openSettings = false;
        settings.setBackground(sideBarBackgroundColor);
    }

    public void rebirthSetter(){
        if (openRebirth == false){
            openRebirth = true;
            rebirth.setBackground(sideBarBorderColor);
        }else{
            openRebirth = false;
            rebirth.setBackground(sideBarBackgroundColor);
        }

        openShop = false;
        shop.setBackground(sideBarBackgroundColor);
        openAchievements= false;
        achievements.setBackground(sideBarBackgroundColor);
        openSkins = false;
        skins.setBackground(sideBarBackgroundColor);
        openSettings = false;
        settings.setBackground(sideBarBackgroundColor);
    }

    public void settingsSetter(){
        if (openSettings == false){
            openSettings = true;
            settings.setBackground(sideBarBorderColor);
        }else{
            openSettings = false;
            settings.setBackground(sideBarBackgroundColor);
        }

        openShop = false;
        shop.setBackground(sideBarBackgroundColor);
        openAchievements= false;
        achievements.setBackground(sideBarBackgroundColor);
        openSkins = false;
        skins.setBackground(sideBarBackgroundColor);
        openRebirth = false;
        rebirth.setBackground(sideBarBackgroundColor);
    }




}
