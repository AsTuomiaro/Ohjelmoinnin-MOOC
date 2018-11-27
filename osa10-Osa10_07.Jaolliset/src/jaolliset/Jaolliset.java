package jaolliset;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Jaolliset {

    public static void main(String[] args) {
        ArrayList<Integer> luvut = new ArrayList<>();
        luvut.add(3);
        luvut.add(2);
        luvut.add(-17);
        luvut.add(-5);
        luvut.add(7);

        ArrayList<Integer> jaolliset = jaolliset(luvut);

        jaolliset.stream()
                .forEach(luku -> System.out.println(luku));
    }

    public static ArrayList<Integer> jaolliset(ArrayList<Integer> luvut) {
        return luvut.stream()
                .filter(arvo -> arvo % 2 == 0 || arvo % 3 == 0 || arvo % 5 == 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
