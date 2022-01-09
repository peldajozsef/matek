package hu.bearmaster.tutorial.matek;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import static java.util.stream.Collectors.joining;

public class PrímTényezősFelbontás {

    private final SortedMap<Integer, Integer> prímTényezők = new TreeMap<>();

    public int getPrímTényező(int prím) {
        return prímTényezők.getOrDefault(prím, 0);
    }

    public void setPrímTényező(int prím, int kitevő) {
        prímTényezők.put(prím, kitevő);
    }

    public Set<Integer> prímek() {
        return Set.copyOf(prímTényezők.keySet());
    }

    public int érték() {
        return prímTényezők.entrySet().stream()
                .mapToInt(entry -> (int)Math.pow(entry.getKey(), entry.getValue()))
                .reduce(1, (a, b) -> a * b);
    }

    @Override
    public String toString() {
        return prímTényezők.entrySet().stream()
                .map(entry -> entry.getKey() + "^" + entry.getValue())
                .collect(joining("*"));
    }
}
