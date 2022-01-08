package hu.bearmaster.tutorial.matek;

import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import static java.util.stream.Collectors.joining;

public class PrímTényezősFelbontás {

    private final SortedMap<Integer, Integer> prímTényezők = new TreeMap<>();

    public Optional<PrímTényező> getPrímTényező(int prím) {
        return Optional.ofNullable(prímTényezők.get(prím)).map(kitevő -> new PrímTényező(prím, kitevő));
    }

    public void setPrímTényező(PrímTényező tényező) {
        prímTényezők.put(tényező.getPrím(), tényező.getKitevő());
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
