package no.algdat.uke.hjelpeklasser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import no.algdat.uke.hjelpeklasser.Tabell;

import static org.junit.jupiter.api.Assertions.*;

class TabellTest {
    
    int[] rand_tabel;

    @BeforeEach
    void setUp() {
       rand_tabel = Tabell.randPerm(10);
    }

    @Test
    void bytt() {
    }

    @Test
    void randPerm() {
        System.out.println(rand_tabel[0]);
    }

    @Test
    void randPerm1() {
    }

    @Test
    void maks() {
    }

    @Test
    void maks1() {
    }

    @Test
    void min() {
    }
}