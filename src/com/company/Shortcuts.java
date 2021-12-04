package com.company;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class Shortcuts {


    private MoneyRW moneyRW = new MoneyRW();
    private String actualMoney = moneyRW.getData();
    private long actualMoneyAsLong = Long.parseLong(actualMoney);
    private Font coinsTextFont = new Font("Serif",0, 40);
    private JLabel coins;
    private IconsInstances iconInstances = new IconsInstances();


     Shortcuts() {
         coins = new JLabel();
         coins.setText(String.valueOf(actualMoney));
         coins.setIcon(iconInstances.getCoinIcon());
         coins.setBounds(495, 15, 250, 50);
         coins.setForeground(Color.WHITE);
         coins.setFont(coinsTextFont);
         coins.setVerticalAlignment(JLabel.CENTER);
         coins.setHorizontalAlignment(JLabel.CENTER);

         this.moneyShortcutSetter();


     }


    public void moneyShortcutSetter(){
        String[] shortcuts = {"K","M", "B", "T", "Qa", "Qi"};

        coinsTextFont = new Font("Serif",0, 35);
        coins.setFont(coinsTextFont);

        coins.setText(String.valueOf(actualMoneyAsLong));

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


}
