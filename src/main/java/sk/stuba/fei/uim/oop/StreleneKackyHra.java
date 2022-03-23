package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.akcne.DivokyBil;
import sk.stuba.fei.uim.oop.akcne.Vystrelit;
import sk.stuba.fei.uim.oop.akcne.Zamierit;
import sk.stuba.fei.uim.oop.karty.Balicek;
import sk.stuba.fei.uim.oop.karty.Kacky;
import sk.stuba.fei.uim.oop.karty.Voda;
import sk.stuba.fei.uim.oop.pohyb.KacaciPochod;
import sk.stuba.fei.uim.oop.pohyb.KacaciTanec;
import sk.stuba.fei.uim.oop.pohyb.Rosambo;
import sk.stuba.fei.uim.oop.pohyb.TurboKacka;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class StreleneKackyHra {
    ArrayList<Hrac> hraci = new ArrayList<>();
    ArrayList<Balicek> balicek = new ArrayList<>();
    ArrayList<AkcneKarty> balicekAkcny = new ArrayList<>();

    public StreleneKackyHra() {
        Boolean[] zamierovace = new Boolean[6];
        Arrays.fill(zamierovace, Boolean.FALSE);
        int pocetHracov = ZKlavesnice.readInt("Zadajte pocet Hracov: ");
        generujHracov(pocetHracov);
        generujBalicek(pocetHracov);
        generujBalicekAkcny();
        generujKartyHracom();
        vypisHracejPlochy(balicek, zamierovace);
        System.out.println("123");
    }

    public void generujHracov(int pocetHracov){
        for (int i = 0; i < pocetHracov; i++) {
            this.hraci.add(new Hrac(i));
        }
    }

    public void generujBalicek(int pocetHracov) {
        for (int i = 0; i < pocetHracov; i++) {
            for (int j = 0; j < 5; j++){
                this.balicek.add(this.hraci.get(i).getKacky(j));
            }
        }
        for (int x = 0; x < 5; x++) {
            this.balicek.add(new Voda());
        }
        Collections.shuffle(this.balicek);
    }

    public void generujBalicekAkcny() {
        for (int i = 0; i < 10; i++) {
            this.balicekAkcny.add(new Zamierit());
        }
        for (int i = 0; i < 12; i++) {
            this.balicekAkcny.add(new Vystrelit());
        }
        for (int i = 0; i < 2; i++) {
            this.balicekAkcny.add(new DivokyBil());
        }
        for (int i = 0; i < 6; i++) {
            this.balicekAkcny.add(new KacaciPochod());
        }
        this.balicekAkcny.add(new TurboKacka());
        for (int i = 0; i < 2; i++) {
            this.balicekAkcny.add(new Rosambo());
        }
        this.balicekAkcny.add(new KacaciTanec());
        Collections.shuffle(this.balicekAkcny);
    }

    public void generujKartyHracom() {
        for (Hrac hrac:this.hraci) {
            for (int i = 0; i < 3; i++) {
                hrac.pridajKartuDoRuky(this.balicekAkcny.get(0));
                this.balicekAkcny.remove(0);
            }
        }
    }

    public void zabiKacku(int poziciaKackyVBalicku) {
        Iterator<Balicek> itr = this.balicek.iterator();
        for (int i = 0; i < poziciaKackyVBalicku; i++) {
            itr.next();
        }
        Kacky kacica = (Kacky)itr.next();
        this.hraci.get(kacica.getPrisluchaHracovi()).zotriKacicu();
        if (this.hraci.get(kacica.getPrisluchaHracovi()).kacky.size() == 0) {
            this.hraci.remove(kacica.getPrisluchaHracovi());
        }
        this.balicek.remove(poziciaKackyVBalicku);
    }

    public void vypisHracejPlochy(ArrayList<Balicek> balicek, Boolean[] zamierovace) {
        for (int i = 0; i < 6; i++) {
            System.out.println(i + ". " + balicek.get(i).vypisKartu() + " " + zamierovace[i]);
        }
    }
}
