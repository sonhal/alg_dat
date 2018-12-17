




#### Observasjon 1.3.2  Antall inversjoner
I en permutasjon av tallene fra 1 til n kan det være ingen inversjoner. Da er den sortert stigende.<br> Det kan være maksimalt n(n − 1)/2 stykker. Da er den sortert avtagende. I gjennomsnitt er det n(n − 1)/4 inversjoner.



### Binary search - Binærsøk
Vi skal generelt søke etter en verdi i et lukket intervall a[v:h] der v står for venstre og h for høyre endepunkt. I tillegg har vi midten m = (v + h)/2. Vi kan tenke på én av to måter:

 - Verdien ligger enten på midten eller på en av sidene a[v:m–1] eller a[m+1:h]. Søkeområdet blir dermed delt i tre - ett element og to lukkede delintervaller.
 
 - Alternativt kan vi nøye oss med å dele søkeområdet i to deler. Dvs. vi avgjør om den søkte verdien ligger i a[v:m] eller i a[m+1:h].
 
#### Alternativ 1
Vi får flg. algoritme:

Start med tabellintervallet a[v:h] og søkeverdien verdi.
Finn midten m = (v + h)/2.
Hvis verdi == a[m] , er vi ferdige!
Hvis verdi > a[m] , settes v = m + 1 og hvis ikke, settes h = m – 1.
Hvis v <= h, gå til 2. Hvis v > h, er a[v:h] tom og verdi er ikke i tabellen.



### Shellsortering
Tabellen fortløpende deles opp i mindre og mindre grupper av verdier og de sorteres hver for seg ved hjelp av innsettingssortering. Det kalles shellsortering etter Donald Shell.




## 1.4  Generiske algoritmer

