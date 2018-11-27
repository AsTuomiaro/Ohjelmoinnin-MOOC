/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laatikot;

/**
 *
 * @author asko
 */
public class YhdenTavaranLaatikko extends Laatikko {
    private Tavara tavara;
    
    public YhdenTavaranLaatikko() {
        super();
        this.tavara = null;
    }

    @Override
    public void lisaa(Tavara tavara) {
        if (this.tavara == null) {
            this.tavara = tavara;
        }
    }

    @Override
    public boolean onkoLaatikossa(Tavara tavara) {
        if (this.tavara == null) {
            return false;
        }
        return this.tavara.equals(tavara);
    }
}
