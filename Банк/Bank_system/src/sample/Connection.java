package sample;

import java.sql.*;

public class Connection extends Consts{

    public void SignUpUser(String name, String surname, String middle_name, String login, String user_password, String inn,
                           int age, String gender, String image_path, double deposit, String currency, String CardNumber) throws ClassNotFoundException {
        try (java.sql.Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             Statement statement = connection.createStatement()){
            statement.executeUpdate("DROP TABLE Persons");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Persons " +
                    "(id MEDIUMINT not null AUTO_INCREMENT, Name VARCHAR (30) not null , Surname VARCHAR (30) not null, " +
                    "MiddleName VARCHAR (30) not null, Login VARCHAR (30) not null , Password VARCHAR (30) not null, INN VARCHAR (30) not null," +
                    "Gender VARCHAR (30) not null, Age INT DEFAULT 18, Deposit DOUBLE, Currency VARCHAR (30) not null, " +
                    "ImgPath VARCHAR (100) not null, CardNumber VARCHAR (16) not null, PRIMARY KEY (id));");
            String sql = "INSERT INTO Persons (Name , Surname, MiddleName, Login, Password, INN, Gender, Age, Deposit, Currency, ImgPath, CardNumber) Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, middle_name);
            preparedStatement.setString(4, login);
            preparedStatement.setString(5, user_password);
            preparedStatement.setString(6, inn);
            preparedStatement.setString(7, gender);
            preparedStatement.setInt(8, age);
            preparedStatement.setDouble(9, deposit);
            preparedStatement.setString(10, currency);
            preparedStatement.setString(11, image_path);
            preparedStatement.setString(12, CardNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public boolean getUser(String person_login, String person_password){
        try (java.sql.Connection connection = DriverManager.getConnection(connectionURL, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Name, Surname, MiddleName, Login, Password, INN, Age, Deposit, Currency, ImgPath, CardNumber FROM persons WHERE Login = ? AND Password = ?");
            preparedStatement.setString(1, person_login);
            preparedStatement.setString(2, person_password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String name = resultSet.getString("Name");
                String surname = resultSet.getString("Surname");
                String middle_name = resultSet.getString("MiddleName");
                String pass = resultSet.getString("Password");
                String log = resultSet.getString("Login");
                String inn = resultSet.getString("INN");
                int age = resultSet.getInt("Age");
                String deposit = resultSet.getString("Deposit");
                String currency = resultSet.getString("Currency");
                String image_path = resultSet.getString("ImgPath");
                String card = resultSet.getString("CardNumber");
                User user = new User(name, surname, middle_name, log, pass, inn, deposit, currency, age, image_path, card);
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean GetUserCash(String person_card, String person_money, String messenger_cash){
        try (java.sql.Connection connection = DriverManager.getConnection(connectionURL, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT CardNumber, Deposit FROM persons WHERE CardNumber = ?");
            preparedStatement.setString(1, person_card);
            ResultSet resultSet = preparedStatement.executeQuery();
            int q = 0;
            while(resultSet.next()) {
                q = 1;
            }
            if (q == 1) {
                PreparedStatement preparedStatement1 = connection.prepareStatement("UPDATE Persons SET Deposit = Deposit + ? WHERE CardNumber = ?");
                preparedStatement1.setDouble(1, Double.parseDouble(person_money));
                preparedStatement1.setString(2, person_card);
                preparedStatement1.executeUpdate();
                PreparedStatement preparedStatement2 = connection.prepareStatement("UPDATE Persons SET Deposit = Deposit - ? WHERE CardNumber = ?");
                preparedStatement2.setDouble(1, Double.parseDouble(person_money));
                preparedStatement2.setString(2, messenger_cash);
                preparedStatement2.executeUpdate();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
