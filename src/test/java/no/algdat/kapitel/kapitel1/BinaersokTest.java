package no.algdat.kapitel.kapitel1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class BinaersokTest {

    Integer[] testTab;


    @BeforeEach
    void setUp() {
        int[] t = {1,2,2,5,6,7,8,9,9,11};
        testTab = new Integer[t.length];
        for(int i = 0; i < testTab.length; i++){
            testTab[i] = t[i];
        }
    }

    @Test
    void search() {
        System.out.println(Binaersok.search(testTab, 8, Comparator.naturalOrder()));
    }
}