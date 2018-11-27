
import java.util.ArrayList;
import java.util.Scanner;

public class Ajatustenlukija {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> heitot = new ArrayList<>();
        int voitot = 0;
        
        while (true) {            
            if (voitot >= 25 || heitot.size() - voitot >= 25) {
                break;
            }
            
            String arvaus = arvaa(heitot);
            
            System.out.print("Syötä h tai t: ");
            String heitto = lukija.nextLine();
            
            if (heitto.equals("lopeta")) {
                break;
            }
            
            if (!heitto.equals("h") && !heitto.equals("t")) {
                System.out.println("Ei käy. Yritä uudelleen.");
                continue;
            }
            
            if (heitto.equals(arvaus)) {
                voitot++;
            }
            
            heitot.add(heitto);
            
            System.out.println("Syötit " + heitto + ", arvasin " + arvaus + ".");
            System.out.println("Tietokoneen voitot: " + voitot);
            System.out.println("Pelaajan voitot: " + (heitot.size() - voitot));
            System.out.println("");
        }
    }
    
    public static String arvaa(ArrayList<String> lista) {
        if (lista.size() < 3) {
            return "h";
        }
        
        String viimeinen = lista.get(lista.size() - 1);
        String toiseksiViimeinen = lista.get(lista.size() - 2);
        
        int i = 2;
        int heads = 0;
        int tails = 0;
        
        while (i < lista.size()) {            
            if (lista.get(i - 2).equals(toiseksiViimeinen) 
                    && lista.get(i - 1).equals(viimeinen)) {
                if (lista.get(i).equals("h")) {
                    heads++;
                } else {
                    tails++;
                }
            }
            i++;
        }
        
        if (heads > tails) {
            return "h";
        }
        return "t";
    }
}
