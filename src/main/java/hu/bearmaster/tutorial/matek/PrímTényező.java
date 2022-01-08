package hu.bearmaster.tutorial.matek;

public class PrímTényező {

    private final int prím;

    private final int kitevő;

    public PrímTényező(int prím, int kitevő) {
        this.prím = prím;
        this.kitevő = kitevő;
    }

    public int getPrím() {
        return prím;
    }

    public int getKitevő() {
        return kitevő;
    }

    @Override
    public String toString() {
        return prím + "^" + kitevő;
    }
}
