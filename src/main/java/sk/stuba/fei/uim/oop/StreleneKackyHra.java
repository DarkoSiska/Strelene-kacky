package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.karty.Balicek;
import sk.stuba.fei.uim.oop.karty.Kacky;
import sk.stuba.fei.uim.oop.karty.Voda;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class StreleneKackyHra {
    ArrayList<Hrac> hraci;
    ArrayList<Balicek> balicek;

    public StreleneKackyHra() {
        Boolean[] zamierovace = new Boolean[6];
        Arrays.fill(zamierovace, Boolean.FALSE);
        int pocetHracov = ZKlavesnice.readInt("Zadajte pocet hracvo: ");
        this.hraci = generujHracov(pocetHracov);
        this.balicek = generujBalicek(pocetHracov);
        vypisHracejPlochy(balicek, zamierovace);
    }

    public ArrayList<Hrac> generujHracov(int pocetHracov){
        ArrayList<Hrac> poleHracov = new ArrayList<>();
        for (int i = 0; i < pocetHracov; i++) {
            poleHracov.add(new Hrac(i));
        }
        return poleHracov;
    }

    public ArrayList<Balicek> generujBalicek(int pocetHracov){
        ArrayList<Balicek> balicek = new ArrayList<>();
        for (int i = 0; i < pocetHracov; i++) {
            for (int j = 0; j < 5; j++){
                balicek.add(this.hraci.get(i).getKacky(j));
            }
        }
        for (int x = 0; x < 6; x++) {
            balicek.add(new Voda());
        }
        Collections.shuffle(balicek);
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

    public void zabiHraca(ArrayList<Hrac> hraci){
        boolean zostaneZivy = false;
        Iterator<Hrac> iter = hraci.iterator();
        int x = 0;
        while (iter.hasNext()) {
            for (int i = 0; i < 5; i++) {
                if (hraci.get(x).getKacky(i).isZivost()) {
                    zostaneZivy = true;
                    break;
                }
            }
            if (!zostaneZivy) {
                hraci.remove(x);
                break;
            }
            zostaneZivy = false;
            x++;
        }
    }

    public void vypisHracejPlochy(ArrayList<Balicek> balicek, Boolean[] zamierovace) {
        for (int i = 0; i < 6; i++) {
            System.out.println(i + ". " + balicek.get(i).vypisKartu() + " " + zamierovace[i]);
        }
    }
}
