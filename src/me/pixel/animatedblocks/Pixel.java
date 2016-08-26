package me.pixel.animatedblocks;
import java.awt.*;

public class Pixel{

    int id;
    int x;
    int y;
    int globalPixelSize;
    Color colour;

    public Pixel(int id, int pixelSize){
        this.id = id;
        globalPixelSize = pixelSize;
    }

    public Pixel(int id, int pixelSize, int x, int y){
        this.id = id;
        this.x = x;
        this.y = y;
        globalPixelSize = pixelSize;
    }

    public Pixel(int id, int pixelSize, int x, int y, Color colour){
        this.id = id;
        this.x = x;
        this.y = y;
        this.colour = colour;
        globalPixelSize = pixelSize;
    }

    public int getId() {
        return id;
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX(){
        return x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getY(){
        return y;
    }

    public int getExactX(){
        return x * globalPixelSize;
    }

    public int getExactY(){
        return y * globalPixelSize;
    }

    public void setColour(Color colour){
        this.colour = colour;
    }

    public Color getColour(){
        return this.colour;
    }

    public int getGlobalPixelSize() {
        return globalPixelSize;
    }
}
