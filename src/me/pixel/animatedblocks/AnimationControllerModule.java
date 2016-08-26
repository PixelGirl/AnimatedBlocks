package me.pixel.animatedblocks;
import java.awt.*;

/**
 * AnimatedBlocks
 * me.pixel.animatedblocks
 * Created by Pixel.
 */
public class AnimationControllerModule{

    int animationType = 0;

    Pixel[] pixels;

    public AnimationControllerModule(Pixel[] pixels){
        this.pixels = pixels;
    }

    public boolean generatePixelStatus(Pixel pixel, int timerTick, Dimension dimension){
        switch(animationType){
            case 0:
                if((timerTick & 1) == 0){
                    return (((pixel.getX() & 1) == 0) == ((pixel.getY() & 1) == 0));
                }else{
                    return !(((pixel.getX() & 1) == 0) == ((pixel.getY() & 1) == 0));
                }
            case 1:
                switch(timerTick){
                    case 1: return ((pixel.getX() == 1) && (pixel.getY() == 1));
                    case 2: return ((pixel.getX() == 3) && (pixel.getY() == 1));
                    case 3: return ((pixel.getX() == 5) && (pixel.getY() == 1));
                    case 4: return ((pixel.getX() == 7) && (pixel.getY() == 1));
                    case 5: return ((pixel.getX() == 9) && (pixel.getY() == 1));
                    case 6: return ((pixel.getX() == 7) && (pixel.getY() == 1));
                    case 7: return ((pixel.getX() == 5) && (pixel.getY() == 1));
                    case 8: return ((pixel.getX() == 3) && (pixel.getY() == 1));
                    case 9: return ((pixel.getX() == 1) && (pixel.getY() == 1));
                    case 10: return ((pixel.getX() == 1) && (pixel.getY() == 1));
                    default: return false;
                }
            default: return false;
        }
    }
}
