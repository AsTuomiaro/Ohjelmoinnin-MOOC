
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // toteuta luokkaa Ohjelma käyttävä ohjelmasi tänne

        ArrayList<Ohjelma> ohjelmat = new ArrayList<>();
        Scanner lukija = new Scanner(System.in);

        while (true) {            
            System.out.print("Nimi: ");
            String nimi = lukija.nextLine();
            if (nimi.equals("")) {
                break;
            }
            
            System.out.print("Pituus: ");
            int pituus = Integer.parseInt(lukija.nextLine());
            
            ohjelmat.add(new Ohjelma(nimi, pituus));
        }
        
        System.out.print("\nOhjelman maksimipituus: ");
        int maksimipituus = Integer.parseInt(lukija.nextLine());
        
        for (Ohjelma o : ohjelmat) {
            if (o.getPituus() <= maksimipituus) {
                System.out.println(o);
            }
        }
    }
}
