package sk.stuba.fei.uim.oop.akcne;

import sk.stuba.fei.uim.oop.AkcneKarty;
import sk.stuba.fei.uim.oop.Hrac;
import sk.stuba.fei.uim.oop.karty.Balicek;

import java.util.ArrayList;

public class Zamierit extends AkcneKarty {

    @Override
    public void zahrat(ArrayList<Hrac> hraci, boolean[] pole, ArrayList<Balicek> balicek, int indexKartyVRybniku, ArrayList<AkcneKarty> balicekAkcny) {
        pole[indexKartyVRybniku] = true;
    }
}
