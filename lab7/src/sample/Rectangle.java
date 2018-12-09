package Shapes;

import java.awt.*;

import static java.lang.Math.sqrt;

public class Rectangle extends Shape{
    public Rectangle(int s){
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
    public void draw(Graphics g, int x, int y) { }
}