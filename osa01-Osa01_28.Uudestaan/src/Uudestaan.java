
import java.util.Scanner;

public class Uudestaan {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        while (true) {            
            System.out.print("Syötä luku: ");
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == 4) {
                break;
            }
        }
    }
}
