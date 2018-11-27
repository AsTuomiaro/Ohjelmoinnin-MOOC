
import java.util.Scanner;

public class KahdenLuvunSummaaja {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän. Muista kysyä kaksi lukua käyttäjältä!
        int summa = 0;
        System.out.print("Anna ensimmäinen luku: ");
        summa += Integer.parseInt(lukija.nextLine());
        System.out.print("Anna toinen luku: ");
        summa += Integer.parseInt(lukija.nextLine());
        
        System.out.println("Lukujen summa on: " + summa);
    }
}
