package com.company;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;


public class BackgroundSong implements ActionListener {


    public BackgroundSong() throws UnsupportedAudioFileException, IOException, LineUnavailableException {

        File file = new File("src/com/company/bgSong.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();

        Timer timer = new Timer(103000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
            }
        });

        timer.start();

    }



    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
