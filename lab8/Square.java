package Shapes;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static java.lang.Math.sqrt;

public class Square extends Shape{
    public Square(int s){
        super(s);
    }
    @Override
    public void setX(int x) {
        this.x=x;
    }

    @Override
    public void setY(int y) {
        this.y=y;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void draw(Graphics g, int x, int y) {
        Graphics2D g2 =(Graphics2D) g;
        Rectangle2D e=new Rectangle2D.Double(x,y, size, size);
        g2.setColor(Color.red);
        g2.fill(e);
        g2.draw(e);
    }
}
