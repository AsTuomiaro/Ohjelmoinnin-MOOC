
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Scanner lukija = new Scanner(System.in);
        
        int summa = 0;
        while (true) {            
            System.out.print("Luku: ");
            String lukuMerkkijonona = lukija.nextLine();
            if (lukuMerkkijonona.isEmpty()) {
                break;
            }
            
            int luku = Integer.parseInt(lukuMerkkijonona);
            if (luku % 3 == 0) {
                summa += luku;
            }
        }
        
        if (summa == 0) {
            System.out.println("\nEi kolmella jaollisia lukuja");
        } else {
            System.out.println("\nKolmella jaollisten lukujen summa: " + summa);
        }
    }

}
