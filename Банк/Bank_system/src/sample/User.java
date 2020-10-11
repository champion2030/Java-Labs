package sample;

public class User{
    public static  String deposit;
    public static String currency;
    public static String password;
    public static String inn;
    public static String login;
    public static int age;
    public static String name;
    public static String surname;
    public static String middle_name;
    public static String ImagePath;
    public static String Card;

    User(String value_name, String value_surname, String value_middle_name, String value_login, String value_password,
         String value_inn, String value_deposit, String value_currency, int value_age, String file_path, String card_number){
        name = value_name;
        surname = value_surname;
        middle_name = value_middle_name;
        login = value_login;
        password = value_password;
        inn = value_inn;
        age = value_age;
        deposit = value_deposit;
        currency = value_currency;
        ImagePath = file_path;
        Card = card_number;
    }

    User(){}
    User(String money){ deposit = money; };

    public String GetName() { return name; }
    public String GetSurname() { return surname; }
    public String GetMiddleName() { return middle_name; }
    public String GetInn() { return inn; }
    public String GetPassword1() { return password; }
    public String GetLogin() { return login; }
    public int GetAge() { return age; }
    public String GetDeposit() { return deposit; }
    public String GetCurrency() { return  currency; }
    public String GetPath(){ return ImagePath; }
    public String GetNumber(){ return Card; }

}
