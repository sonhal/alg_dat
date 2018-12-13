package no.algdat.kapitel.kapitel1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest extends SortertingsTest{

    @Test
    void sorter() {
    }

    @Test
    void parter0() {

    }

    @Test
    void parter() {
        System.out.println(QuickSort.parter(testTab, 0,testTab.length,10, Comparator.naturalOrder()));
        System.out.println(Arrays.toString(testTab));
    }
}