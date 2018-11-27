
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Scanner lukija = new Scanner(System.in);
        System.out.print("Syötä vuosiluku: ");
        int vuosiluku = Integer.parseInt(lukija.nextLine());

        int i = 0;
        String karkausvuodet = "";
        while (i < 5) {

            while (true) {
                if (vuosiluku % 100 == 0 && vuosiluku % 400 == 0) {
                    break;
                } else if (vuosiluku % 4 == 0 && vuosiluku % 100 != 0) {
                    break;
                }
                vuosiluku++;
            }
            karkausvuodet += ", " + vuosiluku;
            vuosiluku++;
            i++;
        }
        karkausvuodet = karkausvuodet.substring(2);
        System.out.println("Karkausvuodet: " + karkausvuodet);
    }

}
