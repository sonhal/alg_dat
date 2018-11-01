package no.algdat.hjelpeklasser;

import no.algdat.kapitel.kapitel5.BinTre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OppgaveTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void utforOppgave__print() {
        Oppgave<Character> oppgave = c -> System.out.print(c + " ");  // lambda-uttrykk
        oppgave.utforOppgave('A');  // instansen oppgave har metoden utførOppgave
    }

    @Test
    void utforOppgave__add_to_list() {
        int[] posisjon = {1,2,3,4,5,6,7,10,11,13,14,22,23,28,29};  // posisjoner og
        String[] verdi = "EIBGAHKLODNMCJF".split("");              // verdier i nivåorden

        BinTre<String> tre = new BinTre<>(posisjon, verdi);        // en konstruktør

        Liste<String> liste = new TabellListe<>();  // en liste
        tre.nivåorden(liste::leggInn);          // lambda-uttrykk som argument
        System.out.println(liste);                     // skriver ut listen
    }

}