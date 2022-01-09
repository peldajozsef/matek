package hu.bearmaster.tutorial.matek;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Számológép {

    private final PrímTár prímTár;

    public Számológép() {
        this(new PrímTár());
    }

    public Számológép(PrímTár prímTár) {
        this.prímTár = prímTár;
    }

    public boolean prím(int szám) {
        return prímTár.prím(szám);
    }

    public PrímTényezősFelbontás prímFelbontás(int szám) {
        PrímTényezősFelbontás felbontás = new PrímTényezősFelbontás();
        int prím = 2;
        while (szám > 1) {
            if (szám % prím == 0) {
                int tényező = felbontás.getPrímTényező(prím);
                felbontás.setPrímTényező(prím, tényező + 1);
                szám = szám / prím;
            } else {
                prím = prímTár.következőPrím(prím);
            }
        }

        return felbontás;
    }

    public int lkkt(List<Integer> számok) {
        if (számok.size() < 2) {
            return -1;
        }
        List<PrímTényezősFelbontás> felbontások = new ArrayList<>();
        for (int szám : számok) {
            PrímTényezősFelbontás felbontás = prímFelbontás(szám);
            felbontások.add(felbontás);
        }

        Set<Integer> összesPrímOsztók = new HashSet<>();

        for (PrímTényezősFelbontás felbontás : felbontások) {
            összesPrímOsztók.addAll(felbontás.prímek());
        }

        PrímTényezősFelbontás lkktFelbontás = new PrímTényezősFelbontás();

        for (int prím : összesPrímOsztók) {
            int kitevő = 0;
            for (PrímTényezősFelbontás felbontás : felbontások) {
                int aktuálisKitevő = felbontás.getPrímTényező(prím);
                kitevő = aktuálisKitevő > kitevő ? aktuálisKitevő : kitevő;
            }
            lkktFelbontás.setPrímTényező(prím, kitevő);
        }

        return lkktFelbontás.érték();
    }

    public String státusz() {
        return prímTár.státusz();
    }
}
