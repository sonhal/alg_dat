package no.algdat.kapitel.kapitel1;

import no.algdat.hjelpeklasser.Tabell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class BoblesorteringTest extends SortertingsTest{


    @Test
    void sorter__empty_array() {
        Integer[] testTab = {};
        System.out.println(Arrays.toString(Boblesortering.sorter(testTab, Comparator.naturalOrder())));
    }

    @Test
    void sorter__single_element_array() {
        Integer[] testTab = {1};
        System.out.println(Arrays.toString(Boblesortering.sorter(testTab, Comparator.naturalOrder())));
    }

    @Test
    void sorter__normal_case() {
        Integer[] result = Boblesortering.sorter(testTab, Comparator.naturalOrder());
        assertArrayEquals(expected, result);
    }

    @Test
    void boble() {
        int[] testTab = {1,2,5,1,4,3,7,5,2};
        System.out.println(Boblesortering.boble(testTab));
    }
}