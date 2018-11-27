
import java.util.ArrayList;
import java.util.Scanner;

public class Varasto {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> varasto = new ArrayList<>();
        
        System.out.println("Varastohallinta.");
        
        while (true) {            
            System.out.println("\nSyötä komento (lisaa, poista, hae, lopeta):");
            String komento = lukija.nextLine();
            
            if (komento.equals("lopeta")) {
                break;
            }
            if (komento.equals("lisaa")) {
                System.out.println("Syötä esine: ");
                varasto.add(lukija.nextLine());
            }
            if (komento.equals("poista")) {
                System.out.println("Syötä esine: ");
                varasto.remove(lukija.nextLine());
            }
            if (komento.equals("hae")) {
                System.out.println("Syötä esine: ");
                String esine = lukija.nextLine();
                if (varasto.contains(esine)) {
                    System.out.println("Esine " + esine + " löytyy varastosta.");
                } else {
                    System.out.println("Esine " + esine + " ei löydy varastosta.");
                }
            }
        }
    }
}
