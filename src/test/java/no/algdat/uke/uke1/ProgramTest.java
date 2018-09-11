package no.algdat.uke.uke1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProgramTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void harmonisk() {
        System.out.println(Program.harmonisk(10));

    }

    @Test
    void euler() {
        /**
         * Prøver å finne n der differansen mellom det harmoniske tallet og log(n) er tilnærmet 0.577
         */

        for(int i = 1; i < 1000; i++){
           System.out.println(Program.euler(i));
        }

    }

    @Test
    void maks() {
    }

    @Test
    void makstest() {
    }

    @Test
    void optionalMaks() {
    }

    @Test
    void randPerm_2_correct() {
        int n = 10;
        int[] a = Program.randPerm_2(n);
        System.out.println(Arrays.toString(a));
        for( int i = 1; i <= 10; i++){
            boolean found = false;
            for(int  j = 0; j < n; j++){
                if(a[j] == i){
                    found = true;
                }
            }
            assertTrue(found, "int " + i + " not found");
        }
    }

    @Test
    void randPerm_2_time() {
        int n = 42000;
        long tid = System.currentTimeMillis();
        int[] a = Program.randPerm_2(n);
        tid = System.currentTimeMillis() - tid;
        System.out.println(tid);
    }

    @Test
    void randPerm_3() {
    }

    @Test
    void bytt() {
    }

    @Test
    void randPerm_4() {
    }

    @Test
    void randPerm_41() {
    }
}