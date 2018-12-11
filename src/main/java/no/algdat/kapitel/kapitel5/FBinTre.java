package no.algdat.kapitel.kapitel5;

import no.algdat.hjelpeklasser.Oppgave;

import java.util.Iterator;

public class FBinTre<T> implements Iterable<T>
{
    private static final class Node<T>
    {
        private T verdi;
        private Node<T> venstre, høyre, forelder;  // forelder

        private Node(T verdi, Node<T> v, Node<T> h, Node<T> f)
        {
            this.verdi = verdi;
            venstre = v; høyre = h; forelder = f;
        }

        private Node(T verdi, Node<T> f)
        {
            this(verdi,null,null,f);
        }
    } // class Node

    private Node<T> rot;        // peker til rotnoden
    private int antall;         // antall noder i treet

    public FBinTre()   // standardkonstruktør
    {
        rot = null; antall = 0;
    }

    public final void leggInn(int posisjon, T verdi)  // final: kan ikke overstyres
    {
        if (posisjon < 1) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") < 1!");

        Node<T> p = rot, q = null;    // nodereferanser

        int filter = Integer.highestOneBit(posisjon) >> 1;   // filter = 100...00

        while (p != null && filter > 0)
        {
            q = p;
            p = (posisjon & filter) == 0 ? p.venstre : p.høyre;
            filter >>= 1;  // bitforskyver filter
        }

        if (filter > 0) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") mangler forelder!");
        else if (p != null) throw new
                IllegalArgumentException("Posisjon (" + posisjon + ") finnes fra før!");

        p = new Node<>(verdi,q);  // q settes som forelder til p

        if (q == null) rot = p;         // tomt tre - ny rot
        else if ((posisjon & 1) == 0)   // sjekker siste siffer i posisjon
            q.venstre = p;                // venstre barn til q
        else
            q.høyre = p;                  // høyre barn til q

        antall++;                       // en ny verdi i treet
    }

    private static <T> Node<T> førsteInorden(Node<T> p)
    {
        while (p.venstre != null) p = p.venstre;
        return p;
    }

    private static <T> Node<T> nesteInorden(Node<T> p)
    {
        if (p.høyre != null)  // p har høyre barn
        {
            return førsteInorden(p.høyre);
        }
        else  // må gå oppover i treet
        {
            while (p.forelder != null && p.forelder.høyre == p)
            {
                p = p.forelder;
            }
            return p.forelder;
        }
    }

    public void inorden(Oppgave<? super T> oppgave)
    {
        if (rot == null) return;    // tomt tre

        Node<T> p = førsteInorden(rot);  // den aller første i inorden

        while (p != null)
        {
            oppgave.utforOppgave(p.verdi);
            p = nesteInorden(p);
        }
    }

    public int antall()
    {
        return antall;
    }

    public boolean tom()
    {
        return antall == 0;
    }

    public Iterator<T> iterator()
    {
        return null;  // kodes senere
    }

} // class FBinTre
