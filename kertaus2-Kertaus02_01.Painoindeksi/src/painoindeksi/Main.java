package painoindeksi;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // voit testata toteutuksesi toimintaa täällä
        
        Henkilo seppo = new Henkilo("Seppo", 1.85, 94, 93);
        Henkilo irina = new Henkilo("Irina", 1.62, 75, 69);
        Henkilo antti = new Henkilo("Antti", 1.90, 80, 62);
        Henkilo pentti = new Henkilo("Pentti", 1.75, 78, 60);
        Henkilo jenna = new Henkilo("Jenna", 1.70, 45, 58);
        Henkilo tero = new Henkilo("Tero", 1.85, 132, 93);
        Henkilo eino = new Henkilo("Eino", 1.73, 63, 72);
        
        List<Henkilo> jengi = new ArrayList<>();
        jengi.add(seppo);
        jengi.add(irina);
        jengi.add(antti);
        jengi.add(pentti);
        jengi.add(jenna);
        jengi.add(tero);
        jengi.add(eino);
        
        PainoindeksiRaportti raportti = new RaportinLuoja2().painoindeksiRaportti(jengi);
        
        System.out.println("Alipainoiset: ");
        for (String henkilo : raportti.getAlipainoiset()) {
            System.out.println(henkilo);
        }
        
        System.out.println("\nNormaalipainoiset: ");
        for (String henkilo : raportti.getNormaalipainoiset()) {
            System.out.println(henkilo);
        }
        
        System.out.println("\nYlipainoiset: ");
        for (String henkilo : raportti.getYlipainoiset()) {
            System.out.println(henkilo);
        }
        
        System.out.println("\nMerkittävästi ylipainoiset: ");
        for (String henkilo : raportti.getMerkittavastiYlipainoiset()) {
            System.out.println(henkilo);
        }
    }

}
