package sk.stuba.fei.uim.oop;

import java.util.Random;

public class StreleneKackyHra {

    public StreleneKackyHra() {
        Random random = new Random();
        Hrac[] hraci = generujHracov(random.nextInt(6) + 2);
        System.out.println("pocet hracov je: " + hraci.length);
    }

    public Hrac[] generujHracov(int pocetHracov){
        Hrac[] poleHracov;
        poleHracov = new Hrac[pocetHracov];
        for (int i = 0; i < pocetHracov; i++) {
            poleHracov[i] = new Hrac();
        }
        return poleHracov;
    }
}
