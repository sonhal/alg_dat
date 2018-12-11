package no.algdat.kapitel.kapitel5;

import no.algdat.hjelpeklasser.Oppgave;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FBinTreTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void leggInn() {
    }

    @Test
    void inorden() {
        int[] p = {1,2,4,5,10,11,22,23,3,6,13,7,14,28,29};
        char[] c = "EIGALOMCBHDKNJF".toCharArray();

        FBinTre<Character> tre = new FBinTre<>();
        for (int i = 0; i < p.length; i++) tre.leggInn(p[i], c[i]);

        tre.inorden(Oppgave.konsollutskrift());

        // Utskrift: G I L A M O C E H D B J N F K
    }

    @Test
    void antall() {
    }

    @Test
    void tom() {
    }

    @Test
    void iterator() {
    }
}