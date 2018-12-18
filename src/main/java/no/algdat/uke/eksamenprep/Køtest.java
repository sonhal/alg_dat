package no.algdat.uke.eksamenprep;

import java.util.LinkedList;
import java.util.Queue;

public class Køtest {





    public static void main(String[] args){
        Queue<Character> kø = new LinkedList<>();
        char[] c = "ABCDEFGHI".toCharArray();
        for (char d : c) kø.add(d);
        System.out.println(kø);                  // [A, B, C, D, E, F, G, H, I]
        int antall = fjernBakerst(kø,5);
        System.out.println(antall + " " + kø);   // 5 [A, B, C, D]
        antall = fjernBakerst(kø,5);
        System.out.println(antall + " " + kø);   // 4 []

    }




    public static <T> int fjernBakerst(Queue<T> kø, int antall){

        if(antall < 0) throw new IllegalArgumentException("Negativt tall");
        int n = kø.size();

        if(antall >= n){
            kø.clear();
            return n;
        }

        for(int i = n -antall; i > 0; i--)kø.add(kø.poll());
        for(int  i = 0; i < antall; i++)kø.poll();

        return antall;

    }
}
