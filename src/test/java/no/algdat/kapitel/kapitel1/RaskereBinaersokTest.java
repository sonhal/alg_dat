package no.algdat.kapitel.kapitel1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class RaskereBinaersokTest extends SokTest{



    @Test
    void search() {
        System.out.println(RaskereBinaersok.search(testTab,0,testTab.length,177, Comparator.naturalOrder()));
    }
}