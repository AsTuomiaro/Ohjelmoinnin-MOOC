
import java.util.Scanner;

public class RajatunLukusarjanSumma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        System.out.print("Ensimmäinen: ");
        int aloitus = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Viimeinen: ");
        int lopetus = Integer.parseInt(lukija.nextLine());
        
        int i = aloitus;
        int summa = 0;
        
        while (i <= lopetus) {            
            summa += i;
            i++;
        }
        
        System.out.println("Summa on " + summa);
    }
}
