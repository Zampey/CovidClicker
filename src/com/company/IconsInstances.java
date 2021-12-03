package com.company;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class IconsInstances {


    private Image coinsImg = new ImageIcon("src/icons/coins.png").getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
    private ImageIcon coinIcon = new ImageIcon(coinsImg);
    private Image bigCovid = new ImageIcon("src/icons/bigCovid.png").getImage().getScaledInstance(100, 100,  Image.SCALE_SMOOTH);
    private ImageIcon bigCovidIcon = new ImageIcon(bigCovid);
    private Image shopImg = new ImageIcon("src/icons/shop.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    private ImageIcon shopIcon = new ImageIcon(shopImg);
    private Image achievementsImg = new ImageIcon("src/icons/trophy.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    private ImageIcon achievementsIcon = new ImageIcon(achievementsImg);
    private Image skinsImg = new ImageIcon("src/icons/skinsIcon.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    private ImageIcon skinsIcon = new ImageIcon(skinsImg);
    private Image rebirthImg = new ImageIcon("src/icons/refresh.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    private ImageIcon rebirthIcon = new ImageIcon(rebirthImg);
    private Image settingsImg = new ImageIcon("src/icons/gear.png").getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
    private ImageIcon settingsIcon = new ImageIcon(settingsImg);

    IconsInstances(){


    }


}

