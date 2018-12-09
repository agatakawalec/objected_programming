package People;

public class Student extends Pracownik {

    @Override
    double wynagrodzenieNetto() {
        return getWynagrodzenieBrutto()*0.8;
    }
}
