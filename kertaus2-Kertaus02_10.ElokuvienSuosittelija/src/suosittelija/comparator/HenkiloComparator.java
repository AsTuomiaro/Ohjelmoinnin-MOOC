/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suosittelija.comparator;

import java.util.Comparator;
import java.util.Map;
import suosittelija.domain.Henkilo;

/**
 *
 * @author asko
 */
public class HenkiloComparator implements Comparator<Henkilo> {
    private Map<Henkilo, Integer> henkiloidenSamuudet;
    
    public HenkiloComparator(Map<Henkilo, Integer> henkiloidenSamuudet) {
        this.henkiloidenSamuudet = henkiloidenSamuudet;
    }

    @Override
    public int compare(Henkilo t, Henkilo t1) {
        return this.henkiloidenSamuudet.getOrDefault(t1, 0) - this.henkiloidenSamuudet.getOrDefault(t, 0);
    }
}
