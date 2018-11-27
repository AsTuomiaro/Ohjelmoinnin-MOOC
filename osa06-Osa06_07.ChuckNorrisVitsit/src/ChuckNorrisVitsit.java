
import java.util.Scanner;
import java.net.URL;

public class ChuckNorrisVitsit {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);

        // Toteuta vitsien lukeminen tässä
        while (true) {            
            String komento = lukija.nextLine();
            if (komento.length() < 6) {
                System.out.println("Ei laillinen komento.");
                continue;
            }
            if (komento.equals("lopeta")) {
                break;
            }
            if (komento.equals("satunnainen")) {
                try (Scanner urlLukija = new Scanner(new URL("http://api.icndb.com/jokes/random").openStream())) {
                    if (urlLukija.hasNextLine()) {
                        System.out.println(urlLukija.nextLine());
                    }
                } catch (Exception e) {
                    System.out.println("Jotain meni vikaan: " + e.getMessage());
                }
            } else if (komento.substring(0, 6).equals("vitsi ")) {
                int luku = Integer.parseInt(komento.substring(6));
                try (Scanner urlLukija = new Scanner(new URL("http://api.icndb.com/jokes/" + luku).openStream())) {
                    if (urlLukija.hasNextLine()) {
                        System.out.println(urlLukija.nextLine());
                    }
                } catch (Exception e) {
                    System.out.println("Jotain meni vikaan: " + e.getMessage());
                }
            } else {
                System.out.println("Ei laillinen komento.");
            }
        }
    }
}