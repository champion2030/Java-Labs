package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Account {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label currency_field;

    @FXML
    private Button exit_button;

    @FXML
    private Label password_field;

    @FXML
    private Label login_field;

    @FXML
    private ImageView account_photo;

    @FXML
    private Label card_number_field;

    @FXML
    private Button get_cash_button;

    @FXML
    private Label deposit_field;

    @FXML
    private Label name_surname_middle;

    @FXML
    private Label age_field;

    @FXML
    private Label inn_field;

    @FXML
    void initialize() {
        User user = new User();
        name_surname_middle.setText(user.GetName()+" "+user.GetSurname()+" "+user.GetMiddleName());
        age_field.setText(String.valueOf(user.GetAge()));
        deposit_field.setText(user.GetDeposit());
        inn_field.setText(user.GetInn());
        login_field.setText(user.GetLogin());
        password_field.setText(user.GetPassword1());
        currency_field.setText(user.GetCurrency());
        card_number_field.setText(user.GetNumber());
        File file1 = new File(user.GetPath());
        Image image = new Image(file1.toURI().toString());
        account_photo.setImage(image);
        exit_button.setOnAction(actionEvent -> {
            Stage stage_registration = (Stage) exit_button.getScene().getWindow();
            stage_registration.close();
        });

        get_cash_button.setOnAction(actionEvent -> {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/sample/translationwindow.fxml"));
            try { fxmlLoader.load(); } catch (IOException e) { e.printStackTrace(); }

            Parent root = fxmlLoader.getRoot();
            TranslateCash translateCash = fxmlLoader.getController();
            translateCash.SetHaveMoney(deposit_field.getText(), card_number_field.getText());
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Translate Cash");
            File file = new File("D:/Второй курс/Программирование на Java/Банк/Bank_system/icon.png");
            stage.getIcons().addAll(new Image(file.toURI().toString()));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.showAndWait();
        });
    }
}
