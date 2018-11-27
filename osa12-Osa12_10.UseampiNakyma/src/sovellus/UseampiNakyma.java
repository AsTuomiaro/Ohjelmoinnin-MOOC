package sovellus;

import com.sun.javafx.scene.control.skin.DatePickerContent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UseampiNakyma extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        
        Label ekaOtsikko = new Label("Eka näkymä!");
        Button ekaNappi = new Button("Tokaan näkymään!");
        BorderPane ekaAsettelu = new BorderPane();
        ekaAsettelu.setTop(ekaOtsikko);
        ekaAsettelu.setCenter(ekaNappi);
        
        Label tokaOtsikko = new Label("Toka näkymä!");
        Button tokaNappi = new Button("Kolmanteen näkymään!");
        VBox tokaAsettelu = new VBox();
        tokaAsettelu.getChildren().add(tokaNappi);
        tokaAsettelu.getChildren().add(tokaOtsikko);
        
        Label kolmasOtsikko = new Label("Kolmas näkymä!");
        Button kolmasNappi = new Button("Ekaan näkymään!");
        GridPane kolmasAsettelu = new GridPane();
        kolmasAsettelu.add(kolmasOtsikko, 0, 0);
        kolmasAsettelu.add(kolmasNappi, 1, 1);
        
        Scene eka = new Scene(ekaAsettelu);
        Scene toka = new Scene(tokaAsettelu);
        Scene kolmas = new Scene(kolmasAsettelu);
        
        ekaNappi.setOnAction((t) -> {
            ikkuna.setScene(toka);
        });
        
        tokaNappi.setOnAction((t) -> {
            ikkuna.setScene(kolmas);
        });
        
        kolmasNappi.setOnAction((t) -> {
            ikkuna.setScene(eka);
        });
        
        ikkuna.setScene(eka);
        ikkuna.setTitle("Näkymäsovellus");
        ikkuna.show();
    }

    
    
    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(UseampiNakyma.class);
    }

}
