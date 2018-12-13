package no.algdat.kapitel.kapitel1;

import no.algdat.hjelpeklasser.Tabell;
import org.junit.jupiter.api.BeforeEach;

import java.util.Arrays;

public class SokTest {


    Integer[] testTab;
    Integer[] expected;


    @BeforeEach
    void setUp() {
        int n = 1000;
        int[] tab = Tabell.randPerm(n);
        testTab = new Integer[n];
        expected = new Integer[n];

        for(int i = 0; i < n; i++){
            testTab[i] = tab[i];
            expected[i] = tab[i];
        }
        Arrays.sort(testTab);
        Arrays.sort(expected);
    }
}
