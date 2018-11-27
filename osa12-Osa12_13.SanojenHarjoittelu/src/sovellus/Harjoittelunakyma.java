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
public class Harjoittelunakyma {
    private Sanakirja sanakirja;
    private String sana;
    
    public Harjoittelunakyma(Sanakirja sanakirja) {
        this.sanakirja = sanakirja;
        this.sana = this.sanakirja.satunnainenSana();
    }
    
    public Parent getNakyma() {
        GridPane asettelu = new GridPane();
        
        Label ohje = new Label("Käännä sana '" + this.sana + "'");
        Label menikoOikein = new Label();
        TextField sanakentta = new TextField();
        Button tarkistusNappi = new Button("Tarkista");
        
        asettelu.add(ohje, 0, 0);
        asettelu.add(sanakentta, 0, 1);
        asettelu.add(tarkistusNappi, 0, 2);
        asettelu.add(menikoOikein, 0, 3);
        
        asettelu.setAlignment(Pos.CENTER);
        asettelu.setHgap(10);
        asettelu.setVgap(10);
        asettelu.setPadding(new Insets(10));
        
        tarkistusNappi.setOnAction((t) -> {
            String kaannos = sanakentta.getText();
            String oikeaKaannos = this.sanakirja.hae(this.sana);
            
            if (oikeaKaannos.equals(kaannos)) {
                menikoOikein.setText("Oikein!");
            } else {
                menikoOikein.setText("Väärin! Sanan '" + this.sana + "' käännös on " + oikeaKaannos);
                return;
            }
            
            sanakentta.clear();
            this.sana = this.sanakirja.satunnainenSana();
            ohje.setText("Käännä sana '" + this.sana + "'");
        });
        
        return asettelu;
    }
}
