package tulostus;


public class TaulukonTulostaja {

    public void tulostaTyylikkaasti(int[] taulukko) {
        // Kirjoita koodia tänne
        for (int i = 0; i < taulukko.length; i++) {
            System.out.print(taulukko[i]);
            if (i < taulukko.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("");
    }
}
