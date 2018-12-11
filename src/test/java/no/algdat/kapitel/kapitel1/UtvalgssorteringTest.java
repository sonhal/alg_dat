package no.algdat.kapitel.kapitel1;

import no.algdat.hjelpeklasser.Tabell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class UtvalgssorteringTest extends SortertingsTest{



    @Test
    void sorter__empty_array() {
        Integer[] testTab = {};
        System.out.println(Arrays.toString(Utvalgssortering.sorter(testTab, Comparator.naturalOrder())));
    }

    @Test
    void sorter__single_element_array() {
        Integer[] testTab = {1};
        System.out.println(Arrays.toString(Utvalgssortering.sorter(testTab, Comparator.naturalOrder())));
    }

    @Test
    void sorter__normal_case() {
        Integer[] result = Utvalgssortering.sorter(testTab, Comparator.naturalOrder());
        assertArrayEquals(expected, result);
    }
}