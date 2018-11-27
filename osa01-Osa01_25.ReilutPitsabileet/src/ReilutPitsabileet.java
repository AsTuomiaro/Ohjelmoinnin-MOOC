
import java.util.Scanner;

public class ReilutPitsabileet {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Montako osallistujaa? ");
        int osallistujienMaara = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Montako pitsaa? ");
        int pitsojenMaara = Integer.parseInt(lukija.nextLine());
        
        System.out.print("Montako palaa per pitsa? ");
        int palaaPerPitsa = Integer.parseInt(lukija.nextLine());
        
        int ylimaaraisetPalat = (pitsojenMaara * palaaPerPitsa) % osallistujienMaara;
        
        System.out.println("\nPaloja jää yli: " + ylimaaraisetPalat);
    }
}
