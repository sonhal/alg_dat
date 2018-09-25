package no.algdat.hjelpeklasser;

import java.util.Iterator;

public abstract class AbstraktListe<T> extends AbstraktBeholder<T> implements Liste<T> {
    @Override
    public boolean leggInn(T t) {
        leggInn(antall(), t);
        return true;
    }

    @Override
    public abstract void leggInn(int indeks, T verdi);

    @Override
    public T hent(int indeks) {
        indeksKontroll(indeks);

        Iterator<T> iterator = iterator();
        int i = 0;
        while (iterator.hasNext()){
            if(i == indeks) break;
            iterator.next();
            i++;
        }
        return iterator.next();
    }

    @Override
    public int indeksTil(T verdi) {
        Iterator<T> iterator = iterator();
        int  i = 0;
        while (iterator.hasNext()){
            if(verdi.equals(iterator.next())) return i;
            i++;
        }
        return -1;
    }

    @Override
    public T oppdater(int indeks, T verdi) {
        indeksKontroll(indeks);
        T tmp = fjern(indeks);
        leggInn(indeks, verdi);
        return tmp;
    }

    @Override
    public T fjern(int indeks) {
        indeksKontroll(indeks);

        Iterator<T> i = iterator();

        for (int k = 0; k < indeks; k++) i.next();

        T temp = i.next();
        i.remove();

        return temp;
    }

    protected void indeksKontroll(int indeks){
        if(indeks < 0 || indeks > antall()) throw new IndexOutOfBoundsException("indeks er større en lovlig verdi");
    }
}
