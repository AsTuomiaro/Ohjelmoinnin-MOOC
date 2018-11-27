package testausta;

import java.util.Scanner;

public class Ohjelma {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println(suorita(lukija));
    }

    public static String suorita(Scanner lukija) {
        int pulloja = 0;
        int oppilaita = 0;
        double keskiarvo = 0;

        try {
            while (lukija.hasNextLine()) {
                int syote = Integer.parseInt(lukija.nextLine());
                if (syote < -1) {
                    continue;
                }
                if (syote == -1) {
                    break;
                }

                pulloja += syote;
                oppilaita++;
            }
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

        // Pulloja tai oppilaita ei voi olla negatiivisesti.
        if (pulloja < 0) {
            pulloja = 0;
        }
        if (oppilaita < 0) {
            oppilaita = 0;
        }
        
        // Palautusarvon formaatin määritys.
        String keskiarvosyote = "\nKeskiarvoa ei voida laskea";
        
        if (pulloja > 0) {
            keskiarvo = 1.0 * pulloja / oppilaita;
            keskiarvosyote = "\nKeskiarvo: " + keskiarvo;
        }

        return "Pulloja: " + pulloja + "\nOppilaita: "
                + oppilaita + keskiarvosyote;
    }
}
