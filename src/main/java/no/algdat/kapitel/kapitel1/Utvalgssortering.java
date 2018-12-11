package no.algdat.kapitel.kapitel1;

import no.algdat.hjelpeklasser.Tabell;

import java.util.Arrays;
import java.util.Comparator;

public class Utvalgssortering {


    public static <T> T[] sorter(T[] tab, Comparator<T> comparator){
        T[] tabell = Arrays.copyOf(tab, tab.length);

        for(int i = 0; i < tabell.length; i++){
            Tabell.bytt(tabell, i, min(tabell,i, tabell.length, comparator));
        }
        return tabell;
    }

    private static <T> int min(T[] tab, int fra, int til, Comparator<T> comparator){

        T min = tab[fra];
        int minPos = fra;

        for(;fra < til; fra++){
            if (comparator.compare(tab[fra],min) < 0){
                min = tab[fra];
                minPos = fra;
            }
        }
        return minPos;
    }
}
