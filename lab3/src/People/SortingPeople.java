package People;

import java.util.Comparator;

public class SortingPeople implements Comparator<Pracownik> {
    @Override
    public int compare(Pracownik p1, Pracownik p2) {
        if(p1.getWynagrodzenieBrutto()>=p2.getWynagrodzenieBrutto()){
            return 1;
        }
        else return 0;
    }
}
