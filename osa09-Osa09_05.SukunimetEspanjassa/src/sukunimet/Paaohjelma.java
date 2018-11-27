package sukunimet;

public class Paaohjelma {

    public static void main(String[] args) {
        //kokeile ohjelman toimintaa täällä
        Henkilo hay = new Henkilo("Hay", "Alen", "Gualarga");
        Henkilo nacho = new Henkilo("Nacho", "Cuesta", "Parto");
        Henkilo dolores = new Henkilo("Dolores", "D.", "Parto");
        Henkilo valeria = new Henkilo("Valeria", "Mogollon", "Gualarga");
        Henkilo enrico = new Henkilo("Enrico", dolores, hay);
        Henkilo luz = new Henkilo("Luz", nacho, valeria);
        Henkilo valentina = new Henkilo("Valentina", enrico, luz);

        Perhe perhe = new Perhe();
        perhe.lisaa(dolores);
        perhe.lisaa(luz);
        perhe.lisaa(valentina);
        System.out.println(perhe);

        System.out.println();

        perhe.poista(luz);
        System.out.println(perhe);

        System.out.println();

        Object perheObj = perhe;
        System.out.println(perheObj);

        System.out.println();

        perhe.lisaa(enrico);
        System.out.println(perheObj);
    }
}
