
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle
        Scanner lukija = new Scanner(System.in);
        System.out.print("Syöte: ");
        String syote = lukija.nextLine();

        int puolivali = syote.length() / 2;
        int i = 0;
        boolean onPalindromi = true;

        while (i < puolivali) {
            if (syote.charAt(i) != syote.charAt(syote.length() - 1 - i)) {
                onPalindromi = false;
                break;
            }
            i++;
        }

        if (!onPalindromi) {
            System.out.println("Syöte ei ole palindromi");
            return;
        }
        if (syote.length() % 2 == 0) {
            System.out.println("Ei jakajamerkkiä");
        } else {
            System.out.println("Palindromin jakajamerkki on " + syote.charAt(i));
        }
    }

}
