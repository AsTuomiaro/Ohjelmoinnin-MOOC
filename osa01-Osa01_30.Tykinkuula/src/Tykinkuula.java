
import java.util.Scanner;

public class Tykinkuula {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Syötä tykinkuulan lähtönopeus:");
        double nopeus = Double.parseDouble(lukija.nextLine());
        
        System.out.println("Syötä painovoima:");
        double painovoima = Double.parseDouble(lukija.nextLine());
        
        System.out.println("");
        
        int sekunnit = 0;
        double korkeus = 0;
        double maxKorkeus = 0;
        
        while (true) {            
            
            if (korkeus < 0) {
                break;
            }
            
            System.out.println(sekunnit + "\t" + korkeus + "\t" + nopeus);
            
            sekunnit++;
            korkeus += nopeus;
            nopeus -= painovoima;
            
            if (korkeus > maxKorkeus) {
                maxKorkeus = korkeus;
            }
        }
        
        System.out.println("\nTykinkuulan suurin korkeus oli " + maxKorkeus);
    }
}
