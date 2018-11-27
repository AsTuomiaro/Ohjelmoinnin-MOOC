
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Scanner lukija = new Scanner(System.in);
        Morsettaja morsettaja = new Morsettaja();
        
        System.out.print("Sana: ");
        String syote = lukija.nextLine();
        syote = syote.toLowerCase();
        String[] sanat = syote.split(" ");
        
        for (String sana : sanat) {
            morsettaja.kaanna(sana);
            System.out.println("");
        }
    }

}
