package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class TranslateCash {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label exception_field;

    @FXML
    private TextField card_number_field;

    @FXML
    private Button ok_button;

    @FXML
    private TextField transfer_amount_field;

    public String cash, card;

    public String GetCard(){ return card_number_field.getText(); }
    public String GetMoney(){ return transfer_amount_field.getText(); }
    public void SetHaveMoney(String money, String card_n){
        this.cash = money;
        this.card = card_n;
    }

    public boolean check_money_inn(){
        Connection connection = new Connection();
        if(GetCard().isEmpty()){
            exception_field.setText("ENTER CARD NUMBER");
            return false;
        }
        else if(GetMoney().isEmpty()){
            exception_field.setText("ENTER TRANSLATION CASH");
            return false;
        }
        else if(!connection.GetUserCash(GetCard(), GetMoney(), card)){
            exception_field.setText("DON'T HAVE SUCH USER");
            return false;
        }
        User user = new User(cash);
        double m1 = Double.parseDouble(cash);
        double m2 = Double.parseDouble(GetMoney());
        if (m1 < m2){
            exception_field.setText("YOU DON'T HAVE SUCH MONEY");
            return false;
        }
        return true;
    }

    @FXML
    void initialize() {
        ok_button.setOnAction(actionEvent -> {
            if(check_money_inn()){
                System.out.println("NICE");
            }
        });
    }
}
