
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asko
 */
public class Maatila implements Eleleva {
    private String omistaja;
    private Navetta navetta;
    private ArrayList<Lehma> lehmat;
    
    public Maatila(String omistaja, Navetta navetta) {
        this.omistaja = omistaja;
        this.navetta = navetta;
        this.lehmat = new ArrayList<>();
    }

    public String getOmistaja() {
        return omistaja;
    }
    
    public void lisaaLehma(Lehma uusiLehma) {
        this.lehmat.add(uusiLehma);
    }
    
    public void hoidaLehmat() {
        this.navetta.hoida(lehmat);
    }
    
    public void asennaNavettaanLypsyrobotti(Lypsyrobotti lypsyrobotti) {
        this.navetta.asennaLypsyrobotti(lypsyrobotti);
    }

    @Override
    public void eleleTunti() {
        for (Lehma lehma : this.lehmat) {
            lehma.eleleTunti();
        }
    }

    @Override
    public String toString() {
        String palautettava = "Maatilan omistaja: " + this.omistaja + "\n" 
                + "Navetan maitosäiliö: " + this.navetta + "\n";
        
        if (this.lehmat.isEmpty()) {
            return palautettava + "Ei lehmiä";
        }
        
        String lehmatMerkkijonona = "Lehmät:";
        
        for (Lehma lehma : this.lehmat) {
            lehmatMerkkijonona += "\n    " + lehma.toString();
        }
        
        return palautettava + lehmatMerkkijonona;
    }
}
