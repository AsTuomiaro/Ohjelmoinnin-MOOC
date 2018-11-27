
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Korkeus: ");
        int korkeus = Integer.parseInt(lukija.nextLine());
        
        int i = 0;
        int k = 0;
        int puolivali = (korkeus - 1) / 2;
        
        // Yläpuoliskon piirto.
        while (i <= puolivali) {            
            int j = 0;
            while (j < korkeus) {                
                if (j == (puolivali - k) || j == (puolivali + k)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                j++;
            }
            k++;
            System.out.println("");
            i++;
        }
        
        // Muuttujan k asetus. Jos korkeus on alunperin
        // parillinen, niin ok. Muutoin k:sta täytyy vielä
        // vähentää yksi.
        k = puolivali;
        if (korkeus % 2 == 1) {
            k--;
        }
        
        // Alapuoliskon piirto.
        while (i < korkeus) {            
            int j = 0;
            while (j < korkeus) {                
                if (j == (puolivali - k) || j == (puolivali + k)) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
                j++;
            }
            k--;
            System.out.println("");
            i++;
        }
    }

}
