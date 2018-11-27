
import java.util.Scanner;

public class PuhelinmuistioSovellus {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Puhelinmuistio muistio = new Puhelinmuistio();
        
        System.out.print("Minkä niminen tiedosto ladataan? ");
        String latausnimi = lukija.nextLine();
        muistio.lataa(latausnimi);
        System.out.println("");

        System.out.println("Puhelinmuistio");
        System.out.println("Komennot:");
        System.out.println("\tlopeta - lopettaa puhelinmuistion");
        System.out.println("\tlisaa - lisää uuden henkilön puhelinmuistioon");
        System.out.println("\tlistaa - listaa puhelinmuistion sisällön");
        System.out.println("\tetsi - etsii puhelinmuistiosta annettua numeroa");
        System.out.println("\tpoista - poistaa henkilön puhelinmuistiosta");
        
        // tee toteutuksesi tänne
        
        while (true) {            
            System.out.print("Komento: ");
            String komento = lukija.nextLine();
            if (komento.equals("lopeta")) {
                break;
            } else if (komento.equals("lisaa")) {
                System.out.println("Kenet lisätään?");
                System.out.print("Etunimi: ");
                String etunimi = lukija.nextLine();
                
                System.out.print("Sukunimi: ");
                String sukunimi = lukija.nextLine();
                
                System.out.print("Puhelinnumero: ");
                String puhelinnumero = lukija.nextLine();
                muistio.lisaa(etunimi, sukunimi, puhelinnumero);
                
            } else if (komento.equals("listaa")) {
                muistio.listaa();
            } else if (komento.equals("etsi")) {
                System.out.print("Mitä numeroa etsitään? ");
                String numero = lukija.nextLine();
                muistio.etsiPuhelinnumerolla(numero);
            } else if (komento.equals("poista")) {
                System.out.println("Kuka poistetaan?");
                
                System.out.print("Etunimi: ");
                String etunimi = lukija.nextLine();
                
                System.out.print("Sukunimi: ");
                String sukunimi = lukija.nextLine();
                muistio.poista(etunimi, sukunimi);
            } else {
                System.out.println("Tuntematon komento");
            }
            
            System.out.println("");
        }
        
        System.out.print("Minkä nimiseen tiedostoon muistio tallennetaan? ");
        String tallennusnimi = lukija.nextLine();
        muistio.tallenna(tallennusnimi);        
    }
}
