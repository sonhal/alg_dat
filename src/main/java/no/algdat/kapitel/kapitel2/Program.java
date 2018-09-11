
import java.util.Arrays;

class Program {
    
    
    public static void main(String[] args){
        //int[] testArray = {1,4,3,8,7,2,34,35};
        //System.out.println(usortertsøk(testArray, 34));
        
        int[] a = {3,8,10,12,14,16,21,24,27,30,32,33,34,37,40};  // Figur 1.3.5 a)
        System.out.println(lineærsøk(a,32));              // utskrift: 10
        System.out.println(lineærsøk(a,31));              // utskrift: -11
        System.out.println(binærsøk2(a, 0, a.length, 41));
        parter0(a,0,a.length -1, 22);
        System.out.println(Arrays.toString(a));

    }
    
        public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    
    public static int usortertsøk(int[] a, int verdi)  // tabell og søkeverdi
    {
        for (int i = 0; i < a.length; i++)  // går gjennom tabellen
          if (verdi == a[i]) return i;      // verdi funnet - har indeks i
    
        return -1;                          // verdi ikke funnet
    }
    
    public static int lineærsøk(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
          return -(a.length + 1);  // verdi er større enn den største
    
        int i = 0; for( ; a[i] < verdi; i++);  // siste verdi er vaktpost
    
        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }
    
    public static int binærsøk(int[] a, int fra, int til, int verdi){
        
        int v = fra;
        int h = til - 1;
        int m;
        
        while(v < h){
            m = (v+h) / 2;
            
 
            if(verdi > a[m]){
                v = (m + 1);
            }
            else{
                h = m;
            }
        }
        if(h < v || verdi < a[v]) return -(v + 1);
        else if(a[v] == verdi) return v;
        else return -(v + 2); 
    }
    
      public static int binærsøk2(int[] a, int fra, int til, int verdi)
  {
    int v = fra, h = til - 1;  // v og h er intervallets endepunkter

    while (v < h)  // obs. må ha v < h her og ikke v <= h
    {
      int m = (v + h)/2;  // heltallsdivisjon - finner midten

      if (verdi > a[m]) v = m + 1;   // verdi må ligge i a[m+1:h]
      else  h = m;                   // verdi må ligge i a[v:m]
    }
    if (h < v || verdi < a[v]) return -(v + 1);  // ikke funnet
    else if (verdi == a[v]) return v;            // funnet
    else  return -(v + 2);                       // ikke funnet
  }
    
    public static int binærsøk(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk(a,0,a.length,verdi);  // bruker metoden over
    }
    
    public static int parter0(int[] a, int v, int h, int skilleverdi){
        while(true){
            while(v <= h && a[v] < skilleverdi) v++;
            while(h >= v && a[h] > skilleverdi) v--;
            
      if (v < h) bytt(a,v++,h--);                 // bytter om a[v] og a[h]
      else  return v;  // a[v] er nåden første som ikke er mindre enn skilleverdi
        }
    }

}