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
                PrímTényező újTényező = felbontás.getPrímTényező(prím)
                        .map(tényező -> new PrímTényező(tényező.getPrím(), tényező.getKitevő() + 1))
                        .orElse(new PrímTényező(prím, 1));
                felbontás.setPrímTényező(újTényező);
                szám = szám / prím;
            } else {
                prím = prímTár.következőPrím(prím);
            }
        }

        return felbontás;
    }

    public int lnko(List<Integer> számok) {
        if (számok.size() < 2) {
            return -1;
        }
        List<PrímTényezősFelbontás> felbontások = new ArrayList<>();
        for (int szám : számok) {
            PrímTényezősFelbontás felbontás = prímFelbontás(szám);
            felbontások.add(felbontás);
        }
        Set<Integer> közösPrímOsztók = new HashSet<>(felbontások.get(0).prímek());

        for (PrímTényezősFelbontás felbontás : felbontások) {
            közösPrímOsztók.retainAll(felbontás.prímek());
        }

        PrímTényezősFelbontás lnkoFelbontás = new PrímTényezősFelbontás();

        for (int prím : közösPrímOsztók) {
            int kitevő = Integer.MAX_VALUE;
            for (PrímTényezősFelbontás felbontás : felbontások) {
                int aktuálisKitevő = felbontás.getPrímTényező(prím).orElseThrow().getKitevő();
                kitevő = Math.min(kitevő, aktuálisKitevő);
            }
            lnkoFelbontás.setPrímTényező(new PrímTényező(prím, kitevő));
        }

        return lnkoFelbontás.érték();
    }

    public String státusz() {
        return prímTár.státusz();
    }
}
