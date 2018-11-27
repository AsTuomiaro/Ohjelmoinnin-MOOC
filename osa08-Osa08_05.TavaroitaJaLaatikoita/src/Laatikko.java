
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
public class Laatikko implements Talletettava {
    private double maxPaino;
    private ArrayList<Talletettava> tavarat;
    
    public Laatikko(double maksimiPaino) {
        this.maxPaino = maksimiPaino;
        this.tavarat = new ArrayList<>();
    }

    public void lisaa(Talletettava tallettava) {
        if (this.paino() + tallettava.paino() > this.maxPaino) {
            return;
        }
        this.tavarat.add(tallettava);   
    }
    
    @Override
    public double paino() {
        double palautettava = 0;
        for (Talletettava tavara : tavarat) {
            palautettava += tavara.paino();
        }
        return palautettava;
    }

    @Override
    public String toString() {
        return "Laatikko: " + this.tavarat.size() + " esinettä, paino yhteensä " + this.paino() + " kiloa";
    }
}
