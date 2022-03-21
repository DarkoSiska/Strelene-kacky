package sk.stuba.fei.uim.oop.karty;

public class Kacky extends Balicek{
    private boolean zivost;

    public Kacky() {
        this.zivost = true;
    }

    public boolean isZivost() {
        return zivost;
    }

    public void setZivost(boolean zivost) {
        this.zivost = zivost;
    }
}
