package no.algdat.hjelpeklasser;

import java.util.Iterator;

public abstract class AbstraktBeholder<T> implements Beholder<T>
{
    public abstract boolean leggInn(T t);    // en abstrakt metode

    public boolean inneholder(T t)
    {
        if (t == null)  // tillatt med null-verdier?
        {
            for (T s : this) if (s == null) return true;
        }
        else {
            for (T element : this) {
                if(t.equals(element))
                    return true;
            }
        }
        return false;
    }

    public boolean fjern(T t)
    {
        Iterator<T> i = iterator();

        if (t == null)               // fjerner en eventuell null-verdi
        {
            while (i.hasNext())        // flere igjen
            {
                if (i.next() == null)    // sammenligner
                {
                    i.remove();            // fjerner
                    return true;           // vellykket fjerning
                }
            }
        }
        else                         // t er ikke lik null
        {
            while (i.hasNext())        // flere igjen
            {
                if (t.equals(i.next()))  // sammneligner
                {
                    i.remove();            // fjerner
                    return true;           // vellykket fjerning
                }
            }
        }
        return false;                // mislykket fjerning
    }

    public int antall()
    {
        int antall = 0;
        for (T t : this) antall++;   // bruker en forAlle-løkke
        return antall;
    }

    public boolean tom()
    {
        return antall() == 0;   // ferdig kode
    }

    public void nullstill()
    {
        Iterator<T> i = iterator();
        while (i.hasNext()){
            i.next();
            i.remove();
        }
    }

    public abstract Iterator<T> iterator();    // en abstrakt metode

    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append(' ');

        Iterator<T> iterator = iterator();

        if(iterator.hasNext()) stringBuilder.append(iterator.next());

        while (iterator.hasNext()){
            stringBuilder.append(',');
            stringBuilder.append(' ');
            stringBuilder.append(iterator.next());
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}