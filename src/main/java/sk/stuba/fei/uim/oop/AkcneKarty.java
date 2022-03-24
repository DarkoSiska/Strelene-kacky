package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.karty.Balicek;
import sk.stuba.fei.uim.oop.karty.Kacky;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AkcneKarty {
    public abstract void zahrat(ArrayList<Hrac> hraci, Boolean[] pole, ArrayList<Balicek> balicek, int indexKartyVRybniku, ArrayList<AkcneKarty> balicekAkcny);
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    public int indexHraca(Kacky kacica, ArrayList<Hrac> hraci) {
        int x = kacica.getPrisluchaHracovi();
        int index = 0;
        for (int i = hraci.size()-1; i > 0 ; i--) {
            if (hraci.get(i).getCisloHracu() == x)
                index = i;
        }
        return index;
    }

    public void zabiKacku(int poziciaKackyVBalicku, ArrayList<Balicek> balicek, ArrayList<Hrac> hraci) {
        Iterator<Balicek> itr = balicek.iterator();
        for (int i = 0; i < poziciaKackyVBalicku; i++) {
            itr.next();
        }
        Kacky kacica = (Kacky)itr.next();
        int indexHraca = indexHraca(kacica, hraci);
        hraci.get(indexHraca).zotriKacicu();
        if (hraci.get(indexHraca).kacky.size() == 0) {
            hraci.get(indexHraca).setZivostHraca(false);
        }
        balicek.remove(poziciaKackyVBalicku);
    }
}
