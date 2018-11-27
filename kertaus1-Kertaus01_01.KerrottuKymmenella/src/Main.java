
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Luku: ");
        int luku = Integer.parseInt(lukija.nextLine());
        System.out.println("");
        
        int i = 0;
        while (i < 10) {            
            i++;
            System.out.println(i + " * " + luku + " = " + (i * luku));
        }
    }

}
