package sovellukseni;

import javafx.application.Application;
import javafx.stage.Stage;


public class Sovellukseni extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        ikkuna.setTitle("Sovellukseni");
        ikkuna.show();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        launch(Sovellukseni.class);
    }

}
