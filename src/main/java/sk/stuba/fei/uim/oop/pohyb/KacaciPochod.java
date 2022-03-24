package sk.stuba.fei.uim.oop.pohyb;

import sk.stuba.fei.uim.oop.AkcneKarty;
import sk.stuba.fei.uim.oop.Hrac;
import sk.stuba.fei.uim.oop.karty.Balicek;

import java.util.ArrayList;

public class KacaciPochod extends AkcneKarty {

    @Override
    public void zahrat(ArrayList<Hrac> hraci, Boolean[] pole, ArrayList<Balicek> balicek, int indexKartyVRybniku, ArrayList<AkcneKarty> balicekAkcny) {
        balicek.add(balicek.remove(0));
    }
}
