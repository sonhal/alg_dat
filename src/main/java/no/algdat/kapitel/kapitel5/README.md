# Binære trær


# Binære søketrær

1. Søk i usortert liste => tregt
2. Søk i sortert liste => raskere

### Sortert liste til binært søketre

[bilde]()

lagres som array
perfekte og komplette trør

#### Definisjon
Et binær tre består av en samling noder (node/nodes) (muligens en tom samling) og en samling kanter (edge/edges) som
forbinder par av noder

 - Hvis treet ikke er tomt, har det en rotnode, Kalles også treets root (root)
 - Til enhver node Y unntatt rotnoden, hører det nøyaktig en node X som vi kaller dens foreldernode eller bare forelder
  (parent). Det går en kant mellom noden Y og dens forelder X. Omvendt sier vi at Y er et barn (children) til X. En node
  kan ga to, et eller ingen barn. Det er kun mellom nodepar av typen barn/forelder det går kanter.
 - Hvis en node har to barn er det ene venstre barn og det andre høyre barn. Hvis noden har bare ett barn defineres det
   enten som venstre barn eller som høyre barn.
   

#### Nivå
Rot noden er på nivå 0, barna til rot noden er på nivå 1, barnebarna på nivå 2 osv.
Begrepet generasjon henter vi fra slektstrær. generasjon k vil være det samme som nivå k - 1.

#### Tilstand
Hvis alle nivåene i treet har så mange noder som det er plass til så sier vi at treet er perfekt (perfect binary tree).


#### Subtrær
Enhver node kan ses på som rotnode i sitt eget tre. En node har alltid to subtrær, et venstre og et høyre, der et eller
begge kan være tomme. 

#### Bladnoder og indre noder
Noder kan deles opp i to typer - bladnoder og indre noder (leaf node and inner node). En bladnode (eller blad) er en node
som ikke har barn. Alle andre er inder noder.

#### En vei
Vi kan orientere alle kantene i treet ved å si at en kants retning er fra fordelder til barn, dvs nedover. Vi sier at
det går en vei (path) mellom to noder X og Y hvis det er mulig å komme fra X til Y ved å følge kanter.
Spesielt får vi at Y er en etterkommer av X hvis det går en vei fra X til Y, eller omvendt at X er en forgjenger til Y.
Veilengden er antallet kanter på veien.

#### Avstand
Hvis det går en vei fra noden X til noden Y (eller fra Y til X) sier vi at avstanden mellom dem er lik veilengden. Hvis
det ikke går en vei mellom dem, må de ha en nærmeste felles forgjenger Z. Da sier vi at avstanden mellom X og Y er lik
avstanden mellom Z og X, pluss avstanden mellom Z og Y.

#### Høyden
Høyden til et binærtre er lengden på den lengste veien i treet. Den lengste veien må nødvendigvis starte i rotnoden.
Høyden er det samme som det største nivået i treet.
Binærtre med bare en node har høyde 0 og et tomt tre har høyde - 1.

Høyden til en node X er høyden til det subtreet som har X som rotnode. Rotnodens høyde er dermed det samme som høyden til
hele treet.


#### Dybden
Dybden til en node X er avstanden mellom rotnoden og noden X.

#### Retningen
Nedover er retning vekk fra rot noden, opper er mot rotnoden.

#### En gren
En gren av treet består av alle nodene fra rotnoden og ned til en bladnode.
Venstre gren er den som ender i bladnoden helt til venstre og høyre gren er den som ender i den bladnoden som ligger
lengst til høyre.

En node ligger til venstre for en annen node hvis den kommer foran den andre i inorden. Høyden på treet blir det samme
som lengden på lengste gren.

#### Inorden
Dette definerer vi rekursivt

 1. Vi starter i rot noden.
 2. Videre gjelder for alle noder at først "besøker" vi nodens ventre barn hvis den har et venstre barn, så noden og så
 dens høyre barn hvis den har et høyre barn.
 
 En enkel huske regel for inorden er: venstre, node, høyre
 
#### Form og innhold
To binæretrær sies å være like om de har samme for om innhold.

To binære trær som har samme form kalles isomorfe


