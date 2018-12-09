package sample;

import Shapes.Circle;
import Shapes.Shape;
import Shapes.Triangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Main extends java.awt.Frame {
    public Main(){
        super("Shapes");
    }

    public static void main(String[] args) {
        Shape r=new Triangle(200);
        Shape c= new Circle(150);
        r.setX(300);
        r.setY(100);
        c.setX(200);
        c.setY(200);
        MyPanel mp=new MyPanel();
        mp.addShape(r);
        mp.addShape(c);
        Main sp=new Main();
        sp.setSize(1000,500);
        sp.setVisible(true);
        sp.add(mp);

        sp.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
    }
}
