package hu.bearmaster.tutorial.matek;

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

    public String státusz() {
        return prímTár.státusz();
    }
}
