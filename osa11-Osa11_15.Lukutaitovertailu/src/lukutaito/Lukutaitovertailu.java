package lukutaito;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Lukutaitovertailu {
    
    public static void main(String[] args) {

        try {
            Files.lines(Paths.get("lukutaito.csv"))
                    .map(rivi -> rivi.split(","))
                    .sorted((h1, h2) -> {
                        return h1[5].trim().compareTo(h2[5].trim());
                    })
                    .forEach(rivi -> 
                        System.out.println(rivi[3].trim() 
                                + " (" + rivi[4].trim() + "), "
                                + rivi[2].trim().split("\\s+")[0] + ", "
                                + rivi[5].trim()));
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }
}
