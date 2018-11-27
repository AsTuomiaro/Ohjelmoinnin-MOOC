package reseptit;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Testaa luokkaa täällä
        Reseptikirja kirja = new Reseptikirja();
        Resepti omenaleivos = new Resepti("Omenaleivos");
        omenaleivos.lisaaRaakaAine("omena");
        omenaleivos.lisaaRaakaAine("kaurahiutale");
        omenaleivos.lisaaRaakaAine("fariinisokeri");
        omenaleivos.lisaaRaakaAine("voi");

        kirja.lisaaResepti(omenaleivos);

        List<Resepti> reseptit = kirja.haeRaakaAineella("jauheliha");
        System.out.println(reseptit);
        System.out.println(reseptit.size());

        List<Resepti> reseptit2 = kirja.haeRaakaAineella("omena");
        System.out.println(reseptit2.size());
        System.out.println(reseptit2.get(0).getNimi());

        List<Resepti> reseptit3 = kirja.haeRaakaAineella("mena");
        System.out.println(reseptit3.size());
        System.out.println(reseptit3);
    }
}
