package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField password_field;

    @FXML
    private TextField login_field;

    @FXML
    private Label Error_field;

    @FXML
    private Button RegistrationButton;

    @FXML
    private Button ComeInButton;

    private String GetPassword() { return password_field.getText().trim(); }
    private String GetLogin() { return login_field.getText().trim(); }



    @FXML
    void initialize() {
        RegistrationButton.setOnAction(event ->{
            RegistrationButton.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/sample/registration.fxml"));
            try { fxmlLoader.load(); } catch (IOException e) { e.printStackTrace(); }

            Parent root = fxmlLoader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Registration");
            File file = new File("D:/Второй курс/Программирование на Java/Банк/Bank_system/icon.png");
            stage.getIcons().addAll(new Image(file.toURI().toString()));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.showAndWait();
        });
        ComeInButton.setOnAction(event->{
            Connection connection = new Connection();
            if(connection.getUser(GetLogin(), GetPassword())){
                if(!Error_field.getText().isEmpty()){
                    Error_field.setText("");
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/sample/personalarea.fxml"));
                    try { fxmlLoader.load(); } catch (IOException e) { e.printStackTrace(); }

                    Parent root = fxmlLoader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Account");
                    File file = new File("D:/Второй курс/Программирование на Java/Банк/Bank_system/icon.png");
                    stage.getIcons().addAll(new Image(file.toURI().toString()));
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setResizable(false);
                    stage.showAndWait();
                }
                else if(Error_field.getText().isEmpty()){
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("/sample/personalarea.fxml"));
                    try { fxmlLoader.load(); } catch (IOException e) { e.printStackTrace(); }

                    Parent root = fxmlLoader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.setTitle("Account");
                    File file = new File("D:/Второй курс/Программирование на Java/Банк/Bank_system/icon.png");
                    stage.getIcons().addAll(new Image(file.toURI().toString()));
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setResizable(false);
                    stage.showAndWait();
                }

            }else { Error_field.setText("Incorrect password and/or login"); }
        });
    }

}

