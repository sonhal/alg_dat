package no.algdat.kapitel.kapitel1;

import java.util.Comparator;

public class Binaersok {


    public static <T> int search(T[] tab, T verdi, Comparator<T> comparator){
        return search(tab,0, tab.length, verdi, comparator);
    }

    public static <T> int search(T[] tab, int fra, int til, T verdi, Comparator<T> comparator){
        int v = fra;
        int h = til -1;

        while(v <= h){
            int m = (v + h)/2;
            if( comparator.compare(verdi, tab[m]) > 0) v = m + 1;
            else if( comparator.compare(verdi, tab[m]) < 0) h = m - 1;
            else return m;
        }
        return -(v+1);
    }

}
