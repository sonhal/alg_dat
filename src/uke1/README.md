

# Algoritmer og Datastrukturer

| studentNr  | Navn |
| ------------- | ------------- |
| s30549  | Sondre Halvorsen  |


## Uke oppgave 1

Oppgaver til Avsnitt 1.1.4
1.	Hvor mange grunnleggende operasjoner utfører Programkode 1.1.4 hvis tabellen a inneholder:
 - i) 10, 5, 7, 2, 9, 1, 3, 8, 4, 6 

A:

```
 public static int maks(int[] a)   // versjon 2 av maks-metoden
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
  
```