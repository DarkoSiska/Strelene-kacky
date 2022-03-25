package sk.stuba.fei.uim.oop.akcne;

import sk.stuba.fei.uim.oop.AkcneKarty;
import sk.stuba.fei.uim.oop.Hrac;
import sk.stuba.fei.uim.oop.karty.Balicek;
import sk.stuba.fei.uim.oop.karty.Kacky;

import java.util.ArrayList;


public class DivokyBil extends AkcneKarty {
    @Override
    public void zahrat(ArrayList<Hrac> hraci, boolean[] pole, ArrayList<Balicek> balicek, int indexKartyVRybniku, ArrayList<AkcneKarty> balicekAkcny) {
        if (balicek.get(indexKartyVRybniku).getClass() == Kacky.class) {
            zabiKacku(indexKartyVRybniku, balicek, hraci);
        }
        pole[indexKartyVRybniku] = false;
    }
}
