package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.karty.Kacky;

import java.util.ArrayList;

public class Hrac {
    ArrayList<Kacky> kacky;

    public Kacky getKacky(int i) {
        return kacky.get(i);
    }

    public Hrac(int prisluchaHracovi) {
        this.kacky = generujKacky(prisluchaHracovi);
    }

    public ArrayList<Kacky> generujKacky(int prisluchaHracovi) {
        ArrayList<Kacky> kacky = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            kacky.add(new Kacky(prisluchaHracovi));
        }
        return kacky;
    }
}
