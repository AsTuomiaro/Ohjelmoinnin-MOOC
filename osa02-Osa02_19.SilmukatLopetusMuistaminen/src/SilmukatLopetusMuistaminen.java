
import java.util.Scanner;

public class SilmukatLopetusMuistaminen {

    public static void main(String[] args) {
        // Kyseessä on yksi iso tehtävä jota koko ajan laajennetaan -- tehtävä
        // on viiden yksittäisen tehtäväpisteen arvoinen

        // Voit halutessasi lähettää osittain tehdyn tehtäväsarjan tarkastettavaksi palvelimelle
        // palvelin valittaa tällöin niistä testeistä joita vastaava koodi ei ole vielä
        // kirjoitettu. Jo tehdyt osat kuitenkin kirjautuvat tehdyiksi.
        Scanner lukija = new Scanner(System.in);
        
        System.out.println("Syötä luvut:");
        
        int summa = 0;
        int lukumaara = 0;
        int parilliset = 0;
        while (true) {            
            int luku = Integer.parseInt(lukija.nextLine());
            if (luku == -1) {
                break;
            }
            lukumaara++;
            summa += luku;
            if (luku % 2 == 0) {
                parilliset++;
            }
        }
        System.out.println("Kiitos ja näkemiin!");
        System.out.println("Summa: " + summa);
        System.out.println("Lukuja: " + lukumaara);
        if (lukumaara > 0) {
            System.out.println("Keskiarvo: "+ (1.0 * summa / lukumaara));
        } else {
            System.out.println("Keskiarvoa ei määritelty.");
        }
        System.out.println("Parillisia: " + parilliset);
        System.out.println("Parittomia: " + (lukumaara - parilliset));
    }
}
