
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Lukutilasto tilasto = new Lukutilasto();
        Lukutilasto parilliset = new Lukutilasto();
        Lukutilasto parittomat = new Lukutilasto();
        
        // voit tehdä testikoodia tänne
        // poista kaikki ylimääräinen koodi kuitenkin tehtävän viimeisiä osia tehdessäsi

        // Jotta testi toimisi, on oliot luotava pääohjelmassa oikeassa järjestyksessä 
        //  eli ensin kaikkien summan laskeva olio, toisena parillisten summan laskeva 
        //  ja viimeisenä parittomien summan laskeva olio)!
        
        System.out.println("Anna lukuja: ");

        while (true) {            
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == -1) {
                break;
            }
            tilasto.lisaaLuku(luku);
            if (luku % 2 == 0) {
                parilliset.lisaaLuku(luku);
            } else {
                parittomat.lisaaLuku(luku);
            }
        }

        System.out.println("Summa: " + tilasto.summa());
        System.out.println("Parillisten summa: " + parilliset.summa());
        System.out.println("Parittomien summa: " + parittomat.summa());
    }
}
