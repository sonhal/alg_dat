package no.algdat.kapitel.kapitel1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EksamenOvingTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void inversjoner() {
        int[] tab = {1,2,4,3,6,7,9,5,8,10};
        System.out.println(EksamenOving.inversjoner(tab));
    }

    @Test
    void erSortert() {
        int[] tab = {1,2,6,7,8,10};
        System.out.println(EksamenOving.erSortert(tab));
    }
}