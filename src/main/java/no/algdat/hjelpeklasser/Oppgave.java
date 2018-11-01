package no.algdat.hjelpeklasser;

@FunctionalInterface
public interface Oppgave<T>  // legges under hjelpeklasser
{
    void utforOppgave(T t);    // f.eks. utskrift til konsollet

    public static <T> Oppgave<T> konsollutskrift(){
        return t -> System.out.print(t + " ");
    }

    default Oppgave<T> deretter(Oppgave<? super T> oppgave){
        return t-> {utforOppgave(t); oppgave.utforOppgave(t);};
    }
}