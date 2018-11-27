package ristinolla;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class RistinollaSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        
        Vuoro vuoro = new Vuoro("X");
        Ristinolla peli = new Ristinolla();
        
        Label vuoroelementti = new Label("Vuoro: X");
        vuoroelementti.setFont(Font.font("Monospaced", 40));
        
        Button nappi11 = new Button(" ");
        nappi11.setFont(Font.font("Monospaced", 40));
        nappi11.setOnAction((t) -> {
            if (!vuoroelementti.getText().equals("Loppu!") && nappi11.getText().equals(" ")) {
                nappi11.setText(vuoro.getVuoro());
                peli.setPaikka(0, vuoro.getVuoro());
                vuoro.setVuoro(seuraavaVuoro(vuoro.getVuoro()));
                vuoroelementti.setText("Vuoro: " + vuoro.getVuoro());
            }
            if (peli.peliOnPaattynyt()) {
                vuoroelementti.setText("Loppu!");
            }
        });
        
        Button nappi12 = new Button(" ");
        nappi12.setFont(Font.font("Monospaced", 40));
        nappi12.setOnAction((t) -> {
            if (!vuoroelementti.getText().equals("Loppu!") && nappi12.getText().equals(" ")) {
                nappi12.setText(vuoro.getVuoro());
                peli.setPaikka(1, vuoro.getVuoro());
                vuoro.setVuoro(seuraavaVuoro(vuoro.getVuoro()));
                vuoroelementti.setText("Vuoro: " + vuoro.getVuoro());
            }
            if (peli.peliOnPaattynyt()) {
                vuoroelementti.setText("Loppu!");
            }
        });
        
        Button nappi13 = new Button(" ");
        nappi13.setFont(Font.font("Monospaced", 40));
        nappi13.setOnAction((t) -> {
            if (!vuoroelementti.getText().equals("Loppu!") && nappi13.getText().equals(" ")) {
                nappi13.setText(vuoro.getVuoro());
                peli.setPaikka(2, vuoro.getVuoro());
                vuoro.setVuoro(seuraavaVuoro(vuoro.getVuoro()));
                vuoroelementti.setText("Vuoro: " + vuoro.getVuoro());
            }
            if (peli.peliOnPaattynyt()) {
                vuoroelementti.setText("Loppu!");
            }
        });
        
        Button nappi21 = new Button(" ");
        nappi21.setFont(Font.font("Monospaced", 40));
        nappi21.setOnAction((t) -> {
            if (!vuoroelementti.getText().equals("Loppu!") && nappi21.getText().equals(" ")) {
                nappi21.setText(vuoro.getVuoro());
                peli.setPaikka(3, vuoro.getVuoro());
                vuoro.setVuoro(seuraavaVuoro(vuoro.getVuoro()));
                vuoroelementti.setText("Vuoro: " + vuoro.getVuoro());
            }
            if (peli.peliOnPaattynyt()) {
                vuoroelementti.setText("Loppu!");
            }
        });
        
        Button nappi22 = new Button(" ");
        nappi22.setFont(Font.font("Monospaced", 40));
        nappi22.setOnAction((t) -> {
            if (!vuoroelementti.getText().equals("Loppu!") && nappi22.getText().equals(" ")) {
                nappi22.setText(vuoro.getVuoro());
                peli.setPaikka(4, vuoro.getVuoro());
                vuoro.setVuoro(seuraavaVuoro(vuoro.getVuoro()));
                vuoroelementti.setText("Vuoro: " + vuoro.getVuoro());
            }
            if (peli.peliOnPaattynyt()) {
                vuoroelementti.setText("Loppu!");
            }
        });
        
        Button nappi23 = new Button(" ");
        nappi23.setFont(Font.font("Monospaced", 40));
        nappi23.setOnAction((t) -> {
            if (!vuoroelementti.getText().equals("Loppu!") && nappi23.getText().equals(" ")) {
                nappi23.setText(vuoro.getVuoro());
                peli.setPaikka(5, vuoro.getVuoro());
                vuoro.setVuoro(seuraavaVuoro(vuoro.getVuoro()));
                vuoroelementti.setText("Vuoro: " + vuoro.getVuoro());
            }
            if (peli.peliOnPaattynyt()) {
                vuoroelementti.setText("Loppu!");
            }
        });
        
        Button nappi31 = new Button(" ");
        nappi31.setFont(Font.font("Monospaced", 40));
        nappi31.setOnAction((t) -> {
            if (!vuoroelementti.getText().equals("Loppu!") && nappi31.getText().equals(" ")) {
                nappi31.setText(vuoro.getVuoro());
                peli.setPaikka(6, vuoro.getVuoro());
                vuoro.setVuoro(seuraavaVuoro(vuoro.getVuoro()));
                vuoroelementti.setText("Vuoro: " + vuoro.getVuoro());
            }
            if (peli.peliOnPaattynyt()) {
                vuoroelementti.setText("Loppu!");
            }
        });
        
        Button nappi32 = new Button(" ");
        nappi32.setFont(Font.font("Monospaced", 40));
        nappi32.setOnAction((t) -> {
            if (!vuoroelementti.getText().equals("Loppu!") && nappi32.getText().equals(" ")) {
                nappi32.setText(vuoro.getVuoro());
                peli.setPaikka(7, vuoro.getVuoro());
                vuoro.setVuoro(seuraavaVuoro(vuoro.getVuoro()));
                vuoroelementti.setText("Vuoro: " + vuoro.getVuoro());
            }
            if (peli.peliOnPaattynyt()) {
                vuoroelementti.setText("Loppu!");
            }
        });
        
        Button nappi33 = new Button(" ");
        nappi33.setFont(Font.font("Monospaced", 40));
        nappi33.setOnAction((t) -> {
            if (!vuoroelementti.getText().equals("Loppu!") && nappi33.getText().equals(" ")) {
                nappi33.setText(vuoro.getVuoro());
                peli.setPaikka(8, vuoro.getVuoro());
                vuoro.setVuoro(seuraavaVuoro(vuoro.getVuoro()));
                vuoroelementti.setText("Vuoro: " + vuoro.getVuoro());
            }
            if (peli.peliOnPaattynyt()) {
                vuoroelementti.setText("Loppu!");
            }
        });
        
        GridPane nappiasettelu = new GridPane();
        nappiasettelu.setPadding(new Insets(10));
        nappiasettelu.setHgap(10);
        nappiasettelu.setVgap(10);
        
        nappiasettelu.addRow(0, nappi11, nappi12, nappi13);
        nappiasettelu.addRow(1, nappi21, nappi22, nappi23);
        nappiasettelu.addRow(2, nappi31, nappi32, nappi33);
        
        BorderPane asettelu = new BorderPane();
        asettelu.setTop(vuoroelementti);
        asettelu.setCenter(nappiasettelu);
        
        Scene nakyma = new Scene(asettelu);
        ikkuna.setScene(nakyma);
        ikkuna.setTitle("Ristinolla");
        ikkuna.show();
    }
    
    private String seuraavaVuoro(String edellinenVuoro){
        if (!edellinenVuoro.equals("X") && !edellinenVuoro.equals("O")) {
            throw new IllegalStateException("Vuorosyötteessä virhe");
        }
        if (edellinenVuoro.equals("X")) {
            return "O";
        }
        return "X";
    }
    
    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(RistinollaSovellus.class);
    }

}
