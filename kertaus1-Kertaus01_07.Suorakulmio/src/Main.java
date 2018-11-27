
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Scanner lukija = new Scanner(System.in);
        System.out.print("Leveys: ");
        int leveys = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Korkeus: ");
        int korkeus = Integer.parseInt(lukija.nextLine());
        
        System.out.println("");
        
        int i = 0;
        while (i < korkeus) {            
            int j = 0;
            while (j < leveys) {                
                System.out.print("x");
                j++;
            }
            System.out.println("");
            i++;
        }
    }

}
