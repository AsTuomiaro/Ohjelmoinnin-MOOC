import java.util.Scanner;

public class Kertoma {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna luku: ");
        int lopetus = Integer.parseInt(lukija.nextLine());
        int i = 1;
        int kertoma = 1;
        
        while (i <= lopetus) {            
            kertoma *= i;
            i++;
        }
        
        System.out.println("Kertoma on " + kertoma);
    }
}
