package no.algdat.hjelpeklasser;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TabellBeholder<T> extends AbstraktBeholder<T>
{
    private T[] a;           // en tabell
    private int antall;      // antallet verdier

    public TabellBeholder() {
        this(10);
    }

    public TabellBeholder(int size) {
        a = (T[]) new Object[size];
        antall = 0;
    }

    public TabellBeholder(Iterable<T> itererbar)    // konstruktør
    {
        for (T verdi : itererbar) leggInn(verdi);     // kopierer
    }

    @Override
    public boolean leggInn(T t) {
        // En full tabell utvides med 50%
        if (antall == a.length) a = Arrays.copyOf(a,(3*antall)/2 + 1);
        a[antall++] = t;
        return true;   // vellykket innlegging
    }

    @Override
    public Iterator<T> iterator()
    {
        return new TabellBeholderIterator();
    }

    @Override
    public int antall(){
        return antall;
    }

    @Override
    public void nullstill(){
        for(int i = 0; i < antall; i++){
            a[i] = null;
        }
        antall = 0;
    }

    // Skal være en indre klasse i class TabellBeholder
    private class TabellBeholderIterator implements Iterator<T>
    {
        private int denne = 0;       // instansvariabel
        private boolean removeOK = false;   // ny instansvariabel

        public boolean hasNext()     // sjekker om det er flere igjen
        {
            return denne < antall;     // sjekker verdien til denne
        }

        public T next()    // ny versjon
        {
            if (!hasNext())
                throw new NoSuchElementException("Tomt eller ingen verdier igjen!");

            T temp = a[denne];         // henter aktuell verdi
            denne++;                   // flytter indeksen
            removeOK = true;           // nå kan remove() kalles
            return temp;               // returnerer verdien
        }

        public void remove()
        {
            if (!removeOK) throw
                    new IllegalStateException("Ulovlig tilstand!");

            removeOK = false;          // remove() kan ikke kalles på nytt

            // verdien i posisjon denne - 1 skal fjernes siden den ble returnert
            // i det siste kallet på next(), verdiene fra og med denne flyttes
            // derfor en enhet mot venstre

            antall--;           // en verdi vil bli fjernet
            denne--;            // denne må flyttes til venstre

            for (int i = denne; i < antall; i++)
            {
                a[i] = a[i+1];    // verdiene flyttes
            }

            a[antall] = null;   // verdien som lå lengst til høyre nulles
        }

    }
}
