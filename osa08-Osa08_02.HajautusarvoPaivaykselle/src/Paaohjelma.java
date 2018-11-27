
public class Paaohjelma {

    public static void main(String[] args) {
        // tee tänne testipääohjelmia
        
        Paivays paivays1 = new Paivays(14, 8, 1910);
        Paivays paivays2 = new Paivays(15, 8, 1911);
        Paivays paivays3 = new Paivays(14, 8, 2010);
        Paivays paivays4 = new Paivays(14, 7, 1910);
        
        System.out.println(paivays1.hashCode());
        System.out.println(paivays2.hashCode());
        System.out.println(paivays3.hashCode());
        System.out.println(paivays4.hashCode());
    }
}
