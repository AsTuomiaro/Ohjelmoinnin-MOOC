
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
public class Matkalaukku {
    private ArrayList<Tavara> tavarat;
    private int maksimiPaino;
    
    public Matkalaukku(int maksimipaino) {
        this.tavarat = new ArrayList<>();
        this.maksimiPaino = maksimipaino;
    }
    
    public void lisaaTavara(Tavara uusiTavara) {
        if (getPaino() + uusiTavara.getPaino() <= maksimiPaino) {
            this.tavarat.add(uusiTavara);
        }
    }
    
    public void tulostaTavarat() {
        for (Tavara t : tavarat) {
            System.out.println(t);
        }
    }
    
    public int yhteispaino() {
        return getPaino();
    }
    
    public Tavara raskainTavara() {
        Tavara palautettava = null;
        int suurinPaino = 0;
        for (Tavara t : tavarat) {
            if (t.getPaino() > suurinPaino) {
                palautettava = t;
                suurinPaino = t.getPaino();
            }
        }
        return palautettava;
    }

    @Override
    public String toString() {
        if (tavarat.size() == 0) {
            return "ei tavaroita (0 kg)";
        }
        if (tavarat.size() == 1) {
            return tavarat.size() + " tavara (" + getPaino() + " kg)";
        }
        return tavarat.size() + " tavaraa (" + getPaino() + " kg)";
    }
    
    private int getPaino() {
        int summa = 0;
        for (Tavara t : tavarat) {
            summa += t.getPaino();
        }
        return summa;
    }
}
