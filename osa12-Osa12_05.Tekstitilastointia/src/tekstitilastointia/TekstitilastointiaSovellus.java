package tekstitilastointia;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class TekstitilastointiaSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        
        BorderPane asettelu = new BorderPane();
        
        HBox elementit = new HBox();
        elementit.setSpacing(10);
        elementit.getChildren().add(new Label("Kirjaimia: 0"));
        elementit.getChildren().add(new Label("Sanoja: 0"));
        elementit.getChildren().add(new Label("Pisin sana on: "));
        
        TextArea tekstikentta = new TextArea("Täällä voisi lukea jotain...");
        
        asettelu.setCenter(tekstikentta);
        asettelu.setBottom(elementit);
        
        Scene nakyma = new Scene(asettelu);
        ikkuna.setScene(nakyma);
        ikkuna.setTitle("Sovellus");
        ikkuna.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(TekstitilastointiaSovellus.class);
    }

}
