package me.pixel.animatedblocks;

import javax.swing.*;

/**
 * Oscillator
 * me.pixel.oscillator
 * Created by Pixel.
 */

public class MainCore{

    public static void main(String[] args){

        DisplayModule displayModule = new DisplayModule();
        displayModule.setPreferredSize(displayModule.getWindowSize());
        displayModule.init();

        JFrame displayFrame = new JFrame();
        displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        displayFrame.getContentPane().add(displayModule);
        displayFrame.pack();
        displayFrame.setVisible(true);

        displayModule.start();
    }
}
