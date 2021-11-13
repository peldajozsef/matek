package hu.bearmaster.tutorial.matek;

import java.util.Scanner;

public class Matek {

    private static final Számológép számológép = new Számológép();

    public static void main(String[] args) {

        try (Scanner beolvasó = new Scanner(System.in)) {
            while (true) {
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
                        case "exit":
                        case "quit":
                            return;
                        default: System.out.println("Ismeretlen parancs");
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

    private static void státusz() {
        System.out.println(számológép.státusz());
    }
}
