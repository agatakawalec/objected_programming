package Shapes;

import java.awt.*;

public abstract class Shape {
    public int size;
    public int x;
    public int y;

    public Shape(int s){
        this.size=s;
    }

    public Shape(){}

    public abstract void draw(Graphics g, int x, int y);

    public abstract int getX();
    public abstract int getY();

    public abstract void setX(int x);
    public abstract void setY(int y);
}
