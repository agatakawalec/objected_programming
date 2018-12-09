package sample;
import Shapes.Shape;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

public class MyPanel extends java.awt.Panel implements MouseMotionListener, MouseListener {
    public LinkedList<Shape> lista=new LinkedList<>();
    Shape movingShape;

    MyPanel(){
        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(1000, 500));
    }

    void addShape(Shape shape){
        lista.add(shape);
    }


    @Override
    public void paint(Graphics g) {
        int x1;
        int y1;
        for(int i=0; i<lista.size(); i++){
                int odstep=(int) lista.get(i).size+50;
                x1=lista.get(i).x;
                y1=lista.get(i).y;
                lista.get(i).draw(g,x1,y1);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e){
        movingShape = null;
    }
    public void mouseMoved(MouseEvent e){

    }
    public void mouseDragged(MouseEvent e){
        if (movingShape != null) {
            movingShape.x = e.getX();
            movingShape.y = e.getY();
        }
        repaint();
    }

    public void mousePressed(MouseEvent e) {
        int x1 = e.getX();
        int y1 = e.getY();

        int x2, y2;
        if (e.getButton() == MouseEvent.BUTTON1) {
            int index = 0;
            int size = lista.size();
            Shape p;
            while (movingShape == null && index < size) {
                p = lista.get(index);
                x2 = p.getX();
                y2 = p.getY();
                if (x1 >= x2 && y1 >= y2 && x1 <= x2+p.size  && y1 <= y2+p.size)
                    movingShape = p;
                index++;
            }
        }

        repaint();
    }
}
