package sk.stuba.fei.uim.oop.pohyb;

import sk.stuba.fei.uim.oop.AkcneKarty;
import sk.stuba.fei.uim.oop.Hrac;
import sk.stuba.fei.uim.oop.karty.Balicek;

import java.util.ArrayList;
import java.util.Collections;

public class Rosambo extends AkcneKarty {
    @Override
    public void zahrat(ArrayList<Hrac> hraci, Boolean[] pole, ArrayList<Balicek> balicek, int indexKartyVRybniku, ArrayList<AkcneKarty> balicekAkcny) {
        Collections.shuffle(balicek.subList(0, 6));
    }
}
