package People;

import java.util.LinkedList;

public class Kadry {
    private LinkedList<Pracownik> lista;

    void dodajPracownika(Pesel numer){
        Pracownik nowy = null;
        nowy.setPesel(numer);
        lista.addLast(nowy);

    }

    void usuńPracownika(Pesel numer){
        for(Pracownik it: lista){
            if(it.getPesel().equals(numer)){
                lista.remove(it);
                break;
            }
        }
    }

    Pracownik znajdzPracownika(Pesel numer){
        for(Pracownik it: lista){
            if(it.getPesel().equals(numer)){
                return it;
            }
        }
    }

    double WynagrodzenieBrutto(Pesel numer){
        Pracownik worker= znajdzPracownika(numer);
        return worker.getWynagrodzenieBrutto();
    }

    double WynagrodzenieNetto(Pesel numer){
        Pracownik worker= znajdzPracownika(numer);
        return worker.wynagrodzenieNetto();
    }

}
