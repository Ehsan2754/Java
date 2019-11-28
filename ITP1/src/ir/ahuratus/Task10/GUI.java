package ir.ahuratus.Task10;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class Gui extends JFrame {
    //private Graphics g;
    public static  int pixelSize = 25;

    public Gui(int Row, int Colomn , int pixelSize){
        setTitle("Snakes by Ehsan Shaghaei");
        setBackground(Color.GREEN);
        setSize(Colomn*pixelSize,Row*pixelSize);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pixelSize = pixelSize;
    }
    public void showPixel(int x,int y,Color color,Graphics g)throws Exception , IOException,Throwable{

        assert 0<x && x<7 && y<7 && y>0 : "Invalid Pixel";
        setTitle("Snakes by Ehsan Shaghaei");
        setBackground(Color.GREEN);
        setSize(8*pixelSize,8*pixelSize);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pixelSize = pixelSize;
        g.setColor(color);
        g.fillRect(x*pixelSize,y*pixelSize,pixelSize,pixelSize);
    }

}