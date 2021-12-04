package com.company;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
@Getter
@Setter
public class ShopPanel extends JPanel implements MouseListener {

    JPanel shopPanel = new JPanel();
    Color sideBarBorderColor = new Color(91, 16, 16);
    Color sideBarBackgroundColor = new Color(114, 21, 21);


    public ShopPanel() {

        shopPanel.setBounds(100, 0, 250, 720);
        shopPanel.setBackground(sideBarBackgroundColor);
        shopPanel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, sideBarBorderColor));
        shopPanel.setLayout(null);
        shopPanel.setVisible(false);



    }









    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
