
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // toteuta tänne toiminnallisuus, jonka avulla käyttäjä voi syöttää
        // kirjoja sekä tarkastella niitä

        ArrayList<Kirja> kirjat = new ArrayList<>();
        Scanner lukija = new Scanner(System.in);
        
        while (true) {            
            System.out.print("Nimi: ");
            String nimi = lukija.nextLine();
            if (nimi.equals("")) {
                break;
            }
            
            System.out.print("Sivuja: ");
            int sivuja = Integer.parseInt(lukija.nextLine());
            
            System.out.print("Kirjoitusvuosi: ");
            int kirjoitusvuosi = Integer.parseInt(lukija.nextLine());
            
            kirjat.add(new Kirja(nimi, sivuja, kirjoitusvuosi));
        }
        
        System.out.print("\nMitä tulostetaan? ");
        String komento = lukija.nextLine();
        
        if (komento.equals("kaikki")) {
            for (Kirja kirja : kirjat) {
                System.out.println(kirja.getNimi() + ", " + kirja.getSivuja() 
                        + " sivua, " + kirja.getKirjoitusvuosi());
            }
        } else if (komento.equals("nimi")) {
            for (Kirja kirja : kirjat) {
                System.out.println(kirja.getNimi());
            }
        }
    }
}
