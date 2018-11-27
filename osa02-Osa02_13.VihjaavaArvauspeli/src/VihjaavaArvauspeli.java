
import java.util.Scanner;

public class VihjaavaArvauspeli {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        // kun olet palauttanut tehtävän ja saanut siitä pisteet,
        // kokeile myös seuraavaa: 
        // int arvattava = (int) (1 + Math.random() * 100);

        int arvattava = 42;

        System.out.println("Minäpä tiedän luvun väliltä 1-100, jota sinä et tiedä!");
        
        int arvauksienMaara = 0;
        while (true) {            
            System.out.print("Anna luku: ");
            int arvaus = Integer.parseInt(lukija.nextLine());
            if (arvaus == arvattava) {
                arvauksienMaara++;
                break;
            }
            if (arvaus >= 1 && arvaus < arvattava) {
                System.out.println("Lukuni on isompi!");
                arvauksienMaara++;
            } else if (arvaus <= 100 && arvaus > arvattava) {
                System.out.println("Lukuni on pienempi!");
                arvauksienMaara++;
            } else {
                System.out.println("Epäkelpo luku!");
            }
        }
        System.out.println("\nOikein! Arvauksia yhteensä: " + arvauksienMaara);
    }
}
