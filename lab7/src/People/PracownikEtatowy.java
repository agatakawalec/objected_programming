package People;

public class PracownikEtatowy extends Pracownik {
    @Override
    double wynagrodzenieNetto() {
        return getWynagrodzenieBrutto() * 0.9;
    }
}
