package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.akcne.DivokyBil;
import sk.stuba.fei.uim.oop.akcne.Vystrelit;
import sk.stuba.fei.uim.oop.akcne.Zamierit;
import sk.stuba.fei.uim.oop.karty.Balicek;
import sk.stuba.fei.uim.oop.karty.Voda;
import sk.stuba.fei.uim.oop.pohyb.KacaciPochod;
import sk.stuba.fei.uim.oop.pohyb.KacaciTanec;
import sk.stuba.fei.uim.oop.pohyb.Rosambo;
import sk.stuba.fei.uim.oop.pohyb.TurboKacka;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StreleneKackyHra {
    ArrayList<Hrac> hraci = new ArrayList<>();
    ArrayList<Balicek> balicek = new ArrayList<>();
    ArrayList<AkcneKarty> balicekAkcny = new ArrayList<>();
    private final Boolean[] zamierovace = new Boolean[6];

    public StreleneKackyHra() {
        Arrays.fill(zamierovace, Boolean.FALSE);
        int pocetHracov = ZKlavesnice.readInt("Zadajte pocet Hracov: ");
        generujHracov(pocetHracov);
        generujBalicek(pocetHracov);
        generujBalicekAkcny();
        generujKartyHracom();
        zacniHru();
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

    public void vytiahniKartu(Hrac hrac) {
        hrac.pridajKartuDoRuky(this.balicekAkcny.get(0));
        this.balicekAkcny.remove(0);
    }

    public void generujKartyHracom() {
        for (Hrac hrac:this.hraci) {
            for (int i = 0; i < 3; i++) {
                vytiahniKartu(hrac);
            }
        }
    }

    public void vypisHracejPlochy(ArrayList<Balicek> balicek, Boolean[] zamierovace) {
        String zamierovac;
        System.out.println("=====================================");
        for (int i = 0; i < 6; i++) {
            if (zamierovace[i])
                zamierovac = "Zamierene";
            else
                zamierovac = "Nezamierene";
            System.out.println(i + ". " + balicek.get(i).vypisKartu() + " " + zamierovac);
        }
        System.out.println();
    }

    public void hracNaTahu(Hrac hrac) {
        System.out.println("Hrac " + hrac.getCisloHracu());
        System.out.println("Pocet zivotov: " + hrac.kacky.size());
        System.out.println("Ma v ruke:");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + ". " + hrac.getKartuVRuke(i));
        }
    }

    public void zacniHru () {
        while (hraci.size() != 1) {
            for (Hrac hrac:hraci) {
                vypisHracejPlochy(this.balicek, this.zamierovace);
                hracNaTahu(hrac);
                int zahranaKartaZRuke = ZKlavesnice.readInt("Zadajte ktoru kartu chces zahrat: ");
                int poziciaKartyVRybniku = ZKlavesnice.readInt("Ktoru kartu chces oznacit: ");
                System.out.println("=====================================");
                hrac.kartyVRuke.get(zahranaKartaZRuke).zahrat(this.hraci, this.zamierovace, this.balicek, poziciaKartyVRybniku, this.balicekAkcny);
                if (hrac.isZivostHraca()) {
                    hrac.kartyVRuke.remove(zahranaKartaZRuke);
                    vytiahniKartu(hrac);
                }
            }
            System.out.println("+++++++++++++++++++++++++++++++++++++");
        }
        System.out.println("Vyhral Hrac " + this.hraci.get(0).getCisloHracu());
    }
}
