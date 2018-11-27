
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
public class Pistelaskuri {
    private ArrayList<Integer> pisteet;
    
    public Pistelaskuri() {
        this.pisteet = new ArrayList<>();
    }
    
    public void lisaaPisteet(int pisteet) {
        this.pisteet.add(pisteet);
    }
    
    public int maara() {
        return pisteet.size();
    }
    
    public int summa() {
        int summa = 0;
        for (Integer i : pisteet) {
            summa += i;
        }
        return summa;
    }
}
