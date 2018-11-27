
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        Scanner lukija = new Scanner(System.in);
        System.out.print("Nugetteja: ");
        int nugettienMaara = Integer.parseInt(lukija.nextLine());

        nugettienMaara = nugettienMaara - ((nugettienMaara / 20) * 20);
        nugettienMaara = nugettienMaara - ((nugettienMaara / 9) * 9);
        nugettienMaara = nugettienMaara - ((nugettienMaara / 6) * 6);
        nugettienMaara = nugettienMaara - ((nugettienMaara / 4) * 4);
        
        if (nugettienMaara != 0) {
            System.out.println("Ostaminen ei ole mahdollista");
        } else {
            System.out.println("Ostaminen on mahdollista");
        }
    }

}
