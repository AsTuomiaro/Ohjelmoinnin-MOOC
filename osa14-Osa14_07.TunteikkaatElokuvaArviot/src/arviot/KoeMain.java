/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arviot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author asko
 */
public class KoeMain {

    public static void main(String[] args) {
        List<String> rivit = lueRivit("src/arviot.txt");
        TunteikkaatArviot arviot = new TunteikkaatArviot(rivit);

        System.out.println(arviot.lauseenTunneMerkkijonona("unicorn is a mythical creature"));
        System.out.println(arviot.lauseenTunneMerkkijonona("chuck norris made a happy meal cry"));
        System.out.println(arviot.lauseenTunneMerkkijonona("the movie was an utter and complete failure"));
    }

    public static List<String> lueRivit(String tiedosto) {
        List<String> rivit = new ArrayList<>();
        try {
            rivit = Files.lines(Paths.get(tiedosto)).collect(Collectors.toList());
        } catch (IOException ex) {
            System.out.println("Tiedoston lukeminen epäonnistui.");
        }
        return rivit;

    }
}
