
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
public class Arvosanajakauma {
    private int[] arvosanat;
    
    public Arvosanajakauma() {
        this.arvosanat = new int[6];        
    }
    
    public void lisaaArvosana(int arvosana) {
        if (arvosana >= 0 && arvosana <= arvosanat.length - 1) {
            arvosanat[arvosana] = arvosanat[arvosana] + 1;
        }
    }
    
    public void tulostaArvosanat() {
        System.out.println("Arvosanajakauma:");
        int i = arvosanat.length - 1;
        while (i >= 0) {            
            System.out.print(i + ": ");
            tulostaTahtia(arvosanat[i]);
            i--;
        }
    }
    
    private void tulostaTahtia(int maara) {
        int i = 0;
        while (i < maara) {            
            System.out.print("*");
            i++;
        }
        System.out.println("");
    }
}
