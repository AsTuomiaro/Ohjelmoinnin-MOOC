import java.util.Scanner;

public class Loppuosa {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna sana: ");
        String sana = lukija.nextLine();
        
        System.out.print("Loppuosan pituus: ");
        int pituus = Integer.parseInt(lukija.nextLine());
        
        // Luodaan apumuuttuja, joka pitää huolen siitä, ettei
        // haluttu indeksi asetu negatiiviseksi.
        int indeksi = sana.length() - pituus;
        if (indeksi < 0 ) {
            indeksi = 0;
        }
        
        System.out.println("Tulos: " + sana.substring(indeksi));
    }
}
