package no.algdat.kapitel.kapitel1;

import no.algdat.hjelpeklasser.Tabell;

import java.util.Arrays;
import java.util.Comparator;

public class Boblesortering<T> {

    private Boblesortering(){}


    public static <T> T[] sorter(T[] tab, Comparator<T> comparator) {
        T[] tabell = Arrays.copyOf(tab, tab.length);

        for (int i= tabell.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (comparator.compare(tabell[j - 1], tabell[j]) > 0) {
                    Tabell.bytt(tabell, j - 1, j);
                }
            }
        }
        return tabell;
    }

    public static int boble(int[] tab){
        int antall = 0;
        for( int i = 1; i < tab.length; i++){
            if(tab[i-1] > tab[i]) {
                antall++;
                Tabell.bytt(tab, i, i-1);
            }
        }
        return antall;
    }


}
