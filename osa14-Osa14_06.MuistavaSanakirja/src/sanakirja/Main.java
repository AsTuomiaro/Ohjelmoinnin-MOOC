package sanakirja;

public class Main {

    public static void main(String[] args) {
        // Testaa sanakirjaa täällä
        MuistavaSanakirja sanakirja = new MuistavaSanakirja("src/sanat.txt");
        sanakirja.lataa();

        sanakirja.tallenna();
    }
}
