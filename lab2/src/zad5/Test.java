package zad5;
import zad4.Punkt3d;
import java.util.*;

public class Test {
    public static void readPoint(){

    }
    static public void main(String[] argv){
        LinkedList<Punkt3d> punkty;
        System.out.print("1. Wczytaj punkt 3D/n 2. Wyświetl wszystkie punkty/n 3. Oblicz odległość/n 4. Zakończ/n");
        int choice;
        Scanner input=new Scanner(System.in);
        choice=input.nextInt();
        switch(choice){
            case 1:
                int _x,_y, _z;
                System.out.print("Podaj x: ");
                _x=input.nextInt();
                System.out.print("Podaj y: ");
                _y=input.nextInt();
                System.out.print("Podaj z: ");
                _z=input.nextInt();
                Punkt3d point=new Punkt3d(_x,_y,_z);
                punkty.add(point);
        }
    }
}
