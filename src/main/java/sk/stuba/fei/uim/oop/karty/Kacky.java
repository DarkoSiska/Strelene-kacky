package sk.stuba.fei.uim.oop.karty;

public class Kacky extends Balicek{
    private boolean zivost;
    private int prisluchaHracovi;

    public Kacky(int prisluchaHracovi) {
        this.zivost = true;
        this.prisluchaHracovi = prisluchaHracovi;
    }

    public boolean isZivost() {
        return zivost;
    }

    public void setZivost(boolean zivost) {
        this.zivost = zivost;
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
