
import java.util.ArrayList;
import java.util.Scanner;

public class PienimmanLuvunIndeksi {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();

        // toteuta tänne ohjelma, joka lukee käyttäjältä lukuja
        // kunnes käyttäjä syöttää luvun 9999
        
        // tämän jälkeen ohjelma tulostaa pienimmän luvun
        // sekä sen indeksin -- pienin luku voi esiintyä
        // useammassa indeksissä
        
        while (true) {            
            int luettu = Integer.parseInt(lukija.nextLine());
            if (luettu == 9999) {
                break;
            }
            lista.add(luettu);
        }
        System.out.println("");
        
        int pienin = lista.get(0);
        for (int luku : lista) {
            if (luku < pienin) {
                pienin = luku;
            }
        }
        System.out.println("Pienin luku on " + pienin);
        
        int i = 0;
        for (int luku : lista) {
            if (luku == pienin) {
                System.out.println("Pienin luku löytyy indeksistä " + i);
            }
            i++;
        }
    }
}
