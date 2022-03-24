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
        for (Hrac hrac: hraci) {
            if (hrac.getCisloHracu() == x)
                index = hrac.getCisloHracu();
        }
        return index;
    }

    public void zabiKacku(int poziciaKackyVBalicku, ArrayList<Balicek> balicek, ArrayList<Hrac> hraci, ArrayList<AkcneKarty> balicekAkcny) {
        Iterator<Balicek> itr = balicek.iterator();
        for (int i = 0; i < poziciaKackyVBalicku; i++) {
            itr.next();
        }
        Kacky kacica = (Kacky)itr.next();
        int indexHraca = indexHraca(kacica, hraci);
        hraci.get(indexHraca).zotriKacicu();
        if (hraci.get(indexHraca).kacky.size() == 0) {
            hraci.get(indexHraca).setZivostHraca(false);
            for (int i = 0; i < hraci.get(indexHraca).kartyVRuke.size(); i++) {
                balicekAkcny.add(hraci.get(indexHraca).getKartuVRuke(0));
            }
            hraci.remove(indexHraca);
        }
        balicek.remove(poziciaKackyVBalicku);
    }
}
