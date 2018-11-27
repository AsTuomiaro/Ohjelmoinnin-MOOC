
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoytyykoTiedostosta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> lista = new ArrayList<>();
        
        System.out.println("Minkä niminen tiedosto luetaan? ");
        String tiedosto = lukija.nextLine();

        System.out.println("Mitä etsitään?");
        String etsittava = lukija.nextLine();

        try (Scanner tiedostolukija = new Scanner(new File(tiedosto))) {
            while (tiedostolukija.hasNextLine()) {                
                lista.add(tiedostolukija.nextLine());
            }
            if (lista.contains(etsittava)) {
                System.out.println("Löytyi!");
            } else {
                System.out.println("Ei löytynyt.");
            }
        } catch (Exception e) {
            System.out.println("Tiedoston " + tiedosto + " lukeminen epäonnistui.");
        }
    }
}
