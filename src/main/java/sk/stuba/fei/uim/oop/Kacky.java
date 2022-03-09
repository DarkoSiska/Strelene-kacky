package sk.stuba.fei.uim.oop;

public class Kacky extends Karty{
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
