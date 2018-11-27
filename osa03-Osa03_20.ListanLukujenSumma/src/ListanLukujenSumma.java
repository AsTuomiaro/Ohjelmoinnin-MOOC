
import java.util.ArrayList;
import java.util.Scanner;

public class ListanLukujenSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // älä koske tässä olevaan koodiin
        ArrayList<Integer> lista = new ArrayList<>();
        while (true) {
            int luettu = Integer.parseInt(lukija.nextLine());
            if (luettu == -1) {
                break;
            }

            lista.add(luettu);
        }
        
        System.out.println("");

        // toteuta listan lukujen summan laskeminen tänne
        int summa = 0;
        for (int luku : lista) {
            summa += luku;
        }
        System.out.println("Summa: " + summa);
    }
}
