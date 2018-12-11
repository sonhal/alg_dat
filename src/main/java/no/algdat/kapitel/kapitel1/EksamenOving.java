package no.algdat.kapitel.kapitel1;

public class EksamenOving {


    private EksamenOving(){}


    public static int inversjoner(int[] a){
        int numInversjoner = 0;

        for(int i = 0; i < a.length; i++){
            for(int j = i+1; j < a.length; j++){
                if(a[i] > a[j]) numInversjoner++;
            }
        }
        return numInversjoner;
    }


    public static boolean erSortert(int[] tab){
        for(int i= 1; i < tab.length; i++){
            if(tab[i] < tab[i-1]) return false;
        }
        return true;
    }


}
