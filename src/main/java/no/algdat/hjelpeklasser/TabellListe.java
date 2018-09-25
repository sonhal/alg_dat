package no.algdat.hjelpeklasser;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TabellListe<T> extends AbstraktListe<T>{

    private T[] a;           // en tabell
    private int antall;      // antallet verdier

    @Override
    public void leggInn(int indeks, T verdi) {
        if (verdi == null) throw new
                IllegalArgumentException("Ulovlig å legge inn null-verdier!");

        if (indeks < 0 || indeks > antall) throw new
                IndexOutOfBoundsException("Indeks " + indeks + " er ulovlig!");

        // En full tabell utvides med 50%
        if (antall == a.length) a = Arrays.copyOf(a,(3*antall)/2 + 1);

        // rydder plass til den nye verdien
        for (int i = antall; i > indeks; i--) a[i] = a[i-1];
        a[indeks] = verdi;     // setter inn ny verdi

        antall++;
    }



    public TabellListe() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public TabellListe(int size) {
        a = (T[]) new Object[size];
        antall = 0;
    }

    public TabellListe(Iterable<T> itererbar)    // konstruktør
    {
        this(10);
        for (T verdi : itererbar) leggInn(verdi);     // kopierer
    }

    public TabellListe(T[] b)                    // en T-tabell som parameter
    {
        this(b.length);                            // kaller den andre konstruktøren

        for (T verdi : b)
        {
            if (verdi != null) a[antall++] = verdi;  // hopper over null-verdier
        }
    }

    @Override
    public T hent(int indeks)
    {
        indeksKontroll(indeks, false);   // false: indeks = antall er ulovlig
        return a[indeks];                // returnerer er tabellelement
    }

    @Override
    public boolean tom()
    {
        return antall == 0;     // listen er tom hvis antall er 0
    }

    @Override
    public int indeksTil(T verdi)
    {
        for (int i = 0; i < antall; i++)
        {
            if (a[i].equals(verdi)) return i;   // funnet!
        }
        return -1;   // ikke funnet!
    }

    @Override
    public boolean inneholder(T verdi)
    {
        return indeksTil(verdi) != -1;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new TabellListe<T>.EnkelTabellListeIterator();
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

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append(' ');

        if(antall > 0) stringBuilder.append(a[0]);
        for(int i = 1; i < antall; i++){
            stringBuilder.append(',');
            stringBuilder.append(' ');
            stringBuilder.append(a[i]);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    // Skal være en indre klasse i class TabellListe
    private class EnkelTabellListeIterator implements Iterator<T>
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
