package no.algdat.uke.uke6;

import no.algdat.hjelpeklasser.Beholder;
import no.algdat.hjelpeklasser.TabellBeholder;

public class Program {

public static void main(String[] args){
    Beholder<Integer> beholder = new TabellBeholder<Integer>();

    for (int i = 1; i <= 10; i++) beholder.leggInn(i);

    System.out.println("Antall verdier: " + beholder.antall());
    System.out.println(beholder);  // bruker metoden toString

    System.out.println("Fjerner oddetallene: ");
    for (int i = 1; i <= 10; i++)
        if (i % 2 != 0) beholder.fjern(i);  // fjerner odddetallene

    System.out.println(beholder);  // bruker metoden toString

    // Utskrift:
    // Antall verdier: 10
    // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    // Fjerner oddetallene:
    // [2, 4, 6, 8, 10]
}

}
