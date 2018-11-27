
import java.util.Scanner;

public class TulostusKolmesti {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Mikä tulostetaan? ");
        String tulos = lukija.nextLine();
        System.out.println(tulos + tulos + tulos);

    }
}
