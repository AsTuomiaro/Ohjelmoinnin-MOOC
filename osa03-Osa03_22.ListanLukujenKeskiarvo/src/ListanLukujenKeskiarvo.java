
import java.util.ArrayList;
import java.util.Scanner;

public class ListanLukujenKeskiarvo {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        
        // toteuta tänne ohjelma, joka ensin lukee käyttäjältä
        // lukuja listalle kunnes käyttäjä syöttää luvun -1.
        // ohjelma laskee tämän jälkeen listalla olevien lukujen
        // keskiarvon, ja tulostaa sen käyttäjän näkyville
        
        while (true) {            
            int luettu = Integer.parseInt(lukija.nextLine());
            if (luettu == -1) {
                break;
            }
            lista.add(luettu);
        }
        System.out.println("");
        
        int summa = 0;
        for (int luku : lista) {
            summa += luku;
        }
        System.out.println("Keskiarvo: " + (1.0 * summa / lista.size()));
    }
}
