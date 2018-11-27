
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
public class Lastiruuma {
    private ArrayList<Matkalaukku> ruuma;
    private int maksimipaino;
    
    public Lastiruuma(int maksimipaino) {
        this.maksimipaino = maksimipaino;
        this.ruuma = new ArrayList<>();
    }
    
    public void lisaaMatkalaukku(Matkalaukku laukku) {
        if (getPaino() + laukku.yhteispaino() <= maksimipaino) {
            this.ruuma.add(laukku);
        }
    }

    @Override
    public String toString() {
        return this.ruuma.size() + " matkalaukkua (" + getPaino() + " kg)";
    }
    
    public void tulostaTavarat() {
        for (Matkalaukku m : ruuma) {
            m.tulostaTavarat();
        }
    }
    
    private int getPaino() {
        int summa = 0;
        for (Matkalaukku laukku : ruuma) {
            summa += laukku.yhteispaino();
        }
        return summa;
    }
}
