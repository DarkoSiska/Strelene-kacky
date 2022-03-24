package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.karty.Kacky;

import java.util.ArrayList;

public class Hrac {
    ArrayList<Kacky> kacky;
    ArrayList<AkcneKarty> kartyVRuke = new ArrayList<>();
    private final int cisloHracu;
    private boolean zivostHraca;

    public Kacky getKacky(int i) {
        return kacky.get(i);
    }

    public Hrac(int prisluchaHracovi) {
        this.kacky = generujKacky(prisluchaHracovi);
        this.cisloHracu = prisluchaHracovi;
        this.zivostHraca = true;
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

    public AkcneKarty getKartuVRuke(int poradieKarty) {
        return kartyVRuke.get(poradieKarty);
    }

    public int getCisloHracu() {
        return cisloHracu;
    }

    public void setZivostHraca(boolean zivostHraca) {
        this.zivostHraca = zivostHraca;
    }

    public boolean isZivostHraca() {
        return zivostHraca;
    }
}
