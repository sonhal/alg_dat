package no.algdat.kapitel.kapitel1;

import no.algdat.hjelpeklasser.Tabell;

public class Program {


    public static void main(String ... args)      // hovedprogram
    {
        int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.maks(a);   // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);

    } // main


    public static int maks(int[] tab, int fra,  int til){

        openIntervalCheck(tab, fra, til);

        int maks = tab[fra];
        int pos = fra;

        for(; fra < til; fra++){
            if(tab[fra] > maks){
                maks = tab[fra];
                pos = fra;
            }
        }
        return pos;
    }

    public static int maks(int[] tab){
        return maks(tab, 0, tab.length);
    }

    public static int min(int[] tab, int fra, int til){
        openIntervalCheck(tab, fra, til);

        int min = tab[fra];
        int pos = fra;

        for(; fra < til; fra++){
            if(tab[fra] < min){
                min = tab[fra];
                pos = fra;
            }
        }
        return pos;
    }

    public static int min(int[] tab){
        return min(tab,0, tab.length);
    }


    private static void openIntervalCheck(int[] tab, int fra, int til){
        if (fra < 0 || til > tab.length || fra >= til)
            throw new IllegalArgumentException("Illegalt intervall!");
    }


}
