package no.algdat.kapitel.kapitel1;

import no.algdat.hjelpeklasser.Tabell;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class InnsettingsSorterting {

    public static <T> T[] sorter(T[] tab, int fra, int til, Comparator<? super T> comparator){
        Tabell.fratilKontroll(tab.length,fra, til);

        T[] tabell = Arrays.copyOf(tab,tab.length);

        for(int i = fra + 1; i  < til; i++){
            T verdi = tabell[i];
            int j = i-1;
            for(; j >= 0; j--){
                if(comparator.compare(tabell[j], verdi) < 0) break;
                tabell[j+1] = tabell[j];
            }
            tabell[j+1] = verdi;
        }
        return tabell;
    }

    public static <T> T[] sorter(T[] tab, Comparator<? super T> comparator){
        return sorter(tab, 0, tab.length, comparator);
    }
}
