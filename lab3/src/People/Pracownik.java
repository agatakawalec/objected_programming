package People;

public abstract class Pracownik {
    private double wynagrodzenieBrutto;
    private Pesel pesel;
    abstract double wynagrodzenieNetto();

    double getWynagrodzenieBrutto(){
        return wynagrodzenieBrutto;
    }

    Pesel getPesel(){
        return pesel;
    }

    void setWynagrodzenieBrutto(double n){
        this.wynagrodzenieBrutto=n;
    }

    void setPesel(Pesel n){
        this.pesel=n;
    }
}
