package zad4;
import zad3.Punkt2d;

public class Punkt3d extends Punkt2d{
    private double z;

    public Punkt3d(double _x, double _y, double _z){
        super(_x,_y);
        z=_z;
    }

    public double getZ(){
        return z;
    }

    public void setZ(double _z){
        z=_z;
    }

    public double distance(Punkt3d p){
        return Math.sqrt(Math.pow(getX()-p.getX(),2)+Math.pow(getY()*p.getY(),2)+Math.pow(z-p.z,2));
    }
}
