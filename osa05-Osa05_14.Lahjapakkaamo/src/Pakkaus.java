
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
public class Pakkaus {
    private ArrayList<Lahja> lahjalista;
    
    public Pakkaus() {
        this.lahjalista = new ArrayList<>();
    }
    
    public void lisaaLahja(Lahja uusiLahja) {
        this.lahjalista.add(uusiLahja);
    }
    
    public int getPaino() {
        int summa = 0;
        for (Lahja lahja : lahjalista) {
            summa += lahja.getPaino();
        }
        return summa;
    }
}
