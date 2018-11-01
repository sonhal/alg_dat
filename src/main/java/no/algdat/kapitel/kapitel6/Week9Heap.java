package no.algdat.kapitel.kapitel6;

public class Week9Heap {



    public static void main(String[] args){

        char data[] = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

        int antall = data.length;

        int i = 1;
        int level = 0;
        while(i <= antall){

            int antall_node_level = (int)Math.pow(2,level);
            for(int j = 0; j < Math.min(antall_node_level, antall - i); j++){
                int indeks = i - 1 + j;
                System.out.println(data[indeks]);
            }
            i = i * 2;
            level++;

        }

    }
}
