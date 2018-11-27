package otsikko;

import javafx.application.Application;
import javafx.application.Application.Parameters;
import javafx.stage.Stage;


public class KayttajanOtsikko extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        Parameters parametrit = getParameters();
        String otsikko = parametrit.getNamed().get("otsikko");
        
        ikkuna.setTitle(otsikko);
        ikkuna.show();
    }

}
