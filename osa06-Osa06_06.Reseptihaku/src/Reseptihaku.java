
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Reseptihaku {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<Resepti> reseptit = new ArrayList<>();

        System.out.print("Mistä luetaan? ");
        String tiedosto = lukija.nextLine();
        
        try (Scanner tiedostolukija = new Scanner(new File(tiedosto))) {
            while (tiedostolukija.hasNextLine()) {                
                String nimi = tiedostolukija.nextLine();
                int keittoaika = Integer.parseInt(tiedostolukija.nextLine());
                Resepti uusiResepti = new Resepti(nimi, keittoaika);
                reseptit.add(uusiResepti);
                
                while (tiedostolukija.hasNextLine()) {                    
                    String raakaAine = tiedostolukija.nextLine();
                    if (raakaAine.isEmpty()) {
                        break;
                    }
                    uusiResepti.lisaaAines(raakaAine);
                }
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
        
        System.out.println("Komennot:");
        System.out.println("listaa - listaa reseptit");
        System.out.println("lopeta - lopettaa ohjelman");
        System.out.println("hae nimi - hakee reseptiä nimen perusteella");
        System.out.println("hae keittoaika - hakee reseptiä keittoajan perusteella");
        System.out.println("hae aine - hakee reseptiä raaka-aineen perusteella");
        
        while (true) {
            System.out.print("\nSyötä komento: ");
            String komento = lukija.nextLine();
            if (komento.equals("listaa")) {
                System.out.println("\nReseptit:");
                for (Resepti r : reseptit) {
                    System.out.println(r);
                }
            } else if (komento.equals("lopeta")) {
                break;  
            } else if (komento.equals("hae aine")) {
                System.out.print("Mitä raaka-ainetta haetaan? ");
                String hakuAine = lukija.nextLine();
                
                System.out.println("\nReseptit: ");
                for (Resepti r : reseptit) {
                    if (r.haeAines(hakuAine)) {
                        System.out.println(r);
                    }
                }
            } else if (komento.equals("hae keittoaika")) {
                  System.out.print("Keittoaika korkeintaan: ");
                  int hakuAika = Integer.parseInt(lukija.nextLine());
                  
                  System.out.println("\nReseptit: ");
                  for (Resepti r : reseptit) {
                      if (r.getKeittoaika() <= hakuAika) {
                          System.out.println(r);
                      }
                  }
            } else if (komento.equals("hae nimi")) {
                System.out.print("Mitä haetaan: ");
                String hakusana = lukija.nextLine();
                
                System.out.println("\nReseptit:");
                for (Resepti r : reseptit) {
                    if (r.getNimi().indexOf(hakusana) >= 0) {
                        System.out.println(r);
                    }
                }
            } else {
                System.out.println("Ei määritelty komento!");
            }
        }
    }
}
