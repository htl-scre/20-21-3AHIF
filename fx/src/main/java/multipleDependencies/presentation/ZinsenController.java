package multipleDependencies.presentation;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ZinsenController implements Initializable {

    @FXML
    private Text textEndkapital;

    @FXML
    private TextField textFieldKapital;

    @FXML
    private Slider sliderLaufzeit;

    @FXML
    private ChoiceBox<Integer> choiceBoxZinssatz;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBoxZinssatz.getItems().addAll(1, 2, 3, 4, 5, 6, 7);
        choiceBoxZinssatz.getSelectionModel().selectFirst();
//        textFieldKapital.textProperty().addListener(observable -> updateEndkapital());
//        sliderLaufzeit.valueProperty().addListener(observable -> updateEndkapital());
//        choiceBoxZinssatz.getSelectionModel()
//                .selectedItemProperty()
//                .addListener(observable -> updateEndkapital());
        StringBinding binding = Bindings.createStringBinding(this::getEndkapital,
                textFieldKapital.textProperty(), sliderLaufzeit.valueProperty(), choiceBoxZinssatz.getSelectionModel()
                        .selectedItemProperty());
        textEndkapital.textProperty().bind(binding);
    }

    private String getEndkapital() {
        int startKapital = 0;
        try {
            startKapital = Integer.parseInt(textFieldKapital.getText());
        } catch (NumberFormatException e) {
            textFieldKapital.setText("0");
        }
        int laufzeit = (int) sliderLaufzeit.getValue();
        int zinssatz = choiceBoxZinssatz.getSelectionModel().getSelectedItem();
        int endKapital = (int) (startKapital * Math.pow(1 + zinssatz / 100.0, laufzeit));
        return String.valueOf(endKapital);
    }

    private void updateEndkapital() {
        textEndkapital.setText(String.valueOf(getEndkapital()));
    }
}
