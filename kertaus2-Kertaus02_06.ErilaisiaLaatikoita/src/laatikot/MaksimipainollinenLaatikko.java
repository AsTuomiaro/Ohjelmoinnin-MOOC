/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikot;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asko
 */
public class MaksimipainollinenLaatikko extends Laatikko {
    private int maksimipaino;
    private List<Tavara> tavarat;
    
    public MaksimipainollinenLaatikko(int maksimipaino) {
        super();
        this.maksimipaino = maksimipaino;
        this.tavarat = new ArrayList<>();
    }

    @Override
    public void lisaa(Tavara tavara) {
        int paino = this.tavarat.stream().mapToInt(t -> t.getPaino()).sum();
        if (tavara.getPaino() + paino <= this.maksimipaino) {
            this.tavarat.add(tavara);
        }
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        return this.tavarat.contains(tavara);
    }
    
    
}
