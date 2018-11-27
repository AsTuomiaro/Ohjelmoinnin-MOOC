package otsikko;

import java.util.Scanner;
import javafx.application.Application;


public class Main {

    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        
        System.out.print("Anna otsikko: ");
        String otsikko = lukija.nextLine();
        String parametri = "--otsikko=" + otsikko;

        Application.launch(KayttajanOtsikko.class, parametri);
    }

}
