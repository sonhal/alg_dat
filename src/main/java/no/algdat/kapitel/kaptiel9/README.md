## Definisjon
Et binærtre er balansert hvis alle nivåene, muligens bortsett fra det siste (nederste),
har så mange noder som det er plass til.

## 2-3-4 Tre

Et 2-3-4 tre er ikke et binærtre. Det er et balansert tre der nodene kan ha flere enn to barn. I et binærtre kan en node ha ingen, ett eller to barn. Generelt gjelder at i et B-tre av orden m kan en node ha maksimalt m barn. En node kan der ha ingen barn (en bladnode), men aldri kun ett barn. I et B-tre av orden 4 kan dermed en indre node ha 2, 3 eller 4 barn. Derfor kalles det også et 2-3-4 tre. For et slikt tre gjelder:

 - En node kan ha én, to eller tre verdier. En node med én verdi kalles en 2-node, en med to verdier kalles en 3-node og en med tre verdier en 4-node.
 - En indre node kan ha to, tre eller fire barn.
 - Antallet verdier i en indre node er alltid én mindre enn antallet barn som noden har.
 - Alle bladnoder ligger på samme nivå i treet.
