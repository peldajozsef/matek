package hu.bearmaster.tutorial.matek;

import java.util.SortedSet;
import java.util.TreeSet;

public class PrímTár {

    private final SortedSet<Integer> prímek = new TreeSet<>();

    public PrímTár() {
        this(100);
    }

    public PrímTár(int maximum) {
        init(maximum);
    }

    public boolean prím(int szám) {
        int minimum = (int)Math.ceil(Math.sqrt(szám));
        generál(minimum);

        SortedSet<Integer> kisebbPrímek = prímek.headSet(szám);
        for (int prím : kisebbPrímek) {
           if (szám % prím == 0) {
               return false;
           }
        }
        return true;
    }

    public int következőPrím(int szám) {
        for (Integer prím : prímek) {
            if (prím > szám) {
                return prím;
            }
        }
        generál(szám * 2 + 1);
        return következőPrím(szám);
    }

    public String státusz() {
        return String.format("Méret: %d%nUtolsó: %d", prímek.size(), prímek.last());
    }

    private void init(int maximum) {
        prímek.add(2);
        prímek.add(3);
        generál(maximum);
    }

    private void generál(int maximum) {
        Integer utolsó = prímek.last();

        for(int i = utolsó + 2; i <= maximum; i += 2) {
            if (prím(i)) {
                prímek.add(i);
            }
        }
    }
}
