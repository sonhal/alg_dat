package no.algdat.uke.uke1;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;

public class Program {
    /**
     * Oppgaver 1.1.6
     */

    public static void main(String[] args){
        // main-metoden i class Program skal nå inneholde:
        int n = 100_000, antall = 2_000; // tabellstørrelse og gjentagelser
        long tid = 0;                    // for tidsmåling
        int a[] = randPerm_4(n);           // en permutasjon av 1, . .  n

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) kostnader(a);
        tid = System.currentTimeMillis() - tid;    // medgått tid
        System.out.println("Faste kostnader: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks(a);  // Programkode 1.1.2
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks1-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks2(a);  // Programkode 1.1.4
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks2-metoden: " + tid + " millisek");

        tid = System.currentTimeMillis();    // leser av klokken
        for (int i = 0; i < antall; i++) maks3(a);  // Programkode 1.1.5
        tid = System.currentTimeMillis() - tid;     // medgått tid
        System.out.println("Maks3-metoden: " + tid + " millisek");
    }

    public static double harmonisk(int n){

        double sum = 0.0;
        for(double i = 1; i <= n; i++){
            sum += (1.0 / i);
        }
        return  sum;
    }

    public static double euler(int n){
        double harmonicNum = harmonisk(n);
        double logarithmNum = Math.log(n);
        return harmonicNum - logarithmNum;
    }

    public static int maks(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til største verdi

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] > a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

    } // maks

    public static int maks2(int[] a)   // versjon 2 av maks-metoden
    {
        int m = 0;               // indeks til største verdi
        int maksverdi = a[0];    // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdateres
        }
        return m;   // returnerer indeks/posisjonen til største verdi

    } // maks

    public static int maks3(int[] a)  // versjon 3 av maks-metoden
    {
        int sist = a.length - 1;       // siste posisjon i tabellen
        int m = 0;                     // indeks til største verdi
        int maksverdi = a[0];          // største verdi
        int temp = a[sist];            // tar vare på siste verdi
        a[sist] = 0x7fffffff;          // legger tallet 2147483647 sist

        for (int i = 0; ; i++)         // i starter med 0
            if (a[i] >= maksverdi)       // denne blir sann til slutt
            {
                if (i == sist)             // sjekker om vi er ferdige
                {
                    a[sist] = temp;          // legger siste verdi tilbake
                    return temp >= maksverdi ? sist : m;   // er siste størst?
                }
                else
                {
                    maksverdi = a[i];        // maksverdi oppdateres
                    m = i;                   // m oppdateres
                }
            }
    } // maks

    public static int kostnader(int[] a)  // legges i class Program
    {
        int m = 0;
        for (int i = 1; i < a.length; i++) {}  // en tom blokk
        return m;
    }

    public static void makstest()
    {
        int[] a = {8,3,5,7,9,6,10,2,1,4};  // maksverdien 10 er i posisjon 6

        if (maks(a) != 6)  // kaller maks-metoden
            System.out.println("Kodefeil: Gir feil posisjon for maksverdien!");

        a = new int[0];  // en tom tabell, lengde lik 0
        boolean unntak = false;

        try
        {
            maks(a);  // kaller maks-metoden
        }
        catch (Exception e)
        {
            unntak = true;
            if (!(e instanceof java.util.NoSuchElementException))
                System.out.println("Kodefeil: Feil unntak for en tom tabell!");
        }

        if (!unntak)
            System.out.println("Kodefeil: Mangler unntak for en tom tabell!");
    }


    public static OptionalInt optionalMaks(int[] a)           // indeks til største verdi
    {
        if (a.length < 1) return OptionalInt.empty();   // en konstruksjonsmetode

        int m = 0, maksverdi = a[0];                    // startindeks og verdi

        for (int i = 1; i < a.length; i++)              // starter med i = 1
        {
            if (a[i] > maksverdi)
            {
                m = i; maksverdi = a[i];                    // oppdaterer
            }
        }

        return OptionalInt.of(m);                       // en konstruksjonsmetode
    }

    public static int[] randPerm_2(int n){
        Random r = new Random();
        int[] a = new int[n];

        for (int i = 0; i < n;){
            int k = r.nextInt(n) + 1;   // trekker et nytt tall k

            int j = 0;
            for ( ; j < i; j++)         // leter i intervallet a[0:i>
            {
                if (a[j] == k) break;     // stopper hvis vi har k fra før
            }
            if (i == j) a[i++] = k;     // legger inn k og øker i
        }
        return a;
    }

    public static int[] randPerm_3(int n ){
        Random r = new Random();
        int[] a = new int[n];
        boolean[] har = new boolean[n];

        for(int i = 0; i < n; i++){
            int num = r.nextInt(n) + 1;
            if(har[num] == false){
                har[num] = true;
                a[i++] = num + 1;
            }
        }
        return a;
    }

    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static int[] randPerm_4(int n){
        Random r = new Random();
        int[] a = new int[n];

        Arrays.setAll(a, i -> i + 1);

        for( int i = n - 1; i > 0; i-- ){
            int k = r.nextInt(i+1);
            bytt(a, i, k);
        }
        return a;
    }

    public static void randPerm_4(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }

}
