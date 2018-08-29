

# Algoritmer og Datastrukturer

| studentNr  | Navn |
| ------------- | ------------- |
| s305349  | Sondre Halvorsen  |


## Uke oppgave 1

Oppgaver til Avsnitt 1.1.4
1.	Hvor mange grunnleggende operasjoner utfører Programkode 1.1.4 hvis tabellen a inneholder:
 - i) 10, 5, 7, 2, 9, 1, 3, 8, 4, 6 

A:

```
 public static int maks(int[] a)   // versjon 2 av maks-metoden
  {
    int m = 0; (1)               // indeks til største verdi
    int maksverdi = a[0]; (2)    // største verdi

    for (int i = 1; i < a.length; i++) (1 + n + (n - 1))
    if (a[i] > maksverdi) 2(n - 1)
    {
      maksverdi = a[i]; 2(x)     // største verdi oppdateres
      m = i; (x)                // indeks til største verdi oppdateres
    }
    return m; (1)   // returnerer indeks/posisjonen til største verdi

  } // maks
  
```
 1 + 2 + 1 + n + n−1 + 2(n−1) + 3x + 1
