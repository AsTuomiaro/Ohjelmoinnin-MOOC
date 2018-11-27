/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package makihyppy.kilpailu;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author asko
 */
public class Tuomari {
    private int[] pisteet;
    
    public Tuomari() {
        this.pisteet = new int[5];
    }
    
    public void tuomaroi() {
        int[] uudetPisteet = new int[5];
        Random rnd = new Random();
        
        for (int i = 0; i < pisteet.length; i++) {
            uudetPisteet[i] = rnd.nextInt(11) + 10;
        }
        
        this.pisteet = uudetPisteet;
    }
    
    public int annaPisteet() {
        int min = pisteet[0];
        int max = pisteet[0];
        int summa = pisteet[0];
        
        for (int i = 1; i < pisteet.length; i++) {
            if (pisteet[i] < min) {
                min = pisteet[i];
            }
            if (pisteet[i] > max) {
                max = pisteet[i];
            }
            summa += pisteet[i];
        }
        return summa - (min + max);
    }

    @Override
    public String toString() {
        return Arrays.toString(pisteet);
    }
}
