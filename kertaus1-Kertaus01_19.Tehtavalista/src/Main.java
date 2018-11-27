
public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Tehtavalista tl = new Tehtavalista();
        tl.lisaa("Käy kaupassa");
        System.out.println(tl);
        tl.asetaTehdyksi("Käy kaupassa");
        System.out.println(tl);
        Tehtava t = tl.annaTehtava("Käy kaupassa");
        t.asetaTekemattomaksi();
        tl.lisaa("Imuroi");
        System.out.println(tl);
    }

}