#### Nodenes posisjoner
Hvis en node har posisjon k, så har de to barna posisjonene 2k (venstre) og 2k + 1 (høyre). Dette gjelder fra og med 
rot noden(posisjon 1). Ta f.eks noden med posisjon 5. De to barna har posisjonen 2\*5 = 10 og 2\*5 +1 = 11.

Det er en tilsvarende regel som gjelder motsatt vei: Hvis en node har posisjon k (k != 1), så er ⌊k/2⌋ posisjonen til
foreldernoden. Ta f.eks noden med posisjon 5. Det gir oss posisjon ⌊5/2⌋ = 2 for forelderen.
Obs: vi kan skrive k/2 hvis vi tolker divisjonen som helltallsdivisjon.

Konklusjon Vi kan bruke flg. regel for å bestemme nodeposisjoner: Rotnoden har posisjon 1. Deretter brukes
«barnereglen»: Barna til en node med posisjon k har henholdsvis 2 k (venstre) og 2 k + 1 (høyre) som posisjonstall.


#### Node posisjon og binære tall
Binære tall henger sammmen med binære trær. Treet i figuren har ikke posisjons tall men binære siffer på kantene (edges) 
0 på være venstre kant og 1 på hver høyrekant. Noden med posisjon 22 er markert med X. Hvis vi starter med et 1-tall
(et 1-tall for rotnoden) og så går nedover ved å følge kantene fra rotnoden ned til X noden, får vi følgende binære
sekvens: 10110. Denne sekvensen er nettop tallet 22 på binær form.

![binary tree image](https://www.cs.hioa.no/~ulfu/appolonius/kap5/1/images/514a.png)

Noden med posisjon 29 er markert med en Y. Binær formen til 29 er 11101 og det får vi (bortsett fra den første 1-eren)
ved å følge kantene nedover fra rotnoden og ned til y-noden.

 - Hver node i et binærtre har en entydig posisjon (eller et posisjonstall) og det er nodens plassering i treet som bestemmer dette tallet.
 - Rotnoden har alltid posisjon 1.
 - Hvis k, k > 1, er posisjonen til en node, så er ⌊k/2⌋ posisjonen til nodens forelder.
 - Hvis en node med posisjon k har et venstre barn, så er ventrebarnets posisjon lik 2k.
 - Hvis en node med posisjon k har et høyre barn, så er høyrebarnets posisjon lik 2k + 1.
 - Hvis k, k > 1, er en posisjon i binærtreet, så gir de binære sifrene til k oss veien fra rotnoden ned til denne
  posisjonen. Vi hopper over det ledende 1-tallet. Deretter går vi til venstre når det er 0 og til høyre når det er 1.
 - Høyden i et tre er én mindre enn antallet binære siffer i treets største posisjonstall.
 

#### Traversering - nivåorden
Besøke alle nodene etter tur og da vanligvis i en bestemt rekkefølge. Dette kalles å traversere treet (eng: traverse).

To hovedtyper av traversering
 - bredde først (breadth-first)
 - dybde først (depth-first)
 
Rekkefølgen nivåorden er av typen "bredde først" og preoder, inorden og postorden er av typen "dybde først".
Det kalles "nivåorden" når nodene "besøkes" nivå for nivå, fra rotnoden og nedover, og for vørt nivå fra venstre mot
høyre. 

 I Figur 5.1.6 a) til venstre vil en oppramsing av nodeverdiene i nivåorden gi oss denne rekkefølgen:
  E, I, B, G, A, H, K, L, O, D, N, M, C, J og F. Dette blir en «bredde først»-traversering.
![Figur 6.1.6 a](https://www.cs.hioa.no/~ulfu/appolonius/kap5/1/images/516a.png)

Traversering av typen "bredde først" utføres ved hjelp av en kø. I "dybde først" brukes enten rekursjon eller en stakk.
Metoden nivåorden(), som skal ligge i BinTre-klassen benytter en kø. Den skriver ut verdiene i nivåporden og med en
verdi for hver interasjon. Det betyr at den er av orden n der n er antall noder. Obs det er instanser av Node<T> som
legges i køen.


 