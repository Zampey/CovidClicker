package com.company;


import jdk.swing.interop.SwingInterOpUtils;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
@Getter
@Setter
public class Money {

    private long actualMoney;
    private String data;

    private File file = new File("src/com/company/yourMoney.txt");
    public Money() {
            this.read();

    }

public void read(){
    try {

        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            data = reader.nextLine();
            //System.out.println(data);
        }
        reader.close();
    } catch (FileNotFoundException e) {
        System.out.println("An error occurred.(money-file-reader)");
        e.printStackTrace();
    }
}

    public void write(){
        String actualMoneyToString = Long.toString(actualMoney);

        try {
            FileWriter writer = new FileWriter("src/com/company/yourMoney.txt");
            writer.write(actualMoneyToString);
            writer.close();
           // System.out.println(actualMoneyToString);
            //System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.(money-file-writer)");
            e.printStackTrace();
        }


    }




}
