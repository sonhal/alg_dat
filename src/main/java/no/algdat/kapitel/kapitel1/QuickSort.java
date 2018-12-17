package no.algdat.kapitel.kapitel1;
import no.algdat.hjelpeklasser.Tabell;
import java.util.Comparator;

public class QuickSort {


    public static <T> T[] sorter(T[] tab, Comparator<T> comparator) {

        return tab;
    }

    public static <T> int parter0(T[] tab, int v, int h, T skilleverdi, Comparator<? super T> comparator){
        while(true){

            while (v <= h && comparator.compare(tab[v], skilleverdi) < 0 )v++;
            while (v <= h && comparator.compare(tab[h], skilleverdi) >= 0 )h--;

            if(v < h) Tabell.bytt(tab,v++,h--);
            else return v;
        }
    }

    public static <T> int parter(T[] tab, int fra, int til, T skilleverdi, Comparator<? super T> comparator) {
        return parter0(tab, fra, til - 1, skilleverdi, comparator);
    }



}