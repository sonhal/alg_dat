package no.algdat.kapitel.kapitel5;

import no.algdat.hjelpeklasser.Oppgave;
import no.algdat.hjelpeklasser.Tabell;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

class BinTreTest {

    BinTre<Integer> testTre;

    @BeforeEach
    void setUp() {
        testTre = new BinTre<>();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void leggInn() {
        for(int i = 1; i <= 10; i++){
            testTre.leggInn(i,i);
        }
        assertEquals(10, testTre.antall());
    }

    @Test
    void antall() {
    }

    @Test
    void tom() {
    }

    @Test
    void nivåorden() {
        int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
        String[] verdi = "EIBGAHKLODNMCJF".split("");              // verdier i nivåorden

        BinTre<String> tre = new BinTre<>(posisjon, verdi);        // en konstruktør
        tre.nivåorden(System.out::print);  // Utskrift: E I B G A H K L O D N M C J F
    }

    @Test
    void nivaer() {
        int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // nodeposisjoner
        String[] verdi = "EIBGAHKLODNMCJF".split("");              // verdier i nivåorden

        BinTre<String> tre = new BinTre<>(posisjon, verdi);        // en konstruktør

        int[] nivåer = tre.nivaer();  // bruker Programkode 5.1.6 k)

        System.out.print("Nivåer: " + Arrays.toString(nivåer));
        System.out.print(" Treets bredde: " + nivåer[Tabell.maks(nivåer)]);
        System.out.println(" Treets høyde: " + (nivåer.length - 1));

        // Utskrift: Nivåer: [1, 2, 4, 4, 4] Treets bredde: 4 Treets høyde: 4

    }

    @Test
    void preorden() {
        int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
        String[] verdi = "EIBGAHKLODNMCJF".split("");              // verdier i nivåorden
        BinTre<String> tre = new BinTre<>(posisjon, verdi);        // en konstruktør

        StringJoiner s = new StringJoiner(", " ,"[", "]");         // StringJoiner
        tre.preorden(tegn -> s.add(tegn));                         // tegn = String

        System.out.println(s);
        // Utskrift: [E, I, G, A, L, O, M, C, B, H, D, K, N, J, F]
    }

    @Test
    void inorden() {
        int[] posisjon = {1,2,3,4,5,6,7,9,10,11,12,14};       // posisjonene og
        Integer[] verdi = {7,3,10,1,5,9,12,2,4,6,8,11};       // verdiene i nivåorden

        BinTre<Integer> tre = new BinTre<>(posisjon, verdi);  // konstruktør

        tre.inorden(Oppgave.konsollutskrift());               // skriver ut
        // Utskrift: 1 2 3 4 5 6 7 8 9 10 11 12
    }
}