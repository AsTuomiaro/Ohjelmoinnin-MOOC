
import java.util.Scanner;

public class KolmenLuvunSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int summa = 0;
        
        System.out.print("Anna ensimmäinen luku: ");
        summa += Integer.parseInt(lukija.nextLine());

        System.out.print("Anna toinen luku: ");
        summa += Integer.parseInt(lukija.nextLine());

        System.out.print("Anna kolmas luku: ");
        summa += Integer.parseInt(lukija.nextLine());

        System.out.println("");
        System.out.println("Summa: " + summa);
    }
}
