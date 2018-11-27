package kopiokaannin;

public class Taulukot {
    // HUOM! Älä lisää luokalle Taulukot oliomuuttujia

    public int[] kopioi(int[] taulukko) {
        int[] kopio = new int[taulukko.length];
        for (int i = 0; i < taulukko.length; i++) {
            kopio[i] = taulukko[i];
        }
        return kopio;
    }
    
    public int[] kaanna(int[] taulukko) {
        int[] kaannos = new int[taulukko.length];
        for (int i = 0; i < taulukko.length; i++) {
            kaannos[kaannos.length - 1 - i] = taulukko[i];
        }
        return kaannos;
    }
}
