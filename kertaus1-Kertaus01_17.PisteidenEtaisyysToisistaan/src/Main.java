
public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Piste a = new Piste(0, 0);
        Piste b = new Piste(1, 0);
        Piste c = new Piste(0, 1);
        
        System.out.println("Pisteiden" + a + " ja " + b + "etäisyys: " + a.etaisyys(b));
        System.out.println("Pisteiden" + a + " ja " + c + "etäisyys: " + a.etaisyys(c));
        System.out.println("Pisteiden" + b + " ja " + c + "etäisyys: " + b.etaisyys(c));
    }

}
