package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Frame extends JFrame implements MouseListener {

     Panel panel;
     Color backgroundColor = new Color(145,33,33);
     JFrame mainFrame = new JFrame("Covid-Clicker");


     JLabel label;

        Frame(){
            panel = new Panel();

            JLabel click;
            Image bigCovid = new ImageIcon("src/com/company/bigCovid.png").getImage().getScaledInstance(400, 400,  Image.SCALE_SMOOTH);
            ImageIcon bigCovidIcon = new ImageIcon(bigCovid);

            click = new JLabel();
            click.setBounds(0, 0, 400, 400);
            click.setOpaque(true);
            click.addMouseListener((MouseListener) this);
            click.setBackground(new Color(0x0, true));
            click.setIcon(bigCovidIcon);
            click.setHorizontalAlignment(JLabel.CENTER);
            click.setVerticalAlignment(JLabel.CENTER);


            //mainFrame.getContentPane().setBackground(backgroundColor);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setSize(1280, 720);
            mainFrame.add(panel);
            mainFrame.setLocationRelativeTo(null);
            mainFrame.setVisible(true);
            mainFrame.setResizable(false);


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
