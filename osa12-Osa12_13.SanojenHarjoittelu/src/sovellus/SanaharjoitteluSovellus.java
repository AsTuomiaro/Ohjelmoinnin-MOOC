package sovellus;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


// END SOLUTION
public class SanaharjoitteluSovellus extends Application {
    private Sanakirja sanakirja;
    
    @Override
    public void init() throws Exception {
        this.sanakirja = new Sanakirja();
    }
    
    @Override
    public void start(Stage ikkuna) throws Exception {
        Harjoittelunakyma harjoittelunakyma = new Harjoittelunakyma(this.sanakirja);
        Syottonakyma syottonakyma = new Syottonakyma(this.sanakirja);
        
        BorderPane asettelu = new BorderPane();
        
        Button lisaaNappi = new Button("Lisää sanoja");
        Button harjoitteleNappi = new Button("Harjoittele");
        
        HBox nappiasettelu = new HBox(lisaaNappi, harjoitteleNappi);
        nappiasettelu.setSpacing(10);
        nappiasettelu.setPadding(new Insets(10));
        
        lisaaNappi.setOnAction((t) -> asettelu.setCenter(syottonakyma.getNakyma()));
        harjoitteleNappi.setOnAction((t) -> asettelu.setCenter(harjoittelunakyma.getNakyma()));
        
        asettelu.setTop(nappiasettelu);
        asettelu.setCenter(syottonakyma.getNakyma());
        
        Scene nakyma = new Scene(asettelu, 400, 300);
        ikkuna.setScene(nakyma);
        ikkuna.setTitle("Kääntäjä");
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(SanaharjoitteluSovellus.class);
    }
}
