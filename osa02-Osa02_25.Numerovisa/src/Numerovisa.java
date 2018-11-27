
import java.util.Random;
import java.util.Scanner;

public class Numerovisa {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        int arvottuLuku = arvoLuku();

        // ÄLÄ MUOKKAA YLLÄOLEVIA ASIOITA -- OHJELMOI OHJELMASI ALLE
        int arvaustenMaara = 0;
        while (true) {
            System.out.print("Arvaa luku: ");
            int luku = Integer.parseInt(lukija.nextLine());
            arvaustenMaara++;
            if (luku < arvottuLuku) {
                System.out.println("Luku on suurempi, tehtyjä arvauksia " + arvaustenMaara);
            } else if (luku > arvottuLuku) {
                System.out.println("Luku on pienempi, tehtyjä arvauksia " + arvaustenMaara);
            } else {
                break;
            }
        }
        System.out.println("Onneksi olkoon, oikein arvattu!");
    }

    // ÄLÄ MUOKKAA METODIA arvoLuku
    private static int arvoLuku() {
        return new Random().nextInt(101);
    }
}
