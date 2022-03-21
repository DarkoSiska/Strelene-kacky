package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.karty.Balicek;
import sk.stuba.fei.uim.oop.karty.Kacky;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Iterator;

public class StreleneKackyHra {
    //private Hrac[] hraci;
    ArrayList<Hrac> hraci;
    ArrayList<Balicek> balicek;

    public StreleneKackyHra() {
        int pocetHracov = ZKlavesnice.readInt("Zadajte pocet hracvo: ");
        this.hraci = new ArrayList<>();
        this.hraci = generujHracov(pocetHracov);
        balicek = generujBalicek(pocetHracov);
        System.out.println("asdf");
    }

    public ArrayList<Hrac> generujHracov(int pocetHracov){
        ArrayList<Hrac> poleHracov = new ArrayList<>();
        for (int i = 0; i < pocetHracov; i++) {
            poleHracov.add(new Hrac());
        }
        return poleHracov;
    }

    public ArrayList<Balicek> generujBalicek(int pocetHracov){
        ArrayList<Balicek> balicek = new ArrayList<>();
        for (int i = 0; i < pocetHracov; i++) {
            Hrac hrac = this.hraci.get(i);
            for (int j = 0; j < 5; j++){
                balicek.add(hrac.getKacky(j));
            }
        }
        return balicek;
    }

    public void zabiKacku(int poziciaKackyVBalicku) {
        Iterator<Balicek> itr = balicek.iterator();
        for (int i = 0; i < poziciaKackyVBalicku; i++) {
            itr.next();
        }
        Kacky kacica = (Kacky)itr.next();
        kacica.setZivost(false);
        this.balicek.remove(poziciaKackyVBalicku);
    }

    public void zabiHraca(Hrac hrac){
        boolean zostaneZivy = false;
        for (int i = 0; i < 5; i++) {
            if (hrac.getKacky(i).isZivost()) {
                zostaneZivy = true;
                break;
            }
        }
        if (!zostaneZivy) {
            hrac.setZivost(false);
        }
    }
}
