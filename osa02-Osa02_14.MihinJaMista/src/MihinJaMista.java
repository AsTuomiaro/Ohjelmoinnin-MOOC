
import java.util.Scanner;

public class MihinJaMista {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Mihin asti? ");
        int lopetus = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Mistä lähtee? ");
        int indeksi = Integer.parseInt(lukija.nextLine());
        
        while (indeksi <= lopetus) {            
            System.out.println(indeksi);
            indeksi++;
        }
    }
}
