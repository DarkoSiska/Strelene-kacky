package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.karty.Kacky;

import java.util.ArrayList;

public class Hrac {
    ArrayList<Kacky> kacky;
    ArrayList<AkcneKarty> kartyVRuke = new ArrayList<>();

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

    public void pridajKartuDoRuky(AkcneKarty karta) {
        this.kartyVRuke.add(karta);
    }

    public void zotriKacicu() {
        this.kacky.remove(0);
    }
}
