
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        // Kirjoita ohjelmasi tähän alle
        ArrayList<Integer> luvut = new ArrayList<>();
        
        luvut.add(Integer.valueOf(0));
        luvut.add(Integer.valueOf(0));
        luvut.add(Integer.valueOf(0));
        luvut.add(Integer.valueOf(2));
        luvut.add(Integer.valueOf(2));
        luvut.add(Integer.valueOf(2));
        luvut.add(Integer.valueOf(0));
        
        System.out.println("luku 0 esiintyy kolme kertaa listalla: " 
                + esiintyykoListallaKolmesti(luvut, 0));
        System.out.println("luku 2 esiintyy kolme kertaa listalla: " 
                + esiintyykoListallaKolmesti(luvut, 2));
        System.out.println("luku 3 esiintyy kolme kertaa listalla: " 
                + esiintyykoListallaKolmesti(luvut, 3));
    }

    public static boolean esiintyykoListallaKolmesti(ArrayList<Integer> luvut, int luku) {
        int i = 0;
        for (Integer j : luvut) {
            if (j == luku) {
                i++;
            }
        }
        return i == 3;
    }
}
