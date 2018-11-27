
import java.util.Scanner;

public class TyontekijanElakevakuutus {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Syötä bruttopalkka: ");
        double bruttopalkka = Double.parseDouble(lukija.nextLine());
        
        double antajaMaksu = bruttopalkka * 0.18;
        double saajaMaksu = bruttopalkka * 0.06;
        double maksutYhteensa = antajaMaksu + saajaMaksu;
        
        System.out.println("Työnantaja maksaa TyEL-maksuja: " + antajaMaksu);
        System.out.println("Työntekijän kustannus työnantajalle vähintään: " + 
                (bruttopalkka + antajaMaksu));
        System.out.println("\nTyöntekijä maksaa TyEL-maksuja: " + saajaMaksu);
        System.out.println("Työntekijän palkka TyEL-maksujen jälkeen: " + 
                (bruttopalkka - saajaMaksu));
        System.out.println("\nTyEL-kulut yhteensä: " + (antajaMaksu + saajaMaksu));
    }
}
