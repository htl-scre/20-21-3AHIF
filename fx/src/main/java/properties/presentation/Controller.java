package properties.presentation;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Text text;

    @FXML
    private Slider slider;

    @FXML
    private TextField textField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textField.textProperty().bindBidirectional(slider.valueProperty(), new StringConverter<Number>() {
            @Override
            public String toString(Number number) {
                return String.format(Locale.ENGLISH, "%.2f", number.doubleValue());
            }

            @Override
            public Number fromString(String s) {
                double oldValue = slider.getValue();
                try {
                    return Double.parseDouble(s);
                } catch(NumberFormatException e) {
                    return oldValue;
                }
            }
        });
    }

    private void bindTextToSlider() {
        text.textProperty().bind(slider.valueProperty().asString("%.2f"));
    }

    private void textFieldToSliderWithListener() {
        textField.textProperty().addListener(observable ->
                updateSlider());
    }

    private void updateSlider() {
        String text = textField.getText();
        try {
            double parsedValue = Double.parseDouble(text);
            slider.setValue(parsedValue);
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Illegal value: " + text);
            alert.showAndWait();
        }
    }

    private void simpleBindings() {
        text.textProperty().bind(textField.textProperty());
        // L abhängig von R

        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                System.out.println(oldValue + ", " + newValue);
            }
        });

        textField.textProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                text.setText(textField.getText());
            }
        });
    }
}
