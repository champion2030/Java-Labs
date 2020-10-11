package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

public class Registration_Controller {

    @FXML
    private PasswordField password_field2;

    @FXML
    private Button cancel_button;

    @FXML
    private Button finish_button;

    @FXML
    private Slider age_slider;

    @FXML
    private ComboBox<String> gender_box;

    @FXML
    private Label surname_exception;

    @FXML
    private Label age_exception;

    @FXML
    private PasswordField password_field1;

    @FXML
    private TextField middle_name_field;

    @FXML
    private Button choose_photo_button;

    @FXML
    private Label middle_name_exception;

    @FXML
    private Label age_label;

    @FXML
    private ComboBox<String> currency_box;

    @FXML
    private Label inn_exception;

    @FXML
    private ImageView account_photo;

    @FXML
    private Label deposit_exception;

    @FXML
    private TextField login_field;

    @FXML
    private TextField surname_field;

    @FXML
    private TextField Inn_field;

    @FXML
    private Label password_exception;

    @FXML
    private TextField name_field;

    @FXML
    private TextField deposit_field;

    @FXML
    private Label name_exception;

    @FXML
    private Label login_exception;

    public String FilePath, card;

    private void SetGenderItems(){
        ObservableList<String> lang = FXCollections.observableArrayList("Male", "Female");
        gender_box.setItems(lang);
        gender_box.setValue("Male");
    }

    private void SetCurrencyItems(){
        ObservableList<String> money = FXCollections.observableArrayList("USD", "RUB", "UAH");
        currency_box.setItems(money);
        currency_box.setValue("USD");
    }

    private void SetPath(String path){ this.FilePath = path.substring(6); }

    public String GetName() { return name_field.getText().trim(); }
    public String GetSurname() { return surname_field.getText().trim(); }
    public String GetMiddleName() { return middle_name_field.getText().trim(); }
    public String GetInn() { return Inn_field.getText().trim(); }
    public String GetPassword1() { return password_field1.getText().trim();  }
    public String GetPassword2() { return password_field2.getText().trim(); }
    public String GetLogin() { return login_field.getText().trim(); }
    public String GetPol() { return gender_box.getValue().trim(); }
    public int GetAge() { return (int) age_slider.getValue(); }
    public String GetDeposit() { return deposit_field.getText().trim(); }
    public String GetCurrency() { return  currency_box.getValue().trim(); }
    public String GetPath(){ return this.FilePath; }
    public String GetNumber(){ return card = create_card_number(); }


    private boolean check_passwords() {
        if(GetPassword1().isEmpty() && GetPassword2().isEmpty()) {
            password_exception.setText("You didn't enter anything");
            return false;
        }
        else if(!GetPassword1().equals(GetPassword2())) {
            password_exception.setText("Password mismatch");
            return false;
        }
        else { password_exception.setText(""); }
        return true;
    }

    private boolean check_name() {
        if(GetName().isEmpty() && name_exception.getText().equals("")) {
            name_exception.setText("INPUT NAME");
            return false;
        }
        else if(GetName().isEmpty() && !name_exception.getText().equals("")) {
            name_exception.setText("INPUT NAME");
            return false;
        }
        else if(!GetName().isEmpty() && !name_exception.getText().equals("")) { name_exception.setText(""); }
        return true;
    }

    private boolean check_surname() {
        if(GetSurname().isEmpty() && surname_exception.getText().equals("")) {
            surname_exception.setText("INPUT SURNAME");
            return false;
        }
        else if(GetSurname().isEmpty() && !surname_exception.getText().equals("")) {
            surname_exception.setText("INPUT SURNAME");
            return false;
        }
        else if(!GetSurname().isEmpty() && !surname_exception.getText().equals("")) { surname_exception.setText(""); }
        return true;
    }

    private boolean check_middle_name() {
        if(GetMiddleName().isEmpty() && middle_name_exception.getText().equals("")) {
            middle_name_exception.setText("INPUT MIDDLE NAME");
            return false;
        }
        else if(GetMiddleName().isEmpty() && !middle_name_exception.getText().equals("")) {
            middle_name_exception.setText("INPUT MIDDLE NAME");
            return false;
        }
        else if(!GetMiddleName().isEmpty() && !middle_name_exception.getText().equals("")) { middle_name_exception.setText(""); }
        return true;
    }

