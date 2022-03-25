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

public class StreleneKackyHra {
    ArrayList<Hrac> hraci = new ArrayList<>();
    ArrayList<Balicek> balicek = new ArrayList<>();
    ArrayList<AkcneKarty> balicekAkcny = new ArrayList<>();
    private final boolean[] zamierovace = new boolean[6];

    public StreleneKackyHra() {
        Arrays.fill(zamierovace, Boolean.FALSE);
        int pocetHracov = 0;
        while (pocetHracov < 2 || pocetHracov > 6) {
            pocetHracov = ZKlavesnice.readInt("Zadajte pocet Hracov (musi byt cislo medzi 2 a 6): ");
        }
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

    public void vypisHracejPlochy(ArrayList<Balicek> balicek, boolean[] zamierovace) {
        String zamierovac;
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

    public void zabiHraca(Hrac hrac, int indexHraca) {
        for (int i = 0; i < hrac.kartyVRuke.size(); i++) {
            this.balicekAkcny.add(hrac.getKartuVRuke(0));
            hrac.kartyVRuke.remove(0);
        }
        this.hraci.remove(indexHraca);
    }

    public void zotriHraca(ArrayList<Hrac> hraci) {
        for (int i = hraci.size()-1; i >= 0 ; i--) {
            if (!hraci.get(i).isZivostHraca()) {
                zabiHraca(hraci.get(i), i);
            }
        }
    }

    public boolean asponDvajaSuZivy(ArrayList<Hrac> hraci) {
        int pocetZivychHracov = hraci.size();
        for (int i = hraci.size()-1; i > 0 ; i--) {
            if (!hraci.get(i).isZivostHraca())
                pocetZivychHracov--;
        }
        return pocetZivychHracov >= 2;
    }

    public void zahodKartu (Hrac hrac) {
        hrac.kartyVRuke.remove(0);
        vytiahniKartu(hrac);
    }

    public boolean vsetkyZamierovaceSuAktivne (boolean[] zamierovace) {
        boolean vsetkyZamierovaceSuAktivne = true;
        for (boolean zamierovac: zamierovace) {
            if (!zamierovac) {
                vsetkyZamierovaceSuAktivne = false;
                break;
            }
        }
        return vsetkyZamierovaceSuAktivne;
    }

    public boolean zamierovaceVynimka (Hrac hrac, boolean[] zamierovace){
        boolean vsetkyKartySuZameriovace = true;
        for (AkcneKarty karta: hrac.kartyVRuke) {
            if (karta.getClass() != Zamierit.class) {
                vsetkyKartySuZameriovace = false;
                break;
            }
        }

        return vsetkyKartySuZameriovace && vsetkyZamierovaceSuAktivne(zamierovace);
    }

    public boolean ziadenZamierovacNieJeAktivny (boolean[] zamierovace) {
        boolean ziadenZamierovacNieJeAktivny = true;
        for (boolean zamierovac: zamierovace) {
            if (zamierovac) {
                ziadenZamierovacNieJeAktivny = false;
                break;
            }
        }
        return ziadenZamierovacNieJeAktivny;
    }

    public boolean vystrelitVynimka (Hrac hrac, boolean[] zamierovace){
        boolean vsetkyKartySuVystrelit = true;
        for (AkcneKarty karta: hrac.kartyVRuke) {
            if (karta.getClass() != Vystrelit.class) {
                vsetkyKartySuVystrelit = false;
                break;
            }
        }
        return vsetkyKartySuVystrelit && ziadenZamierovacNieJeAktivny(zamierovace);
    }

    public boolean mozeBytZahranaKarta (Hrac hrac, boolean[] zamierovace, int indexKarty) {
        if (hrac.kartyVRuke.get(indexKarty).getClass() == Zamierit.class && vsetkyZamierovaceSuAktivne(zamierovace)) {
            System.out.println("karta nemoze byt zahrana, lebo su vsetky zamierovace aktivne");
            return false;
        }
        if (hrac.kartyVRuke.get(indexKarty).getClass() == Vystrelit.class && ziadenZamierovacNieJeAktivny(zamierovace)) {
            System.out.println("karta nemoze byt zahrana, lebo ziaden zamierovac nie je aktivny");
            return false;
        }
        else
            return true;
    }

    public boolean potrebujePole(Hrac hrac, int indexKarty) {
        if (hrac.kartyVRuke.get(indexKarty).getClass() == Zamierit.class) {
            return true;
        }
        if (hrac.kartyVRuke.get(indexKarty).getClass() == Vystrelit.class) {
            return true;
        }
        if (hrac.kartyVRuke.get(indexKarty).getClass() == DivokyBil.class) {
            return true;
        }
        if (hrac.kartyVRuke.get(indexKarty).getClass() == TurboKacka.class) {
            return true;
        }
        return false;
    }

    public boolean spravneOznacenaKartaVRybniku (Hrac hrac, int indexKarty, int indexVRybniku, ArrayList<Balicek> balik, boolean[] zamierovace) {
        if (hrac.kartyVRuke.get(indexKarty).getClass() == Zamierit.class) {
            if (zamierovace[indexVRybniku])
                return false;
        }
        if (hrac.kartyVRuke.get(indexKarty).getClass() == Vystrelit.class) {
            if (!zamierovace[indexVRybniku])
                return false;
        }
        if (hrac.kartyVRuke.get(indexKarty).getClass() == TurboKacka.class) {
            if (balik.get(indexVRybniku).getClass() != Kacky.class)
                return false;
        }
        return true;
    }

    public void zacniHru () {
        while (this.hraci.size() != 1) {
            for (Hrac hrac:this.hraci) {
                    if (hrac.isZivostHraca() && asponDvajaSuZivy(this.hraci)) {
                        vypisHracejPlochy(this.balicek, this.zamierovace);
                        hracNaTahu(hrac);
                        if (vystrelitVynimka(hrac, zamierovace) || zamierovaceVynimka(hrac, zamierovace)) {
                            zahodKartu(hrac);
                            System.out.println("Ziadna karta nemohla byt zahrana");
                            break;
                        }
                        int zahranaKartaZRuke;
                            do {
                                do {
                                    zahranaKartaZRuke = ZKlavesnice.readInt("Zadajte ktoru kartu chces zahrat (hodnota musi byt medzi 0 a 2): ");
                                } while (zahranaKartaZRuke < 0 || zahranaKartaZRuke > 2);
                            } while (!mozeBytZahranaKarta(hrac, zamierovace, zahranaKartaZRuke));
                        int poziciaKartyVRybniku = -1;
                        while (potrebujePole(hrac, zahranaKartaZRuke) && poziciaKartyVRybniku == -1) {
                            while (poziciaKartyVRybniku < 0 || poziciaKartyVRybniku > 5) {
                                poziciaKartyVRybniku = ZKlavesnice.readInt("Ktoru kartu chces oznacit (hodnota musi byt medzi 0 a 5): ");
                            }
                            if (!spravneOznacenaKartaVRybniku(hrac, zahranaKartaZRuke, poziciaKartyVRybniku, this.balicek, zamierovace)) {
                                System.out.println("Nespravne oznacena karta v rybniku, skus znovu");
                                poziciaKartyVRybniku = -1;
                            }
                        }
                        hrac.kartyVRuke.get(zahranaKartaZRuke).zahrat(this.hraci, this.zamierovace, this.balicek, poziciaKartyVRybniku, this.balicekAkcny);
                        if (hrac.isZivostHraca()) {
                            this.balicekAkcny.add(hrac.kartyVRuke.get(zahranaKartaZRuke));
                            hrac.kartyVRuke.remove(zahranaKartaZRuke);
                            vytiahniKartu(hrac);
                        }
                    }
                }
            zotriHraca(this.hraci);
            System.out.println("=======================================");
        }
        System.out.println("Vyhral Hrac " + this.hraci.get(0).getCisloHracu());
    }
}
