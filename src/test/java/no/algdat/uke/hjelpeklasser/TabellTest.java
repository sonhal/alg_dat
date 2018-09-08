package no.algdat.uke.hjelpeklasser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TabellTest {

    @BeforeEach
    void setUp() {
        int[] testTabell = Tabell.randPerm(10);
    }

    @Test
    void bytt() {
        int[] byttTabell = {1,2};
        int[] testTabell = {2,1};
        Tabell.bytt(byttTabell,0,1);
        assertArrayEquals(testTabell, byttTabell, "Feil i bytting");
    }

    @Test
    void randPerm() {
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

    @Test
    void fratilKontroll() {
    }

    @Test
    void vhKontroll() {
    }

    @Test
    void bytt1() {
    }

    @Test
    void bytt2() {
    }

    @Test
    void skriv() {
    }

    @Test
    void skriv1() {
    }

    @Test
    void skrivln() {
    }

    @Test
    void skrivln1() {
    }

    @Test
    void skriv2() {
    }

    @Test
    void skriv3() {
    }

    @Test
    void skrivln2() {
    }

    @Test
    void skrivln3() {
    }

    @Test
    void randPerm2() {
    }

    @Test
    void randPerm3() {
    }

    @Test
    void maks2() {
    }

    @Test
    void maks3() {
    }

    @Test
    void min1() {
    }

    @Test
    void min2() {
    }

    @Test
    void naturligeTall() {
    }

    @Test
    void heleTall() {
    }

    @Test
    void snu() {
    }

    @Test
    void snu1() {
    }

    @Test
    void snu2() {
    }

    @Test
    void snu3() {
    }

    @Test
    void nestMaks() {
        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = Tabell.nestMaks(a);  // metoden returnerer en tabell

        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);
    }

    @Test
    void nestMaks2() {
        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = Tabell.nestMaks2(a);  // metoden returnerer en tabell

        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

        Tabell.skrivln(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);
    }

    @Test
    void nestMaks3() {
    }

    @Test
    void sortering() {
        int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        Tabell.sortering(a);
        Tabell.skriv(a);
    }
}