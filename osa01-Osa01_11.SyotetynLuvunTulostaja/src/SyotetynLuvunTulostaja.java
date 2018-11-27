
import java.util.Scanner;

public class SyotetynLuvunTulostaja {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta ohjelmasi tähän.
        System.out.print("Anna luku: ");
        int luku = Integer.parseInt(lukija.nextLine());
        System.out.println("");
        System.out.println("Syötit: " + luku);
    }
}
