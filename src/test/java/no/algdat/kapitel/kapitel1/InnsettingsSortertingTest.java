package no.algdat.kapitel.kapitel1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class InnsettingsSortertingTest extends SortertingsTest{


    @Test
    void sorter() {
        Integer[] result = InnsettingsSorterting.sorter(testTab, Comparator.naturalOrder());
        System.out.println(Arrays.toString(result));
        assertArrayEquals(expected, result);
    }

    @Test
    void sorter1() {

    }
}