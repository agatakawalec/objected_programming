package zad3;

public class Punkt2d {
    private double x;
    private double y;

    public Punkt2d(double _x,double _y){
        x=_x;
        y=_y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double _x){
        x=_x;
    }

    public void setY(double _y){
        y=_y;
    }

    public double distance(Punkt2d p){
        return Math.sqrt(Math.pow(x-p.getX(),2)+Math.pow(y-p.getY(),2));
    }
}
