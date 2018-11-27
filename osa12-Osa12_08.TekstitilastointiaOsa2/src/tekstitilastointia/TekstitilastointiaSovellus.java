package tekstitilastointia;

import java.util.Arrays;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TekstitilastointiaSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        
        Label kirjaimia = new Label("Kirjaimia: 0");
        Label sanoja = new Label("Sanoja: 0");
        Label pisinSanaOn = new Label("Pisin sana on: ");
        
        HBox elementit = new HBox();
        elementit.setSpacing(10);
        elementit.getChildren().addAll(kirjaimia, sanoja, pisinSanaOn);
        
        TextArea tekstikentta = new TextArea();
        tekstikentta.textProperty().addListener(new ChangeListener<String>() {
            
            @Override
            public void changed(ObservableValue<? extends String> ov, String t, String t1) {
                int merkkienMaara = t1.length();
                String[] sanat = t1.split("\\s+");
                int sanojenMaara = sanat.length;
                if (merkkienMaara == 0) {
                    sanojenMaara = 0;
                }
                String pisinSana = Arrays.stream(sanat)
                        .sorted((s1, s2) -> {
                            return s2.length() - s1.length();
                        })
                        .findFirst()
                        .get();
                
                kirjaimia.setText("Kirjaimia: " + merkkienMaara);
                sanoja.setText("Sanoja: " + sanojenMaara);
                pisinSanaOn.setText("Pisin sana on: " + pisinSana);
            }
             
        });
        
        BorderPane asettelu = new BorderPane();
        asettelu.setCenter(tekstikentta);
        asettelu.setBottom(elementit);
        
        Scene nakyma = new Scene(asettelu);
        ikkuna.setScene(nakyma);
        ikkuna.setTitle("Tekstitilastointia II");
        ikkuna.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TekstitilastointiaSovellus.class);
    }

}
