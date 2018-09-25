package no.algdat.hjelpeklasser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TabellListeTest {
    TabellListe<String> liste;

    @BeforeEach
    void setUp() {
        liste = new TabellListe<>(Arrays.asList("A", "B", "C", "D"));

    }

    @Test
    void leggInn() {
        liste.leggInn("E");
        assertEquals(liste.hent(4), "E");
    }

    @Test
    void iterator() {
    }

    @Test
    void antall() {
    }

    @Test
    void nullstill() {
    }

    @Test
    void testToString() {
        // default  = 100ms
        long tic = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) liste.toString();
        long toc = System.currentTimeMillis();
        System.out.println(toc - tic);
        System.out.println(liste.toString());
    }

    @Test
    void testToString_tom() {
        TabellListe<String> testL = new TabellListe<>();
        testL.toString();
        System.out.println(testL.toString());
    }
}