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
}
