package sk.stuba.fei.uim.oop.akcne;

import sk.stuba.fei.uim.oop.AkcneKarty;
import sk.stuba.fei.uim.oop.Hrac;
import sk.stuba.fei.uim.oop.karty.Balicek;

import java.util.ArrayList;


public class DivokyBil extends AkcneKarty {
    @Override
    public void zahrat(ArrayList<Hrac> hraci, Boolean[] pole, ArrayList<Balicek> balicek, int indexKartyVRybniku, ArrayList<AkcneKarty> balicekAkcny) {
        zabiKacku(indexKartyVRybniku, balicek, hraci, balicekAkcny);
        pole[indexKartyVRybniku] = false;
    }
}
