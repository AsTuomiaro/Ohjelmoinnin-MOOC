
public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Ympyra s1 = new Ympyra(0, 0, 1);
        Ympyra s2 = new Ympyra(1, 1, 0.5);
        Ympyra s3 = new Ympyra(2, 0, 1);
        Ympyra s4 = new Ympyra(10, 10, 1);
        Ympyra s5 = new Ympyra(2 * Math.cos(Math.PI / 4), 2 * Math.sin(Math.PI / 4), 1);
        
        System.out.println("Ympyrä " + s1 + "ja " + s2 + " törmäävät: " + s1.osuuko(s2));
        System.out.println("Ympyrä " + s1 + "ja " + s3 + " törmäävät: " + s1.osuuko(s3));
        System.out.println("Ympyrä " + s1 + "ja " + s4 + " törmäävät: " + s1.osuuko(s4));
        System.out.println("Ympyrä " + s1 + "ja " + s5 + " törmäävät: " + s1.osuuko(s5));
    }

}
