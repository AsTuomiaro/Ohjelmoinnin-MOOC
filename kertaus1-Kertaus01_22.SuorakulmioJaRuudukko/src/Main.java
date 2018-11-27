
public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Ruudukko r = new Ruudukko();
        r.lisaa(new Suorakulmio(0, 0, 2, 3));
        r.lisaa(new Suorakulmio(3, 2, 4, 2));
        r.lisaa(new Suorakulmio(5, 0, 1, 1));
        System.out.println(r);
    }

}
