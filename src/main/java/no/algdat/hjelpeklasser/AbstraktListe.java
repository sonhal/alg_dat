package no.algdat.hjelpeklasser;

import java.util.Iterator;

public class AbstraktListe<T> extends AbstraktBeholder<T> implements Liste<T> {
    @Override
    public boolean leggInn(T t) {
        return false;
    }

    @Override
    public void leggInn(int indeks, T verdi) {

    }

    @Override
    public T hent(int indeks) {
        return null;
    }

    @Override
    public int indeksTil(T verdi) {
        return 0;
    }

    @Override
    public T oppdater(int indeks, T verdi) {
        return null;
    }

    @Override
    public T fjern(int indeks) {
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
