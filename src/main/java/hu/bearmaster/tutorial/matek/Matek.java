package hu.bearmaster.tutorial.matek;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class Matek {

    private static final Számológép számológép = new Számológép();

    public static void main(String[] args) {

        try (Scanner beolvasó = new Scanner(System.in)) {
            while (true) {
                System.out.print("? ");
                String line = beolvasó.nextLine();
                String[] bits = line.split("\\s");
                if (bits.length > 0) {
                    switch (bits[0]) {
                        case "pe":
                            prímSzám(bits);
                            break;
                        case "st":
                            státusz();
                            break;
                        case "pt":
                            prímTényezők(bits);
                            break;
                        case "lkkt":
                            lkkt(bits);
                            break;
                        case "lnko":
                            lnko(bits);
                            break;
                        case "exit":
                        case "quit":
                            return;
                        default:
                            System.out.println("Ismeretlen parancs");
                    }
                }
                System.out.println();
            }
        }
    }

    private static void prímSzám(String[] bits) {
        if (bits.length == 1) {
            System.out.println("Legalább egy paraméter kötelező!");
            prímSzámHasználat();
            return;
        }
        for (int i = 1; i < bits.length; i++) {
            int szám = Integer.parseInt(bits[i]);
            boolean prím = számológép.prím(szám);
            System.out.println(szám + " " + (prím ? "prím" : "összetett") + " szám");
        }
    }

    private static void prímSzámHasználat() {
        System.out.println("pe <szám>[ <szám>]...");
    }

    private static void prímTényezők(String[] bits) {
        if (bits.length == 1) {
            System.out.println("Legalább egy paraméter kötelező!");
            prímTényezőkHasználat();
            return;
        }
        for (int i = 1; i < bits.length; i++) {
            int szám = Integer.parseInt(bits[i]);
            PrímTényezősFelbontás felbontás = számológép.prímFelbontás(szám);
            System.out.println(szám + " = " + felbontás);
        }
    }

    private static void prímTényezőkHasználat() {
        System.out.println("pt <szám>[ <szám>]...");
    }

    private static void lkkt(String[] bits) {
        if (bits.length < 3) {
            System.out.println("Legalább két paraméter kötelező!");
            lkktHasználat();
            return;
        }
        List<Integer> számok = Arrays.stream(bits).skip(1).map(Integer::parseInt).collect(toList());
        int lnko = számológép.lkkt(számok);
        System.out.println(lnko);
    }

    private static void lkktHasználat() {
        System.out.println("lkkt <szám> <szám>[ <szám>]...");
    }

    private static void lnko(String[] bits) {
        if (bits.length < 3) {
            System.out.println("Legalább két paraméter kötelező!");
            lnkoHasználat();
            return;
        }
        List<Integer> számok = Arrays.stream(bits).skip(1).map(Integer::parseInt).collect(toList());
        int lnko = számológép.lnko(számok);
        System.out.println(lnko);
    }

    private static void lnkoHasználat() {
        System.out.println("lnko <szám> <szám>[ <szám>]...");
    }

    private static void státusz() {
        System.out.println(számológép.státusz());
    }
}
