
import java.util.Scanner;

public class Jakaja {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän. Muista kysyä luvut käyttäjältä!
        System.out.print("Anna ensimmäinen luku: ");
        int eka = Integer.parseInt(lukija.nextLine());
        System.out.print("Anna toinen luku: ");
        int toka = Integer.parseInt(lukija.nextLine());
        
        double osamaara = 1.0 * eka /toka;
        System.out.println("");
        System.out.println("Jakolasku: " + eka + " / " + toka + " = " + osamaara);
    }
}
