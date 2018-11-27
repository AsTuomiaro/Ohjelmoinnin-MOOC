
import java.util.Scanner;

public class Arvauspeli {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int arvattava = 7;

        System.out.println("Minäpä tiedän luvun väliltä 1-10, jota sinä et tiedä!");
        
        int arvaustenMaara = 0;
        
        System.out.println("");
        while (true) {   
            System.out.print("Arvaa luku: ");
            int arvaus = Integer.parseInt(lukija.nextLine());
            if (arvaus == 7) {
                arvaustenMaara++;
                break;
            }
            if (arvaus >= 1 && arvaus <= 10) {
                System.out.println("Ei ollut!");
                arvaustenMaara++;
            } else {
                System.out.println("Epäkelpo luku!");
            }
        }
        System.out.println("\nOikein! Arvauksia yhteensä: " + arvaustenMaara);
    }
}
