/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kortit;

import java.util.Comparator;

/**
 *
 * @author asko
 */
public class SamatMaatVierekkainArvojarjestykseen implements Comparator<Kortti>{

    @Override
    public int compare(Kortti t, Kortti t1) {
        if (t == null && t1 == null) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t1 == null) {
            return 1;
        }
        
        int palautettava = 0;
        if (t.getMaa() != null && t1.getMaa() != null) {
            palautettava = t.getMaa().ordinal() - t1.getMaa().ordinal();
        }
        if (palautettava == 0) {
            palautettava = t.getArvo() - t1.getArvo();
        }
        return palautettava;
    }
}
