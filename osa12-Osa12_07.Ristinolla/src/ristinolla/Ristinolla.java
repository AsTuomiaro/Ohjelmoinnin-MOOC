/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ristinolla;

/**
 *
 * @author asko
 */
public class Ristinolla {

    private String[] paikat;

    public Ristinolla() {
        this.paikat = new String[9];
        for (int i = 0; i < this.paikat.length; i++) {
            paikat[i] = i + "";
        }
    }

    public String getPaikka(int i) {
        return this.paikat[i];
    }

    public void setPaikka(int i, String uusiArvo) {
        this.paikat[i] = uusiArvo;
    }

    public boolean peliOnPaattynyt() {
        if ((paikat[0].equals(paikat[1]) && paikat[1].equals(paikat[2]))
                || (paikat[3].equals(paikat[4]) && paikat[4].equals(paikat[5]))
                || (paikat[6].equals(paikat[7]) && paikat[7].equals(paikat[8]))
                || (paikat[0].equals(paikat[3]) && paikat[3].equals(paikat[6]))
                || (paikat[1].equals(paikat[4]) && paikat[4].equals(paikat[7]))
                || (paikat[2].equals(paikat[5]) && paikat[5].equals(paikat[8]))
                || (paikat[0].equals(paikat[4]) && paikat[4].equals(paikat[8]))
                || (paikat[6].equals(paikat[4]) && paikat[4].equals(paikat[2]))) {
            return true;
        }
        return false;
    }
}