    private boolean check_inn() {
        if(GetInn().isEmpty()) {
            inn_exception.setText("You didn't enter inn");
            return false;
        }
        else if(isNumeric(GetInn())) {
            inn_exception.setText("Only numbers, please");
            return false;
        }
        else if(GetInn().length() < 12 || GetInn().length() > 12) {
            inn_exception.setText("Length of inn is 12 symbols");
            return false;
        }
        else if(GetInn().length() < 12 || GetInn().length() > 12) {
            inn_exception.setText("Length of inn must be 12 symbols");
            return false;
        }
        else if(!GetInn().isEmpty()) { inn_exception.setText(""); }

        return true;
    }

    private void account_photo() {
        if(account_photo.getImage() == null) {
            SetPath("D:/Второй курс/Программирование на Java/Банк/Bank_system/empty_photo.jpg");
            File file1 = new File("D:/Второй курс/Программирование на Java/Банк/Bank_system/empty_photo.jpg");
            Image image = new Image(file1.toURI().toString());
            account_photo.setImage(image);
        }
    }

    private void FileOpen() throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("JPG","*.jpg"),
                new FileChooser.ExtensionFilter("JPEG","*.jpeg")
        );
        fileChooser.setTitle("Choose file...");
        Window window = null;
        File file = fileChooser.showOpenDialog(null);

        if(file != null) {
            SetPath(file.toURI().toString());
            Image image = new Image(file.toURI().toString());
            account_photo.setImage(image);
        }
    }

    private boolean check_age() {
        if(GetAge() < 18) {
            age_exception.setText("You must be more then 18 years old");
            return false;
        }
        else{ age_exception.setText(""); }
        return true;
    }

    private boolean check_deposit() {
        if(GetDeposit().equals("")) {
            deposit_exception.setText("Enter your deposit");
            return false;
        }
        else if(isNumeric(GetDeposit())) {
            deposit_exception.setText("Enter only numbers");
            return false;
        }
        else { deposit_exception.setText(""); }
        return true;
    }

    private boolean check_login() {
        if(GetLogin().isEmpty() && login_exception.getText().equals("")) {
            login_exception.setText("INPUT LOGIN");
            return false;
        }
        else if(GetLogin().isEmpty() && !login_exception.getText().equals("")) {
            login_exception.setText("INPUT LOGIN");
            return false;
        }
        else if(!GetLogin().isEmpty() && !login_exception.getText().equals("")) { login_exception.setText(""); }
        return true;
    }

    public static boolean isNumeric(String str) {
        try {
            new BigInteger(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public String create_card_number(){
        Random rand = new Random();
        long accumulator = 1 + rand.nextInt(9);
        for(int i = 0; i < 15; i++) {
            accumulator *= 10L;
            accumulator += rand.nextInt(10);
        }
        return String.valueOf(accumulator);
    }

    private class FinishAction implements EventHandler {
        @Override
        public void handle(Event event) {
            account_photo();
            check_name();
            check_surname();
            check_middle_name();
            check_passwords();
            check_inn();
            check_age();
            check_deposit();
            check_login();
            if (check_name() && check_surname() && check_middle_name() && check_passwords() && check_inn() && check_age() && check_deposit() && check_login()){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/sample/cardnumber.fxml"));
                Connection connect = new Connection();
                try {
                    connect.SignUpUser(GetName(), GetSurname(), GetMiddleName(), GetLogin(), GetPassword1(), GetInn(), GetAge(), GetPol(), GetPath(), Double.parseDouble(GetDeposit()), GetCurrency(), GetNumber());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root = fxmlLoader.getRoot();
                DialogWindow dialogWindow = fxmlLoader.getController();
                dialogWindow.setLabelText(card);
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("Card Number");
                File file = new File("D:/Второй курс/Программирование на Java/Банк/Bank_system/icon.png");
                stage.getIcons().addAll(new Image(file.toURI().toString()));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setResizable(false);
                stage.showAndWait();
                Stage stage_registration = (Stage) finish_button.getScene().getWindow();
                stage_registration.close();
            }
        }
    }

    private class OpenAction implements EventHandler {
        @Override
        public void handle(Event event) {
            try {
                FileOpen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private class CancelAction implements EventHandler {
        @Override
        public void handle(Event event) {
            cancel_button.getScene().getWindow().hide();
        }
    }

    @FXML
    void initialize() {

        age_slider.setMinorTickCount(4);
        age_slider.setSnapToTicks(true);
        age_slider.valueProperty().addListener(new ChangeListener<Number>(){
            public void changed(ObservableValue<? extends Number> changed, Number oldValue, Number newValue){
                age_label.setText("Your age is "+ newValue);
            }
        });
        SetGenderItems();
        SetCurrencyItems();
        finish_button.setOnAction((new FinishAction()));
        choose_photo_button.setOnAction(new OpenAction());
        cancel_button.setOnAction(new CancelAction());
    }
}
