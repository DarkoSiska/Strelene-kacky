package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.karty.Kacky;

import java.util.ArrayList;

public class Hrac {
    private ArrayList<Kacky> kacky;
    private ArrayList<AkcneKarty> kartyVRuke;
    private final int cisloHracu;
    private boolean zivostHraca;

    public Kacky getKacky(int i) {
        return kacky.get(i);
    }

    public ArrayList<Kacky> getKacky() {
        return kacky;
    }

    public void setKacky(ArrayList<Kacky> kacky) {
        this.kacky = kacky;
    }

    public void setKartyVRuke(ArrayList<AkcneKarty> kartyVRuke) {
        this.kartyVRuke = kartyVRuke;
    }

    public ArrayList<AkcneKarty> getKartyVRuke() {
        return kartyVRuke;
    }

    public Hrac(int prisluchaHracovi) {
        this.kartyVRuke = new ArrayList<>();
        this.kacky = generujKacky(prisluchaHracovi);
        this.cisloHracu = prisluchaHracovi;
        this.zivostHraca = true;
    }

    private ArrayList<Kacky> generujKacky(int prisluchaHracovi) {
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
