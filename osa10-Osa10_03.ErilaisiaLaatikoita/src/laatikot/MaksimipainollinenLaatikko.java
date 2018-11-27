/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikot;

import java.util.ArrayList;

/**
 *
 * @author asko
 */
public class MaksimipainollinenLaatikko extends Laatikko {
    private int maksimipaino;
    private ArrayList<Tavara> tavarat;
    
    public MaksimipainollinenLaatikko(int maksimipaino) {
        super();
        this.maksimipaino = maksimipaino;
        this.tavarat = new ArrayList<>();
    }

    @Override
    public void lisaa(Tavara tavara) {
        int nykyinenPaino = 0;
        for (Tavara t : this.tavarat) {
            nykyinenPaino += t.getPaino();
        }
        if (tavara.getPaino() + nykyinenPaino <= this.maksimipaino) {
            this.tavarat.add(tavara);
        }
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        return this.tavarat.contains(tavara);
    }
}
