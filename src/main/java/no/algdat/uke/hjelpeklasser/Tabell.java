package no.algdat.uke.hjelpeklasser;
import java.util.*;

public class Tabell {

    private Tabell(){}

    public static void fratilKontroll(int lengde,int fra, int til){

        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > lengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + lengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
    }

    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }


    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void bytt(char[] a, int i, int j){
        char temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static void skriv(int[] a, int fra, int til){
        fratilKontroll(a.length, fra, til);
        if (til - fra > 0) System.out.print(a[fra]);
        for (int i = fra + 1; i < til; i++) System.out.print(" " + a[i]);
    }

    public static void skriv(int[] a){
        skriv(a,0, a.length);
    }

    public static void skrivln(int[] a, int fra, int til)
    {
        skriv(a,fra,til);
        System.out.println();
    }

    public static void skrivln(int[] a)
    {
        skrivln(a, 0, a.length);
    }

    public static void skriv(char[] a, int fra, int til)
    {
        fratilKontroll(a.length, fra, til);
        if (til - fra > 0) System.out.print(a[fra]);
        for (int i = fra + 1; i < til; i++) System.out.print(" " + a[i]);
    }

    public static void skriv(char[] a)
    {
        skriv(a, 0, a.length);
    }

    public static void skrivln(char[] a, int fra, int til)
    {
        skriv(a,fra,til);
        System.out.println();
    }

    public static void skrivln(char[] a)
    {
        skrivln(a, 0, a.length);
    }

    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }



    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

    public static int maks(int[] a, int fra, int til)
    {
        if (a == null) throw new NullPointerException
                ("parametertabellen a er null!");

        fratilKontroll(a.length, fra, til);


        if (fra == til) throw new NoSuchElementException
                ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }

    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }


    public static int min(int[] a, int fra, int til) {

        if (fra < 0 || til > a.length || fra >= til) {
            throw new IllegalArgumentException("Illegal intervall");
        }
        int m = fra;
        int minverdi = a[fra];
        for (int i = fra +1; i < til; i++){
            if(a[i] < minverdi){
                m = i;
                minverdi = a[m];
            }
        }
        return m;
    }

    public int min(int[] a){
        return min(a,0,a.length);
    }

    public static int[] naturligeTall(int n){
        return heleTall(0, n);
    }

    public static int[] heleTall(int fra, int til){
        int lengde = til - fra;
        fratilKontroll(lengde, fra, til);
        int[] a = new int[lengde];

        for (int i = 0; i < lengde; i++){
            a[i] = fra;
            fra++;
        }
        return a;
    }

    public static void snu(int[] a, int v, int h){
        vhKontroll(a.length, v, h);
        while (v < h) bytt(a, v++, h--);
    }

    public static void snu(int[] a){
        snu(a, 0, a.length -1);
    }

    public static void snu(char[] a, int v, int h)
    {
        vhKontroll(a.length,v,h);
        while (v < h) bytt(a,v++,h--);
    }

    public static void snu(char[] a)
    {
        int v = 0, h = a.length-1;
        while (v < h) bytt(a,v++,h--);
    }

    public static int[] nestMaks(int[] a)  // legges i class Tabell
    {
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi

        int nm;     // nm skal inneholde posisjonen til nest største verdi

        if (m == 0)                            // den største ligger først
        {
            nm = maks(a,1,n);                    // leter i a[1:n>
        }
        else if (m == n-1)                     // den største ligger bakerst
        {
            nm = maks(a,0,n-1);                  // leter i a[0:n-1>
        }
        else
        {
            int mv = maks(a,0,m);                // leter i a[0:m>
            int mh = maks(a,m+1,n);              // leter i a[m+1:n>
            nm = a[mh] > a[mv] ? mh : mv;        // hvem er størst?
        }

        return new int[] {m,nm};      // m i posisjon 0 , nm i posisjon 1

    } // nestMaks


    public static int[] nestMaks2(int[] a){
        int n = a.length;   // tabellens lengde

        if (n < 2) throw   // må ha minst to verdier!
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = maks(a);  // m er posisjonen til tabellens største verdi
        bytt(a,0 , m);

        int nm = maks(a,1,a.length);     // nm skal inneholde posisjonen til nest største verdi
        if (nm == m) nm = 0;

        bytt(a,0 , m);

        return new int[] {m,nm};
    }

    public static int[] nestMaks3(int[] a)
    {
        if (a.length < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + a.length + ") < 2!");

        int m = Tabell.maks(a);  // m er posisjonen til tabellens største verdi

        Tabell.bytt(a,a.length-1,m);  // bytter om slik at den største kommer bakerst

        int k = Tabell.maks(a,0,a.length-1);

        if (k == m) k = a.length - 1; // den nest største lå opprinnelig bakerst

        Tabell.bytt(a,a.length-1,m); // bytter tilbake

        return new int[] {m,k};

    } // nestMaks

    public static void sortering(int[] a){
        int lengde = a.length;

        for (int i = lengde; i > 1; i--){
            int maks = Tabell.maks(a,0, i );
            bytt(a, maks, i -1);
        }
    }

    public static int[] nestMaks4(int[] a) // ny versjon
    {
        int n = a.length;     // tabellens lengde
        if (n < 2) throw      // må ha minst to verdier
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = 0;      // m er posisjonen til største verdi
        int nm = 1;     // nm er posisjonen til nest største verdi

        // bytter om m og nm hvis a[1] er større enn a[0]
        if (a[1] > a[0]) { m = 1; nm = 0; }

        int maksverdi = a[m];                // største verdi
        int nestmaksverdi = a[nm];           // nest største verdi

        for (int i = 2; i < n; i++)
        {
            if (a[i] > nestmaksverdi)
            {
                if (a[i] > maksverdi)
                {
                    nm = m;
                    nestmaksverdi = maksverdi;     // ny nest størst

                    m = i;
                    maksverdi = a[m];              // ny størst
                }
                else
                {
                    nm = i;
                    nestmaksverdi = a[nm];         // ny nest størst
                }
            }
        } // for

        return new int[] {m,nm};    // n i posisjon 0, nm i posisjon 1

    } // nestMaks

}
