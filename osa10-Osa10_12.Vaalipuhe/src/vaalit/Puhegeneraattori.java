package vaalit;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;



public class Puhegeneraattori {
    private Tekstimalli malli;

    public Puhegeneraattori() {
        this.malli = new Tekstimalli();
    }

    public void lue(String tiedosto) {
        try {
            Files.lines(Paths.get(tiedosto))
                    .map(rivi -> rivi.split(";"))
                    .forEach(palat -> this.malli.lisaaAineisto(palat[1]));
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }
    }

    public String tuotaPuhetta(int sanojaEnintaan) {
        List<String> sanat = this.malli.sanat();
        Collections.shuffle(sanat);
        
        String puhe, seuraavaSana; 
        seuraavaSana = sanat.get(0);
        puhe = "";
        
        int indeksi = 0;
        while(seuraavaSana != null && indeksi < sanojaEnintaan) {
            puhe += seuraavaSana + " ";
            seuraavaSana = this.malli.annaSana(seuraavaSana);
            indeksi++;
        }
        
        return puhe;
    }
}
