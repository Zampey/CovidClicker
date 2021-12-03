package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextLayout;

public class Frame extends JFrame implements MouseListener{
    Money money = new Money();
    String actualMoney = money.getData();
    long actualMoneyAsLong = Long.parseLong(actualMoney);

    JLabel click, coins, shop, achievements, skins, rebirth, settings;
     BgLabel bgLabel = new com.company.BgLabel();
    JFrame mainFrame = new JFrame("Covid-Clicker");
    JPanel sidePanel = new JPanel();


    Color backgroundColor = new Color(145,33,33);
    Color sideBarBorderColor = new Color(114, 21, 21);
    Color sideBarBackgroundColor = new Color(182, 41, 41);
    Font coinsTextFont = new Font("Serif",0, 40);
    Font textFont = new Font("Serif", Font.BOLD, 30);

    Image coinsImg = new ImageIcon("src/com/company/coins.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    ImageIcon coinIcon = new ImageIcon(coinsImg);

    Image bigCovid = new ImageIcon("src/com/company/bigCovid.png").getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH);
    ImageIcon bigCovidIcon = new ImageIcon(bigCovid);

    Image shopImg = new ImageIcon("src/com/company/shop.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    ImageIcon shopIcon = new ImageIcon(shopImg);

    Image achievementsImg = new ImageIcon("src/com/company/trophy.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    ImageIcon achievementsIcon = new ImageIcon(achievementsImg);

    Image skinsImg = new ImageIcon("src/com/company/skinsIcon.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    ImageIcon skinsIcon = new ImageIcon(skinsImg);

    Image rebirthImg = new ImageIcon("src/com/company/refresh.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    ImageIcon rebirthIcon = new ImageIcon(rebirthImg);

    Image settingsImg = new ImageIcon("src/com/company/gear.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    ImageIcon settingsIcon = new ImageIcon(settingsImg);

    boolean openShop = false;
    boolean openAchievements = false;
    boolean openSkins = false;
    boolean openRebirth = false;
    boolean openSettings = false;

        Frame(){

            //Item-shop
            shop = new JLabel();
            shop.setIcon(shopIcon);
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
                achievements.setIcon(achievementsIcon);
                achievements.setBounds(0, 110, 96, 100);
                achievements.setBackground(sideBarBackgroundColor);
                achievements.setOpaque(true);
                achievements.setVerticalAlignment(JLabel.CENTER);
                achievements.setHorizontalAlignment(JLabel.CENTER);
                achievements.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        achievementsSetter();

                    }
                });


                //skins
                skins = new JLabel();
                skins.setIcon(skinsIcon);
                skins.setBounds(0, 220, 96, 100);
                skins.setBackground(sideBarBackgroundColor);
                skins.setOpaque(true);
                skins.setVerticalAlignment(JLabel.CENTER);
                skins.setHorizontalAlignment(JLabel.CENTER);
                skins.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                            skinsSetter();
                    }
                });


            //rebirths
            rebirth = new JLabel();
            rebirth.setIcon(rebirthIcon);
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
            settings.setIcon(settingsIcon);
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


            //number of coins you have
            coins = new JLabel();
            coins.setText(actualMoney);
            coins.setIcon(coinIcon);
            coins.setBounds(495, 15, 250, 50);
            coins.setForeground(Color.WHITE);
            coins.setFont(coinsTextFont);
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
            mainFrame.add(sidePanel);
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

        coinsTextFont = new Font("Serif",0, 35);
        coins.setFont(coinsTextFont);

        if (actualMoneyAsLong >= Math.pow(10, 5)){
            double actualMoneyAsDouble = Math.round((((float)actualMoneyAsLong)/1000) * 100.0) / 100.0;
            coins.setText(Double.toString(actualMoneyAsDouble) + shortcuts[0]);

        }


        if (actualMoneyAsLong >= Math.pow(10, 6)){
            double actualMoneyAsDouble = Math.round((((float)actualMoneyAsLong)/1000000) * 100.0) / 100.0;
            coins.setText(Double.toString(actualMoneyAsDouble) + shortcuts[1]);
        }


        if (actualMoneyAsLong >= Math.pow(10, 9)){
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
