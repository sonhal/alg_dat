package no.algdat.kapitel.kapitel1;

import no.algdat.hjelpeklasser.Tabell;
import no.algdat.hjelpeklasser.TabellKø;

import java.util.Comparator;

public class RaskereBinaersok {


    public static <T> int search(T[] tab, int fra, int til, T verdi, Comparator<T> comparator){
        Tabell.fratilKontroll(tab.length, fra, til);

        int v = fra;
        int h = til -1;

        while (v < h){
            int m = (v+h)/2;
            T mverdi = tab[m];

            if(comparator.compare(verdi, mverdi) > 0) v = m +1;
            else h = m;
        }

        if( comparator.compare(verdi,tab[v]) < 0 ) return -(v+1);
        else if (verdi == tab[v]) return v;
        else return -(v+2);
    }
}
