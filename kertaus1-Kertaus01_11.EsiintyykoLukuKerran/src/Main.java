
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle
        ArrayList<Integer> luvut = new ArrayList<>();
        luvut.add(Integer.valueOf(3));
        luvut.add(Integer.valueOf(3));
        luvut.add(Integer.valueOf(2));
        luvut.add(Integer.valueOf(1));
        
        System.out.println("lista sisältää luvun 2 kerran: " + esiintykoListallaKerran(luvut, 2));
        System.out.println("lista sisältää luvun 3 kerran: " + esiintykoListallaKerran(luvut, 3));
        System.out.println("lista sisältää luvun 0 kerran: " + esiintykoListallaKerran(luvut, 0));
    }
    
    public static boolean esiintykoListallaKerran(ArrayList<Integer> luvut, int luku) {
        int i = 0;
        for (Integer j : luvut) {
            if (j == luku) {
                i++;
            }
        }
        return i == 1;
    }
}
