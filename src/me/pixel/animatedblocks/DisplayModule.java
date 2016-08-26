package me.pixel.animatedblocks;
import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Oscillator
 * me.pixel.oscillator
 * Created by Pixel.
 */

public class DisplayModule extends Applet implements ActionListener{

    private Graphics globalGraphics = null;
    Timer timer = new Timer(100, this);
    AnimationControllerModule animationControllerModule;
    int timerTick = 0;
    Pixel[] pixels;
    int windowWidth = 800;
    int windowHeight = 800;
    Dimension windowSize = new Dimension(windowWidth, windowHeight);
    int pixelSize = 50;
    int pixelAmount = (windowWidth / pixelSize) * (windowHeight / pixelSize);
    Color specialColour = new Color(62, 213, 192);
    Color specialColour2 = new Color(180, 229, 222);
    Color defaultPixelColour = new Color(0, 0, 0);
    Color activatedPixelColour = new Color(255, 255, 255);
    boolean initialized = false;

    public void paint(Graphics g){
        this.setSize(windowSize);
        globalGraphics = g.create();
    }

    public void showPixel(Pixel pixel, Color colour){
        globalGraphics.setColor(colour);
        globalGraphics.fillRect(pixel.getExactX(), pixel.getExactY(), pixel.getGlobalPixelSize(), pixel.getGlobalPixelSize());
    }

    public void init(){
        pixels = new Pixel[pixelAmount];
        for(int i = 1; i < pixelAmount + 1; i++){
            int x = (int) Math.floor((i % (windowWidth / pixelSize)));
            if(x < 0){
                x = (windowWidth / pixelSize);
            }
            int y = ((i - 1) / (windowWidth / pixelSize));
            Pixel pixel = new Pixel(i, pixelSize, x, y, defaultPixelColour);
            pixels[i - 1] = pixel;
        }
        for(Pixel pixel : pixels){
            pixel.setColour(defaultPixelColour);
        }
        animationControllerModule = new AnimationControllerModule(pixels);
        initialized = true;
    }

    public void start(){
        timer.start();
        System.out.println("DisplayModule started.");
    }

    public Dimension getWindowSize(){
        return windowSize;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(timerTick == 10){
            timerTick = 0;
        }
        for(Pixel pixel : pixels){
            if(animationControllerModule.generatePixelStatus(pixel, timerTick, windowSize)){
                showPixel(pixel, activatedPixelColour);
            }else{
                showPixel(pixel, defaultPixelColour);
            }
        }
        timerTick++;
        System.out.println(timerTick);
    }
}
