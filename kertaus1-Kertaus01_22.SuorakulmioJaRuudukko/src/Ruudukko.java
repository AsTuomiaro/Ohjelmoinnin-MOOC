
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Ruudukko {
    private HashMap<Integer, HashMap<Integer, String>> taulukko;
    private int leveys, korkeus;
    
    public Ruudukko() {
        this.taulukko = new HashMap<>();
        this.leveys = 0;
        this.korkeus = 0;
    }
    
    public void lisaa(Suorakulmio s) {
        int x = s.getX();
        int y = s.getY();
        int suorakulmioLeveys = s.getLEVEYS();
        int suorakulmioKorkeus = s.getKORKEUS();
        
        for (int i = x; i < x + suorakulmioLeveys; i++) {
            for (int j = y; j < y + suorakulmioKorkeus; j++) {
                this.taulukko.putIfAbsent(i, new HashMap<>());
                this.taulukko.get(i).putIfAbsent(j, "X");
            }
        }
        
        if (x + suorakulmioLeveys > this.leveys) {
            this.leveys = x + suorakulmioLeveys;
        }
        if (y + suorakulmioKorkeus > this.korkeus) {
            this.korkeus = y + suorakulmioKorkeus;
        }
    }

    @Override
    public String toString() {
        String palautettava = "";
        for (int i = 0; i < this.korkeus; i++) {
            for (int j = 0; j < this.leveys; j++) {
                HashMap<Integer, String> t = this.taulukko.get(j);
                if (t == null) {
                    palautettava += " ";
                } else {
                    palautettava += t.getOrDefault(i, " ");
                }
            }
            palautettava += "\n";
        }
        return palautettava;
    }
}
