
public class Tulostelua {

    public static void tulostaTahtia(int maara) {
        // 22.1
        int i = 0;
        while (i < maara) {            
            System.out.print("*");
            i++;
        }
        System.out.println("");
    }

    public static void tulostaNelio(int sivunpituus) {
        // 22.2
        int i = 0;
        while (i < sivunpituus - 1) {            
            tulostaTahtia(sivunpituus);
            i++;
        }
        tulostaTahtia(sivunpituus);
    }

    public static void tulostaSuorakulmio(int leveys, int korkeus) {
        // 22.3
        int i = 0;
        while (i < korkeus) {            
            tulostaTahtia(leveys);
            i++;
        }
    }

    public static void tulostaKolmio(int koko) {
        // 22.4
        int i = 1;
        while (i <= koko) {            
            tulostaTahtia(i);
            i++;
        }
    }

    public static void main(String[] args) {

        // Testit eivät katso main-metodia, voit muutella tätä vapaasti.
        // HUOM: jos testit eivät meinaa mennä läpi, kokeile pääohjelmaa ajamalla,
        // että metodit toimivat niinkuin niiden on tarkoitus toimia!
        tulostaTahtia(3);
        System.out.println("\n---");  // tulostetaan kuvioiden välille ---
        tulostaNelio(4);
        System.out.println("\n---");
        tulostaSuorakulmio(5, 6);
        System.out.println("\n---");
        tulostaKolmio(3);
        System.out.println("\n---");
    }

}
