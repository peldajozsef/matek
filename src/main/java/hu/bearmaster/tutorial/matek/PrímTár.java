package hu.bearmaster.tutorial.matek;

import java.util.ArrayList;
import java.util.List;

public class PrímTár {

    private final List<Integer> prímek = new ArrayList<>();

    public PrímTár() {
        this(100);
    }

    public PrímTár(int maximum) {
        init(maximum);
    }

    public boolean prím(int szám) {
        for (int prím : prímek) {
           if (szám % prím == 0) {
               return szám == prím;
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

    private void init(int maximum) {
        prímek.add(2);
        prímek.add(3);
        generál(maximum);
    }

    private void generál(int maximum) {
        Integer utolsó = prímek.get(prímek.size() - 1);

        for(int i = utolsó + 2; i <= maximum; i += 2) {
            if (prím(i)) {
                prímek.add(i);
            }
        }
    }
}
