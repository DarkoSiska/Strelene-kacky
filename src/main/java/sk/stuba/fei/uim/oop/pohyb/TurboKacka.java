package sk.stuba.fei.uim.oop.pohyb;

import sk.stuba.fei.uim.oop.AkcneKarty;
import sk.stuba.fei.uim.oop.Hrac;
import sk.stuba.fei.uim.oop.karty.Balicek;

import java.util.ArrayList;

public class TurboKacka extends AkcneKarty {

    @Override
    public void zahrat(ArrayList<Hrac> hraci, boolean[] pole, ArrayList<Balicek> balicek, int indexKartyVRybniku, ArrayList<AkcneKarty> balicekAkcny) {
        balicek.add(0, balicek.remove(indexKartyVRybniku));
    }
}
