/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tyokalut;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author asko
 */
public class OmaDuplikaattienPoistaja implements DuplikaattienPoistaja {
    private int dublikaattienMaara;
    private Set<String> merkkijonot;
    
    public OmaDuplikaattienPoistaja() {
        this.merkkijonot = new HashSet<>();
        this.dublikaattienMaara = 0;
    }
    
    @Override
    public void lisaa(String merkkijono) {
        if (this.merkkijonot.contains(merkkijono)) {
            this.dublikaattienMaara++;
        }
        this.merkkijonot.add(merkkijono);
    }

    @Override
    public Set<String> getUniikitMerkkijonot() {
        return this.merkkijonot;
    }

    @Override
    public int getHavaittujenDuplikaattienMaara() {
        return this.dublikaattienMaara;
    }

    @Override
    public void tyhjenna() {
        this.merkkijonot.clear();
        this.dublikaattienMaara = 0;
    }
    
}
