package zad5;
import java.util.*;

public class LiczbyPierwsze {
    private int licznik;
    private int number;
    private List<Integer> list;

    public LiczbyPierwsze(int _number) {
        number = _number;
        licznik = 0;
        list = new ArrayList<Integer>();
        for(int i=2; i<=number; i++) list.add(i);
    }

    public List<Integer> sito() {
        for (int j = 2; j <= Math.sqrt(number); j++) {
            for(int i=0; i<list.size(); i++){
                if(list.get(i)%j==0 && list.get(i)!=j){
                    list.remove(i);
                }
            }
        }
        System.out.print(list);
        return list;
    }

}
