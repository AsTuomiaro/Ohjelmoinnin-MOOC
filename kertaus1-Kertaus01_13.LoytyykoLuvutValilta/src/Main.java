
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle

        ArrayList<Integer> luvut = new ArrayList<>();
        
        luvut.add(Integer.valueOf(0));
        luvut.add(Integer.valueOf(2));
        luvut.add(Integer.valueOf(1));
        luvut.add(Integer.valueOf(3));
        luvut.add(Integer.valueOf(4));
        luvut.add(Integer.valueOf(7));
        
        System.out.println("Löytyykö luvut väliltä 0 ja 4: " + loytyykoLuvutValilta(luvut, 0, 4));
        System.out.println("Löytyykö luvut väliltä 0 ja 8: " + loytyykoLuvutValilta(luvut, 0, 8));
        System.out.println("Löytyykö luvut väliltä 1 ja 5: " + loytyykoLuvutValilta(luvut, 1, 5));
        System.out.println("Löytyykö luvut väliltä 2 ja 0: " + loytyykoLuvutValilta(luvut, 2, 0));
    }

    public static boolean loytyykoLuvutValilta(ArrayList<Integer> luvut, int alku, int loppu) {
        if (alku > loppu || luvut == null) {
            return false;
        }
        for (int i = alku; i <= loppu; i++) {
            if (!luvut.contains(Integer.valueOf(i))) {
                return false;
            }
        }
        return true;
    }
}
