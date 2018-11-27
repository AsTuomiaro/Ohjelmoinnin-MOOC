
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Scanner lukija = new Scanner(System.in);
        System.out.print("Luku: ");
        int luku = Integer.parseInt(lukija.nextLine());
        
        while (luku % 5 != 0) {            
            luku++;
        }
        System.out.println("Pyöristys: " + luku);
    }

}
