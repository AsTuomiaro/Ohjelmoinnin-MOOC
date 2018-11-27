package sovellus;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaastolaskuriSovellus extends Application {

    @Override
    public void start(Stage ikkuna) throws Exception {
        BorderPane asettelu = new BorderPane();
        VBox valikko = new VBox();
        valikko.setSpacing(30);
        valikko.setPadding(new Insets(20));

        BorderPane sliderasettelu1 = new BorderPane();
        BorderPane sliderasettelu2 = new BorderPane();

        Label sliderArvo1 = new Label("25.0");
        Label sliderArvo2 = new Label("0.0");

        Slider slider1 = new Slider(25, 250, 25);
        slider1.setShowTickLabels(true);
        slider1.setShowTickMarks(true);
        slider1.setMajorTickUnit(25);
        slider1.setBlockIncrement(15);

        Slider slider2 = new Slider(0, 10, 0);
        slider2.setShowTickLabels(true);
        slider2.setMajorTickUnit(10);
        slider2.setMinorTickCount(2);
        slider2.setShowTickMarks(true);
        slider2.setBlockIncrement(3);

        sliderasettelu1.setCenter(slider1);
        sliderasettelu1.setRight(sliderArvo1);
        sliderasettelu1.setLeft(new Label("Kuukausittainen tallennus"));

        sliderasettelu2.setCenter(slider2);
        sliderasettelu2.setRight(sliderArvo2);
        sliderasettelu2.setLeft(new Label("Vuosittainen korko"));

        LineChart<Number, Number> kaavio = new LineChart<>(new NumberAxis(0, 30, 1), new NumberAxis());
        kaavio.setTitle("Säästölaskuri");
        kaavio.setLegendVisible(false);

        XYChart.Series<Number, Number> data1 = new XYChart.Series<>();
        XYChart.Series<Number, Number> data2 = new XYChart.Series<>();

        for (int i = 0; i <= 30; i++) {
            data1.getData().add(new XYChart.Data<>(i, 12 * i * 25));
        }

        kaavio.getData().add(data1);
        kaavio.getData().add(data2);

        slider1.setOnMouseReleased((t) -> {
            double vanhaArvo = 0;
            double talletus = slider1.valueProperty().getValue();
            double korko = slider2.valueProperty().getValue();
            sliderArvo1.setText(String.format("%.1f", talletus));

            data1.getData().clear();
            data2.getData().clear();
            data2.getData().add(new XYChart.Data<>(0, 0));

            for (int i = 0; i < 30; i++) {
                vanhaArvo = (12 * talletus + vanhaArvo) * (1.0 + korko / 100);
                data1.getData().add(new XYChart.Data<>(i, 12 * i * talletus));
                data2.getData().add(new XYChart.Data<>(i + 1, vanhaArvo));
            }

            data1.getData().add(new XYChart.Data<>(30, 12 * 30 * talletus));
        });

        slider2.setOnMouseReleased((t) -> {
            double vanhaArvo = 0;
            double talletus = slider1.valueProperty().getValue();
            double korko = slider2.valueProperty().getValue();
            sliderArvo2.setText(String.format("%.1f", korko));

            data2.getData().clear();
            data2.getData().add(new XYChart.Data<>(0, 0));

            for (int i = 1; i <= 30; i++) {
                vanhaArvo = (12 * talletus + vanhaArvo) * (1.0 + korko / 100);
                data2.getData().add(new XYChart.Data<>(i, vanhaArvo));
            }
        });

        valikko.getChildren().add(sliderasettelu1);
        valikko.getChildren().add(sliderasettelu2);
        asettelu.setTop(valikko);
        asettelu.setCenter(kaavio);

        Scene nakyma = new Scene(asettelu, 640, 480);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }

    public static void main(String[] args) {
        launch(SaastolaskuriSovellus.class);
    }
}
