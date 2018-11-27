package seismisetmittaukset;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Double> mittausaineistoa = new ArrayList<>();
        
        mittausaineistoa.add(20150304.0);
        mittausaineistoa.add(2.0);
        mittausaineistoa.add(3.0);
        mittausaineistoa.add(1.5);
        mittausaineistoa.add(0.003);
        mittausaineistoa.add(1.3);
        
        mittausaineistoa.add(20150306.0);
        mittausaineistoa.add(2.0);
        mittausaineistoa.add(3.0);
        mittausaineistoa.add(1.5);
        mittausaineistoa.add(0.003);
        mittausaineistoa.add(1.3);
        
        mittausaineistoa.add(20150307.0);
        mittausaineistoa.add(2.0);
        mittausaineistoa.add(3.0);
        mittausaineistoa.add(1.5);
        mittausaineistoa.add(0.003);
        mittausaineistoa.add(1.3);
        
        mittausaineistoa.add(20150313.0);
        mittausaineistoa.add(2.0);
        mittausaineistoa.add(1.0);
        mittausaineistoa.add(1.5);
        mittausaineistoa.add(0.003);
        mittausaineistoa.add(1.3);
        
        mittausaineistoa.add(20150319.0);
        mittausaineistoa.add(2.0);
        mittausaineistoa.add(3.0);
        mittausaineistoa.add(1.5);
        mittausaineistoa.add(0.003);
        mittausaineistoa.add(1.3);
        
        mittausaineistoa.add(20150326.0);
        mittausaineistoa.add(2.0);
        mittausaineistoa.add(3.0);
        mittausaineistoa.add(1.5);
        mittausaineistoa.add(0.003);
        mittausaineistoa.add(1.3);
        
        mittausaineistoa.add(20150331.0);
        mittausaineistoa.add(2.0);
        mittausaineistoa.add(3.0);
        mittausaineistoa.add(1.5);
        mittausaineistoa.add(0.003);
        mittausaineistoa.add(1.3);
        
        mittausaineistoa.add(20150404.0);
        mittausaineistoa.add(2.0);
        mittausaineistoa.add(3.0);
        mittausaineistoa.add(1.5);
        mittausaineistoa.add(0.003);
        mittausaineistoa.add(1.3);
        
        mittausaineistoa.add(20150409.0);
        mittausaineistoa.add(2.0);
        mittausaineistoa.add(3.0);
        mittausaineistoa.add(1.5);
        mittausaineistoa.add(0.003);
        mittausaineistoa.add(1.3);
        
        
        List<SuurinTaajuusRaportti> raportit = new MittausRaportoija2().paivittaisetMaksimit(mittausaineistoa, 3);
        for (int i = 0; i < raportit.size(); i++) {
            System.out.println("Päivä: " + raportit.get(i).getPaiva() 
                    + ", tulos: " + raportit.get(i).getSuurinArvo());
        }
    }

}
