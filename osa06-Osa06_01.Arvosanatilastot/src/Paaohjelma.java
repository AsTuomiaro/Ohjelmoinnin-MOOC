
import java.util.ArrayList;
import java.util.Scanner;

public class Paaohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Pistelaskuri laskuri = new Pistelaskuri();
        Pistelaskuri hyvaksytyt = new Pistelaskuri();
        Arvosanajakauma jakauma = new Arvosanajakauma();

        // Tee sovelluksesi tänne -- kannattaa harkita sovelluksen pilkkomista
        // useampaan luokkaan.
        System.out.println("Syötä yhteispisteet, -1 lopettaa:");
        while (true) {
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == -1) {
                break;
            }
            if (luku >= 0 && luku <= 100) {
                laskuri.lisaaPisteet(luku);
                if (luku >= 70) {
                    hyvaksytyt.lisaaPisteet(luku);
                }
                if (luku >= 91) {
                    jakauma.lisaaArvosana(5);
                } else if (luku >= 86) {
                    jakauma.lisaaArvosana(4);
                } else if (luku >= 81) {
                    jakauma.lisaaArvosana(3);
                } else if (luku >= 76) {
                    jakauma.lisaaArvosana(2);
                } else if (luku >= 70) {
                    jakauma.lisaaArvosana(1);
                } else {
                    jakauma.lisaaArvosana(0);
                }
            }
        }
        System.out.println("Pisteiden keskiarvo (kaikki): "
                + 1.0 * laskuri.summa() / laskuri.maara());
        if (hyvaksytyt.maara() == 0) {
            System.out.println("Pisteiden keskiarvo (hyväksytyt): -");
        } else {
            System.out.println("Pisteiden keskiarvo (hyväksytyt): " 
                    + 1.0 * hyvaksytyt.summa() / hyvaksytyt.maara());
        }
        System.out.println("Hyväksymisprosentti: " 
                + 100.0 * hyvaksytyt.maara() / laskuri.maara());
        
        jakauma.tulostaArvosanat();
    }
}
