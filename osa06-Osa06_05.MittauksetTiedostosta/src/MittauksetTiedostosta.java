
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MittauksetTiedostosta {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        
        System.out.print("Tiedosto? ");
        String tiedosto = lukija.nextLine();
        System.out.print("Alaraja? ");
        int alaraja = Integer.parseInt(lukija.nextLine());
        System.out.print("Yläraja? ");
        int ylaraja = Integer.parseInt(lukija.nextLine());

        try (Scanner tiedostolukija = new Scanner(new File(tiedosto))) {
            while (tiedostolukija.hasNextLine()) {                
                lista.add(Integer.parseInt(tiedostolukija.nextLine()));
            }
            
            int lukuja = 0;
            for (Integer i : lista) {
                if (i >= alaraja && i<= ylaraja) {
                    lukuja++;
                }
            }
            System.out.println("Lukuja: " + lukuja);
        } catch (Exception e) {
            System.out.println("Tapahtui virhe: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
