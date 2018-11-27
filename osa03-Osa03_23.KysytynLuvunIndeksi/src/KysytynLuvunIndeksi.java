
import java.util.ArrayList;
import java.util.Scanner;

public class KysytynLuvunIndeksi {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        ArrayList<Integer> lista = new ArrayList<>();
        while (true) {
            int luettu = Integer.parseInt(lukija.nextLine());
            if (luettu == -1) {
                break;
            }

            lista.add(luettu);
        }

        System.out.println("");

        // toteuta tänne toiminnallisuus luvun etsimiseen
        System.out.print("Mitä etsitään? ");
        int etsitty = Integer.parseInt(lukija.nextLine());
        
        if (!lista.contains(etsitty)) {
            System.out.println("Lukua " + etsitty + " ei löydy.");
            return;
        }
        
        int i = 0;
        for (int luku : lista) {
            if (luku == etsitty) {
                System.out.println("Luku " + etsitty + " on indeksissä " 
                        + i);
            }
            i++;
        }
    }
}
