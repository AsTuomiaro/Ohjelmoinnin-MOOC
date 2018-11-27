/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sovellus;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author asko
 */
public class Syottonakyma {
    private Sanakirja sanakirja;
    
    public Syottonakyma(Sanakirja sanakirja) {
        this.sanakirja = sanakirja;
    }
    
    public Parent getNakyma() {
        GridPane asettelu = new GridPane();
        
        Label ohje1 = new Label("Sana");
        Label ohje2 = new Label("Käännös");
        
        TextField sanakentta = new TextField();
        TextField kaannoskentta = new TextField();
        
        Button lisaaNappi = new Button("Lisää sanapari");
        
        asettelu.add(ohje1, 0, 0);
        asettelu.add(sanakentta, 0, 1);
        asettelu.add(ohje2, 0, 2);
        asettelu.add(kaannoskentta, 0, 3);
        asettelu.add(lisaaNappi, 0, 4);
        
        asettelu.setAlignment(Pos.CENTER);
        asettelu.setVgap(10);
        asettelu.setHgap(10);
        asettelu.setPadding(new Insets(10));
        
        lisaaNappi.setOnAction((t) -> {
            String sana = sanakentta.getText();
            String kaannos = kaannoskentta.getText();
            this.sanakirja.lisaa(sana, kaannos);
            
            sanakentta.clear();
            kaannoskentta.clear();
        });
        
        return asettelu;
    }
}
