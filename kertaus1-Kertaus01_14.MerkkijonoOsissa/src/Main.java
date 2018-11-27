
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Scanner lukija = new Scanner(System.in);
        System.out.print("Merkkijono: ");
        String merkkijono = lukija.nextLine();
        
        for (int i = 0; i < merkkijono.length(); i++) {
            System.out.println(merkkijono.charAt(i));
        }
    }

}
