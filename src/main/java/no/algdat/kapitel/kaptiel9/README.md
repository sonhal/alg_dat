## Definisjon - Balansert Binærtre
Et binærtre er balansert hvis alle nivåene, muligens bortsett fra det siste (nederste),
har så mange noder som det er plass til.

## 2-3-4 Tre

Et 2-3-4 tre er ikke et binærtre. Det er et balansert tre der nodene kan ha flere enn to barn. I et binærtre kan en node ha ingen, ett eller to barn. Generelt gjelder at i et B-tre av orden m kan en node ha maksimalt m barn. En node kan der ha ingen barn (en bladnode), men aldri kun ett barn. I et B-tre av orden 4 kan dermed en indre node ha 2, 3 eller 4 barn. Derfor kalles det også et 2-3-4 tre. For et slikt tre gjelder:

 - En node kan ha én, to eller tre verdier. En node med én verdi kalles en 2-node, en med to verdier kalles en 3-node og en med tre verdier en 4-node.
 - En indre node kan ha to, tre eller fire barn.
 - Antallet verdier i en indre node er alltid én mindre enn antallet barn som noden har.
 - Alle bladnoder ligger på samme nivå i treet.

Sorteringsrekkefølgen for verdiene i et 2-3-4 tre blir dermed slik:

 - Verdiene i hver node skal være sortert stigende.
 - Hvis x er en vilkårlig verdi i en indre node, skal største verdi i det venstre subtreet til x være mindre enn x, og x skal være mindre enn minste verdi i høyre subtreet til x.
 
 #### Innleggingsalgoritme (ovenifra og ned) for 2-3-4 trær

 - Hvis treet er tomt, opprettes en bladnode og verdien legges inn i den.
 - Finn den bladnoden som verdien sorteringsmessig hører til. Splitt alle 4-noder som passeres på veien ned dit (også bladnoden hvis den er en 4-node). En node splittes ved at midtverdien rykker opp til foreldernoden (på rett sortert plass) og ved at de to verdiene på hver siden inngår i sine egne noder. Hvis det er rotnoden som skal splittes, rykker midtverdien opp til en ny rotnode.
 - Hvis bladnoden har plass, legges verdien inn på rett sortert plass. Hvis den ble splittet (var en 4-node), legges verdien inn i den noden som den etter splittingen hører til.
 
 ##  rød-svart tre
 
 1. Det er et binært søketre der det normalt ikke er tillatt med like verdier.
 2. Nodene er enten røde eller svarte. Rotnoden er svart.
 3. Barna til en rød node er svarte.
 4. Pekere som i et vanlig tre peker til null, skal her isteden peke til en svart «nullnode».
 5. La p være en vilkårlig node. Da er antall svarte noder på veien mellom p og en nullnode i subtreet med p som rot, det samme for alle slike nullnoder.
 
 
 Innleggingsalgoritmen:

 1. Treets første verdi legges i en svart rotnode.
 2. Generelt legges en ny verdi i en rød node på rett sortert plass i treet. La den hete X.
 3. Hvis forelder F til X er svart, stopper vi. Hvis F er rød, må F ha en svart forelder B (besteforelder til X) og X en tante T (søsken til forelder F).
 4. Hvis T er svart (en nullnode eller en vanlig node), er det fire mulige tilfeller. Avhengig av hviklet tilfelle det er (se huskereglene over) må det utføres en enkel eller en dobbel rotasjon (høyre eller venstre) og deretter et fargeskifte (F til svart og B til rød). Dermed er innleggingen ferdig.
 5. Hvis T er rød, må det utføres et fargeskifte (F og T til svart og B til rød). Hvis B er roten, settes den tilbake til svart og vi kan stoppe. Hvis ikke, omdøper vi B til X og går tilbake til pkt. 3.
