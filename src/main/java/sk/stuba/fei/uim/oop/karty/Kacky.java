package sk.stuba.fei.uim.oop.karty;

public class Kacky extends Balicek{
    private final int prisluchaHracovi;

    public Kacky(int prisluchaHracovi) {
        this.prisluchaHracovi = prisluchaHracovi;
    }

    public int getPrisluchaHracovi() {
        return prisluchaHracovi;
    }

    @Override
    public String vypisKartu() {
        String stringKacky;
        stringKacky = ("Kacka " + getPrisluchaHracovi());
        return stringKacky;
    }
}
