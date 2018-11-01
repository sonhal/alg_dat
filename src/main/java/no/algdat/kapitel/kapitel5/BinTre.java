package no.algdat.kapitel.kapitel5;

import no.algdat.hjelpeklasser.Kø;
import no.algdat.hjelpeklasser.Oppgave;
import no.algdat.hjelpeklasser.TabellKø;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

public class BinTre<T> {

    private static final class Node<T> { // en indre node klasse
        private T verdi;
        private Node<T> venstre;
        private Node<T> hoyre;

        private Node(T verdi, Node<T> v, Node<T> h){
            this.verdi = verdi; this.venstre = v; this.hoyre = h;
        }

        private Node(T verdi){this.verdi = verdi;}

    } // class Node<T>

    private Node<T> rot; // referanse til rot noden
    private int antall; // antall noder i treet

    public BinTre(){rot = null; antall = 0;}

    public BinTre(int[] posisjon, T[] verdi)  // konstruktør
    {
        if (posisjon.length > verdi.length) throw new
                IllegalArgumentException("Verditabellen har for få elementer!");

        for (int i = 0; i < posisjon.length; i++) leggInn(posisjon[i],verdi[i]);
    }

    public final void leggInn(int posisjon, T verdi){
        if(posisjon < 1 ) throw new IllegalArgumentException("Posisjon (" + posisjon + ") < 1");

        Node<T> p = rot, q = null;

        int filter = Integer.highestOneBit(posisjon) >> 1;


        while(p != null && filter > 0){
            q = p;
            p = (posisjon & filter) == 0 ? p.venstre : p.hoyre;
            filter >>= 1;
        }

        if(filter > 0) throw new IllegalArgumentException("Posisjon (" + posisjon + ") mangler forelder");
        else if(p != null) throw new IllegalArgumentException("Posisjon(" + posisjon + ") finnes fra før");

        p = new Node<T>(verdi);

        if(q == null) rot = p;
        else if((posisjon & 1) == 0) q.venstre = p;
        else q.hoyre = p;

        antall++;
    }

    private Node<T> finnNode(int posisjon) {
        if (posisjon < 1) return null;

        Node<T> p = rot;
        int filter = Integer.highestOneBit(posisjon) >> 1;

        for(; p != null && filter > 0; filter >>= 1){
            p = (posisjon & filter) == 0? p.venstre : p.hoyre;

        }
        return p;
    }

    public boolean finnes(int posisjon)
    {
        return finnNode(posisjon) != null;
    }

    public T hent(int posisjon)
    {
        Node<T> p = finnNode(posisjon);

        if (p == null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        return p.verdi;
    }

    public T oppdater(int posisjon, T nyverdi)
    {
        Node<T> p = finnNode(posisjon);

        if (p == null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes ikke i treet!");

        T gammelverdi = p.verdi;
        p.verdi = nyverdi;

        return gammelverdi;
    }


    public void nivåorden(Oppgave<? super T> oppgave)    // ny versjon
    {
        if (tom()) return;                   // tomt tre
        Kø<Node<T>> kø = new TabellKø<>();   // Se Avsnitt 4.2.3
        kø.leggInn(rot);                     // legger inn roten

        while (!kø.tom())                    // så lenge køen ikke er tom
        {
            Node<T> p = kø.taUt();             // tar ut fra køen
            oppgave.utforOppgave(p.verdi);     // den generiske oppgaven

            if (p.venstre != null) kø.leggInn(p.venstre);
            if (p.hoyre != null) kø.leggInn(p.hoyre);
        }
    }

    public int[] nivaer() {
        // Tom tabell for et tomt tre
        if(tom()) return new int[0];

        int[] a = new int[8];

        // hjelpekø
        Kø<Node<T>> kø = new TabellKø<>();
        int nivå = 0;

        kø.leggInn(rot);

        while(!kø.tom()){

            // utvider hvis det er nødvendig
            if(nivå == a.length) a = Arrays.copyOf(a, 2 * nivå);

            int k = a[nivå] = kø.antall(); // antall på dette nivået

            for(int  i = 0; i < k; i++){
                Node<T> p = kø.taUt();

                if(p.venstre != null) kø.leggInn(p.venstre);
                if(p.hoyre != null) kø.leggInn(p.hoyre);
            }
            nivå++;
        }
        return  Arrays.copyOf(a, nivå);
    }

    private static <T> void preorden(Node<T> p, Oppgave<? super T> oppgave){
        oppgave.utforOppgave(p.verdi);

        if(p.venstre != null) preorden(p.venstre, oppgave);
        if(p.hoyre != null) preorden(p.hoyre, oppgave);
    }

    public void preorden(Oppgave<T> oppgave){
        if(!tom()) preorden(rot, oppgave);
    }


    private static <T> void inorden(Node<T> p, Oppgave<? super T> oppgave) {

        if(p.venstre != null) inorden(p.venstre, oppgave);
        oppgave.utforOppgave(p.verdi);
        if(p.hoyre != null) inorden(p.hoyre, oppgave);
    }

    public void inorden(Oppgave<? super T> oppgave) {
        if(!tom()) inorden(rot, oppgave);
    }

    public T førstInorden()
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;
        while (p.venstre != null) p = p.venstre;

        return p.verdi;
    }

    public T førstPostorden()
    {
        if (tom()) throw new NoSuchElementException("Treet er tomt!");

        Node<T> p = rot;
        while (true)
        {
            if (p.venstre != null) p = p.venstre;
            else if (p.hoyre != null) p = p.hoyre;
            else return p.verdi;
        }
    }

    private static <T> void speilvend(Node<T> p)
    {
        if (p == null) return;   // tomt subtre

        Node<T> q = p.venstre; p.venstre = p.hoyre; p.hoyre = q;  // bytter

        speilvend(p.venstre); speilvend(p.hoyre);
    }

    public void speilvend()
    {
        if (antall() > 1) speilvend(rot);
    }

    public int antall(){return antall;}

    public boolean tom() {return antall == 0;}

    @Override
    public String toString()
    {
        StringJoiner s = new StringJoiner(", ", "[", "]");
        if (!tom()) inorden(x -> s.add(x != null ? x.toString() : "null"));
        return s.toString();
    }

} // class BinTre<T>


