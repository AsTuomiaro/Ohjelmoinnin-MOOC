
import java.util.Scanner;

public class MarsinLampotilanKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        int lukujenMaara = 0;
        int summa = 0;
        while (true) {
            System.out.print("Syötä mittaus: ");
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == 9999) {
                break;
            }
            if (luku <= 20 && luku >= -140) {
                summa += luku;
                lukujenMaara++;
            }
        }
        if (lukujenMaara > 0) {
            System.out.println("\nMittausten keskiarvo: " + 
                        (1.0 * summa / lukujenMaara));
        } else {
            System.out.println("Ei mittaustuloksia.");
        }
    }
}
