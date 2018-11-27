
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Scanner lukija = new Scanner(System.in);
        System.out.print("Montako lukua tulostetaan: ");
        
        int maara = Integer.parseInt(lukija.nextLine());
        int i = 0;
        
        int eka = 0;
        int toka = 1;
        int tulostettava = toka;
        
        while (i < maara) {
            
            System.out.print(tulostettava);
            
            i++;
            if (i < maara) {
                System.out.print(", ");
                toka = eka + toka;
                eka = tulostettava;
                tulostettava = toka;
            }
        }
        System.out.println("");
    }

}
