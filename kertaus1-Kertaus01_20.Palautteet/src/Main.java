
public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle
        Palauteanalyytikko pa = new Palauteanalyytikko();
        pa.add(new Palaute("Kiitti letuista", 2));
        pa.add(new Palaute("Kiitti letuista ja hillosta", 4));

        System.out.println(pa.palautteidenKeskiarvo());
        System.out.println();
        System.out.println(pa.palautteetValilta(3, 5));
        System.out.println();
        System.out.println(pa);
    }

}
