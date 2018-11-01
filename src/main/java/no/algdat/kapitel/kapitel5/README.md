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


#### Preorden, inorden og postorden

Dybde først traverseringer
 - preorden (eng: preorder)
 - inorden (eng: inorder)
 - postorden (eng: postorder)

Hver av de tre typene traversering kan defineres ved hjelp av en enkel geometrisk regel. Se på flg. eksempel:
![Figur 5.1.7 a)](https://www.cs.hioa.no/~ulfu/appolonius/kap5/1/images/517a.png)
<i>Figur 5.1.7 a) : Et binærtre med konturkurve</i>

Figur 5.1.7 a) over viser det samme treet som i Figur 5.1.6 a). Det er bare tegnet litt bredere.
I tillegg er det tegnet en stiplet strek eller kurve som starter rett opp til venstre for rotnoden. Videre bukter
 den seg rundt nodene, går inn mellom forgreningene og ender rett opp til høyre for rotnoden. Vi kaller det treets
  kontur eller konturkurve. Pilene gir kurven en retning. I tillegg har venstre side, undersiden og høyre side av hver
   node blitt markert med en farget «prikk» der fargene er gul (høyre side), blå (undersiden) og grønn (høyre side).
   
Hvis vi starter ved rotnoden, følger konturkurven og skriver ut nodeverdiene ved passering av en farget «prikk»,
 får vi flg. tre tilfeller:

 1. Skriver vi ut nodeverdien når den gule «prikken» passeres, får vi verdiene i preorden. For treet i Figur 5.1.7 a)
  blir det E, I, G, A, L, O, M, C, B, H, D, K, N, J, F. Rotnoden kommer alltid først i preorden!

 2. Skriver vi ut nodeverdien når den blå «prikken» passeres, får vi verdiene i inorden og dermed
  G, I, L, A, M, O, C, E, H, D, B, J, N, F, K for treet i Figur 5.1.7 a). Noden nederst til venstre kommer alltid først i inorden! 

 3. Skriver vi ut nodeverdien når den grønne «prikken» passeres, får vi dem i postorden.
  Det blir da G, L, M, C, O, A, I, D, H, J, F, N, K, B, E. Rotnoden kommer alltid sist i postorden!
Begrepene pre-, in- og postorden er blitt definert på en uformell og geometrisk måte. Vi trenger en mer formell definisjon.
 For det første betyr ordet orden det samme som rekkefølge og de tre forstavelsene pre, in og post betyr foran, mellom og etter.


##### Preorden  Det er lettest å definere denne traverseringsrekkefølgen rekursivt:

 1. Vi starter i rotnoden.
 2. Videre gjelder for alle noder at først «besøker» vi noden, så dens venstre barn hvis den har et venstre barn
  og så dens høyre barn hvis den har et høyre barn.
 
##### Inorden  Dette definerer vi også rekursivt:
 
 1. Vi starter i rotnoden.
 2. Videre gjelder for alle noder at først «besøker» vi nodens venstre barn hvis den har et venstre barn,
  så noden og så dens høyre barn hvis den har et høyre barn

En enkel huskeregel for inorden er:   venstre, node, høyre

##### Postorden  En rekursiv definisjon:

 1. Vi starter i rotnoden.
 2. Videre gjelder for alle noder at først «besøker» vi nodens venstre barn hvis den har et venstre barn, så dens høyre
  barn hvis den har et høyre barn og så «besøker» vi noden.
  
Eksempel: Også her gir den rekursive definisjonen at verdiene i treet i Figur 5.1.7 a) vil komme i den rekkefølgen som
 ble annonsert ovenfor (i forbindelse med konturkurver): G, L, M, C, O, A, I, D, H, J, F, N, K, B, E.
 
En enkel huskeregel for postorden er:   venstre, høyre, node

##### Den neste
Hvis vi står på en node, kan det være aktuelt å finne den neste (eller den forrige) i preorden, inorden eller postorden.
 Men det kan by på problemer.
 
Anta at p er en node i binærtreet som ikke er null. Da gjelder flg. regel for den neste.
 
Preorden
 - Hvis p har et venstre barn, så er det barnet den neste
 - Hvis p ikke har et venstre barn, men et høyre barn, så er det barnet den neste.
 - Hvis p ikke har barn dvs. p er en bladnode, så må vi først til den nørmeste (oppover i noden) noden q som har et
 høyre barn og somhar p i sitt venstre subtre. Den neste til p er da det høyre barnet til q.
 - Hvis det ikke finnes noen slik q, er p den siste i preorden.
 
 Inorden
  - Hvis p har et ikke-tomt høyre subtre, så er den neste den noden spm kommer først inorden i det subtreet.
  - Hvis p har et tomt høyre subtre, så den neste den nærmeste noden oppover mot roten som har p i sitt venstre subtre.
  - Hvis det ikke finnes noen slik node, er p den siste noden inorden.
  
Postorden:

 - Hvis p ikke har en forelder ( p er rotnoden), så er p den siste i postorden.
 - Hvis p er høyre barn til sin forelder f, er forelderen f den neste.
 - Hvis p er venstre barn til sin forelder f, gjelder:
 - Hvis p er enebarn (f.høyre er null), er forelderen f den neste.
 - Hvis p ikke er enebarn (dvs. f.høyre er ikke null), så er den neste den noden som kommer først i postorden i subtreet
 med f.høyre som rot.
 
 
##### Speilvendt og omvendt orden
Et binærtre speilvendes ved å rotere det om en vertikal linje gjennom roten, dvs. venstre og høyre barn bytter plass i
alle noder. Tærerne i figuren under er speilvendte av hverandre

![Figur 5.1.8 a)](https://www.cs.hioa.no/~ulfu/appolonius/kap5/1/images/518a.png)
