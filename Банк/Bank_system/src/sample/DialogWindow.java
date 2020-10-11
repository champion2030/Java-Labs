package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DialogWindow extends Registration_Controller{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label card_number;

    @FXML
    private Button ok_button;

    public void setLabelText(String text){
        card_number.setText(text);
    }

    @FXML
    void initialize() {
        ok_button.setOnAction(actionEvent -> {

            Stage stage_registration = (Stage) ok_button.getScene().getWindow();
            stage_registration.close();
        });

    }
}
