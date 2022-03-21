package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.karty.Kacky;

import java.util.ArrayList;

public class Hrac {
    private boolean zivost;
    ArrayList<Kacky> kacky;

    public boolean isZivost() {
        return zivost;
    }

    public void setZivost(boolean zivost) {
        this.zivost = zivost;
    }

    public Kacky getKacky(int i) {
        return kacky.get(i);
    }

    public Hrac() {
        this.kacky = generujKacky();
        this.zivost = true;
    }

    public ArrayList<Kacky> generujKacky() {
        ArrayList<Kacky> kacky = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            kacky.add(new Kacky());
        }
        return kacky;
    }
}
