
import java.util.Scanner;

public class KelvollistenLukujenSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int summa = 0;
        while (true) {
            System.out.print("Syötä luku: ");
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == 9999) {
                break;
            }
            if (luku <= 20 && luku >= -140) {
                summa += luku;
            } else {
                System.out.println("Kelvoton luku");
            }
        }
        System.out.println("\nKelvollisten lukujen summa: " + summa);
    }
}
