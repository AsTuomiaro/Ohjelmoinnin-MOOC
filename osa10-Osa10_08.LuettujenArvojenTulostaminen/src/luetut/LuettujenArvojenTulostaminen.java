package luetut;


import java.util.ArrayList;
import java.util.Scanner;

public class LuettujenArvojenTulostaminen {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        ArrayList<String> luetut = new ArrayList<>();
        
        while(true) {
            String syote = lukija.nextLine();
            if (syote.isEmpty()) {
                break;
            }
            luetut.add(syote);
        }
        
        luetut.stream().forEach(merkkijono -> System.out.println(merkkijono));
    }
}
