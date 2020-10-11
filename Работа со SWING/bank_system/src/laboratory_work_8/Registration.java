package laboratory_work_8;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.*;

public class Registration extends JDialog {

    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();
    private JTextField name_enter, surname_enter, middle_name_enter, inn_enter, money_enter, login_enter;
    private JPasswordField password1_enter;
    private JPasswordField password2_enter;
    private JComboBox pol_enter;
    private JSlider jSlider;
    private JComboBox currency_enter;
    private JLabel see_photo, name_exception, surname_exception, middle_name_exception, passwords_exception, inn_exception, age_exception, money_exception, login_exception;
    private String path;

    public Registration() { initComponents(); }

    public void initComponents() {
        jFrame.add(jPanel);
        Container contentPane = jFrame.getContentPane();

        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        JLabel name = new JLabel("Enter your name:");
        name_enter = new JTextField(15);
        name_exception = new JLabel();
        JLabel surname = new JLabel("Enter your surname:");
        surname_enter = new JTextField(15);
        surname_exception = new JLabel();
        JLabel middle_name = new JLabel("Enter your middle name:");
        middle_name_enter = new JTextField(15);
        middle_name_exception = new JLabel();
        JLabel login = new JLabel("Enter your login:");
        login_enter = new JTextField(15);
        login_exception = new JLabel();
        JLabel password1 = new JLabel("Enter your password:");
        password1_enter = new JPasswordField(15);
        password1_enter.setEchoChar('*');
        JLabel password2 = new JLabel("Repeat your password:");
        password2_enter = new JPasswordField(15);
        password2_enter.setEchoChar('*');
        passwords_exception = new JLabel();
        JLabel take_photo = new JLabel("Choose photo ");
        JButton photo = new JButton("Open");
        see_photo = new JLabel();
        photo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Icon icon =  FileOpen();
                    Border etched = BorderFactory.createEtchedBorder();
                    Border titled = BorderFactory.createTitledBorder(etched, "Profile photo");
                    see_photo.setIcon(icon);
                    see_photo.setBorder(titled);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });
        JLabel inn = new JLabel("Enter your INN:");
        inn_enter = new JTextField(15);
        inn_exception = new JLabel();
        JLabel pol = new JLabel("Select gender:");
        String courses[] = { "Male", "Female"};
        pol_enter = new JComboBox(courses);

        JLabel age = new JLabel("Enter your age:");
        jSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        jSlider.setMinorTickSpacing(10);
        jSlider.setMajorTickSpacing(20);
        jSlider.setPaintTicks(true);
        jSlider.setPaintLabels(true);
        final JTextField text = new JTextField(3);
        jSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                text.setText("" + jSlider.getValue());
            }
        });
        age_exception = new JLabel();
        JLabel money = new JLabel("Enter your deposit:");
        money_enter = new JTextField(15);
        money_exception = new JLabel();
        JLabel valuta = new JLabel("Select currency:");
        String currency[] = { "USD", "RUB", "UAH"};
        currency_enter = new JComboBox(currency);

        JButton ok = new JButton("Ok");
        ok.setPreferredSize(new Dimension(100,40));
        ok.addActionListener(new OkAction());
        JButton cancel = new JButton("Cancel");
        cancel.setPreferredSize(new Dimension(100,40));

        contentPane.add(name);contentPane.add(surname);contentPane.add(name_exception);
        contentPane.add(password1);contentPane.add(surname_enter);contentPane.add(surname_exception);
        contentPane.add(password2);contentPane.add(middle_name);contentPane.add(middle_name_exception);
        contentPane.add(name_enter);contentPane.add(middle_name_enter);
        contentPane.add(password1_enter);contentPane.add(inn_exception);
        contentPane.add(password2_enter);contentPane.add(passwords_exception);
        contentPane.add(take_photo);contentPane.add(photo);contentPane.add(see_photo);
        contentPane.add(inn);contentPane.add(inn_enter);contentPane.add(age_exception);
        contentPane.add(pol);contentPane.add(pol_enter);contentPane.add(money_exception);
        contentPane.add(age);contentPane.add(jSlider);contentPane.add(text);
        contentPane.add(money);contentPane.add(money_enter);
        contentPane.add(currency_enter);contentPane.add(valuta);contentPane.add(login);
        contentPane.add(ok);contentPane.add(cancel);contentPane.add(login_enter);contentPane.add(login_exception);

        //Имя Фамилия Отчество
        layout.putConstraint(SpringLayout.WEST, name, 50, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, name, 50, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, name_enter, 50, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, name_enter, 65, SpringLayout.EAST, name);

        layout.putConstraint(SpringLayout.NORTH, name_exception, 50, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, name_exception, 10, SpringLayout.EAST, name_enter);

        layout.putConstraint(SpringLayout.WEST, surname, 50, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, surname, 25, SpringLayout.NORTH, name);
        layout.putConstraint(SpringLayout.NORTH, surname_enter, 25, SpringLayout.NORTH, name_enter);
        layout.putConstraint(SpringLayout.WEST, surname_enter, 47, SpringLayout.EAST, surname);

        layout.putConstraint(SpringLayout.NORTH, surname_exception, 25, SpringLayout.NORTH, name_exception);
        layout.putConstraint(SpringLayout.WEST, surname_exception, 10, SpringLayout.EAST, surname_enter);

        layout.putConstraint(SpringLayout.WEST, middle_name, 50, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, middle_name, 25, SpringLayout.NORTH, surname);
        layout.putConstraint(SpringLayout.NORTH, middle_name_enter, 25, SpringLayout.NORTH, surname_enter);
        layout.putConstraint(SpringLayout.WEST, middle_name_enter, 25, SpringLayout.EAST, middle_name);

        layout.putConstraint(SpringLayout.NORTH, middle_name_exception, 25, SpringLayout.NORTH, surname_exception);
        layout.putConstraint(SpringLayout.WEST, middle_name_exception, 10, SpringLayout.EAST, middle_name_enter);
        //Логин
        layout.putConstraint(SpringLayout.WEST, login, 50, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, login, 25, SpringLayout.NORTH, middle_name);
        layout.putConstraint(SpringLayout.NORTH, login_enter, 25, SpringLayout.NORTH, middle_name_enter);
        layout.putConstraint(SpringLayout.WEST, login_enter, 70, SpringLayout.EAST, login);

        layout.putConstraint(SpringLayout.NORTH, login_exception, 25, SpringLayout.NORTH, middle_name_exception);
        layout.putConstraint(SpringLayout.WEST, login_exception, 10, SpringLayout.EAST, login_enter);
        //Два пароля и ИНН
        layout.putConstraint(SpringLayout.WEST, password1, 140, SpringLayout.EAST, name_enter);
        layout.putConstraint(SpringLayout.NORTH, password1, 50, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, password1_enter, 50, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, password1_enter, 21, SpringLayout.EAST, password1);

        layout.putConstraint(SpringLayout.WEST, password2, 140, SpringLayout.EAST, surname_enter);
        layout.putConstraint(SpringLayout.NORTH, password2, 25, SpringLayout.NORTH, password1);
        layout.putConstraint(SpringLayout.NORTH, password2_enter, 25, SpringLayout.NORTH, password1_enter);
        layout.putConstraint(SpringLayout.WEST, password2_enter, 11, SpringLayout.EAST, password2);

        layout.putConstraint(SpringLayout.WEST, inn, 140, SpringLayout.EAST, middle_name_enter);
        layout.putConstraint(SpringLayout.NORTH, inn, 25, SpringLayout.NORTH, password2);
        layout.putConstraint(SpringLayout.NORTH, inn_enter, 25, SpringLayout.NORTH, password2_enter);
        layout.putConstraint(SpringLayout.WEST, inn_enter, 58, SpringLayout.EAST, inn);

        layout.putConstraint(SpringLayout.WEST, inn_exception, 10, SpringLayout.EAST, inn_enter);
        layout.putConstraint(SpringLayout.NORTH, inn_exception, 25, SpringLayout.NORTH, password2_enter);

        layout.putConstraint(SpringLayout.WEST, passwords_exception, 10, SpringLayout.EAST, password1_enter);
        layout.putConstraint(SpringLayout.NORTH, passwords_exception, 65, SpringLayout.NORTH, contentPane);
        //Загрузка фотографии
        layout.putConstraint(SpringLayout.WEST, take_photo, 50, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, take_photo, 38, SpringLayout.NORTH, login);
        layout.putConstraint(SpringLayout.NORTH, photo, 35, SpringLayout.NORTH, login_enter);
        layout.putConstraint(SpringLayout.WEST, photo, 80, SpringLayout.EAST, take_photo);

        layout.putConstraint(SpringLayout.WEST, see_photo, 450, SpringLayout.WEST, photo);
        layout.putConstraint(SpringLayout.NORTH, see_photo, 30, SpringLayout.NORTH, login_enter);
        //Ввод пола
        layout.putConstraint(SpringLayout.WEST, pol, 50, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, pol, 44, SpringLayout.NORTH, take_photo);
        layout.putConstraint(SpringLayout.NORTH, pol_enter, 40, SpringLayout.NORTH, photo);
        layout.putConstraint(SpringLayout.WEST, pol_enter, 80, SpringLayout.EAST, pol);
        //Выбор возраста
        layout.putConstraint(SpringLayout.WEST, age, 50, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, age, 50, SpringLayout.NORTH, pol);
        layout.putConstraint(SpringLayout.WEST, jSlider, 75, SpringLayout.EAST, age);
        layout.putConstraint(SpringLayout.NORTH, jSlider, 34, SpringLayout.NORTH, pol);
        layout.putConstraint(SpringLayout.WEST, text, 295, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, text, 50, SpringLayout.NORTH, jSlider);

        layout.putConstraint(SpringLayout.WEST, age_exception, 20, SpringLayout.EAST, jSlider);
        layout.putConstraint(SpringLayout.NORTH, age_exception, 44, SpringLayout.NORTH, pol);
        //Вводи кол-ва денег на счёте и валюты
        layout.putConstraint(SpringLayout.WEST, money, 50, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, money, 50, SpringLayout.NORTH, text);
        layout.putConstraint(SpringLayout.NORTH, money_enter, 50, SpringLayout.NORTH, text);
        layout.putConstraint(SpringLayout.WEST, money_enter, 55, SpringLayout.EAST, money);

        layout.putConstraint(SpringLayout.NORTH, money_enter, 50, SpringLayout.NORTH, text);
        layout.putConstraint(SpringLayout.WEST, money_enter, 55, SpringLayout.EAST, money);

        layout.putConstraint(SpringLayout.WEST, valuta, 10, SpringLayout.EAST, money_enter);
        layout.putConstraint(SpringLayout.NORTH, valuta, 50, SpringLayout.NORTH, text);
        layout.putConstraint(SpringLayout.NORTH, currency_enter, 48, SpringLayout.NORTH, text);
        layout.putConstraint(SpringLayout.WEST, currency_enter, 25, SpringLayout.EAST, valuta);

        layout.putConstraint(SpringLayout.WEST, money_exception, 235, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, money_exception, 24, SpringLayout.NORTH, money_enter);
        //Кнопки Ok и Cancel
        layout.putConstraint(SpringLayout.WEST, ok, 500, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, ok, 70, SpringLayout.NORTH, currency_enter);
        layout.putConstraint(SpringLayout.NORTH, cancel, 70, SpringLayout.NORTH, currency_enter);
        layout.putConstraint(SpringLayout.WEST, cancel, 50, SpringLayout.EAST, ok);
    }

    private Icon FileOpen() throws IOException {
        FileDialog fileDialog =  new FileDialog(this, "Open file", FileDialog.LOAD);
        fileDialog.setFile("*.gif;*.jpg");
        fileDialog.show();
        String CurrentFilename = fileDialog.getDirectory() + fileDialog.getFile();
        SetPath(CurrentFilename);
        JLabel label = new JLabel();
        label.setSize(100, 100);
        Image image = ImageIO.read(new File(CurrentFilename));
        return new ImageIcon(image.getScaledInstance(100, 100, Image.SCALE_DEFAULT));
    }

    private class OkAction implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            boolean res;
            check_name();
            check_surname();
            check_middle_name();
            res = check_passwords(password1_enter, password2_enter);
            check_login();
            check_inn();
            account_photo();
            check_age();
            check_deposit();
            if (check_name() && check_surname() && check_middle_name() && res && check_inn() && check_age() && check_deposit() && check_login()){
                try {
                    set_person();
                } catch (ClassNotFoundException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String GetName() { return name_enter.getText(); }
    public String GetSurname() { return surname_enter.getText(); }
    public String GetMiddleName() { return middle_name_enter.getText(); }
    public String GetInn() { return inn_enter.getText(); }
    public char[] GetPassword1() { return password1_enter.getPassword(); }
    public String GetLogin() { return login_enter.getText(); }
    public String GetPol() { return (String) pol_enter.getSelectedItem(); }
    public int GetAge() { return jSlider.getValue(); }
    public String GetDeposit() { return money_enter.getText(); }
    public String GetCurrency() { return (String) currency_enter.getSelectedItem(); }

    private boolean check_passwords(JPasswordField password1, JPasswordField password2) {
        String first = String.valueOf(password1.getPassword());
        String second = String.valueOf(password2.getPassword());
        if(first.isEmpty() && second.isEmpty()) {
            passwords_exception.setText("You didn't enter anything");
            passwords_exception.setForeground(Color.red);
            return false;
        }
        else if(!first.equals(second)) {
            passwords_exception.setText("Password mismatch");
            passwords_exception.setForeground(Color.red);
            return false;
        }
        else {
            passwords_exception.setText("");
        }
        return true;
    }

    private boolean check_name() {
        if(GetName().isEmpty() && name_exception.getText().equals("")) {
            name_exception.setText("INPUT NAME");
            name_exception.setForeground(Color.red);
            return false;
        }
        else if(!GetName().isEmpty() && name_exception.getText().equals("INPUT NAME")) { name_exception.setText(""); }
        return true;
    }

    private boolean check_surname() {
        if(GetSurname().isEmpty() && surname_exception.getText().equals("")) {
            surname_exception.setText("INPUT SURNAME");
            surname_exception.setForeground(Color.red);
            return false;
        }
        else if(!GetSurname().isEmpty() && surname_exception.getText().equals("INPUT SURNAME")) { surname_exception.setText(""); }
        return true;
    }

    private boolean check_middle_name() {
        if(GetMiddleName().isEmpty() && middle_name_exception.getText().equals("")) {
            middle_name_exception.setText("INPUT MIDDLE NAME");
            middle_name_exception.setForeground(Color.red);
            return false;
        }
        else if(!GetMiddleName().isEmpty() && middle_name_exception.getText().equals("INPUT MIDDLE NAME")) { middle_name_exception.setText(""); }
        return true;
    }

    private boolean check_inn() {
        if(GetInn().isEmpty()) {
            inn_exception.setText("You didn't enter inn");
            inn_exception.setForeground(Color.red);
            return false;
        }
        else if(isNumeric(GetInn())) {
            inn_exception.setText("Only numbers, please");
            inn_exception.setForeground(Color.red);
            return false;
        }
        else if(GetInn().length() < 12 || GetInn().length() > 12) {
            inn_exception.setText("Length of inn is 12 symbols");
            inn_exception.setForeground(Color.red);
            return false;
        }
        else if(GetInn().length() < 12 || GetInn().length() > 12) {
            inn_exception.setText("Length of inn must be 12 symbols");
            inn_exception.setForeground(Color.red);
            return false;
        }
        else if(!GetInn().isEmpty()) {
            inn_exception.setText("");
        }
        return true;
    }

    private void account_photo() {
        if(see_photo.getIcon() == null) {
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("empty_photo.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
            SetPath("empty_photo.jpg");
            see_photo.setIcon(imageIcon);
            Border etched = BorderFactory.createEtchedBorder();
            Border titled = BorderFactory.createTitledBorder(etched, "Profile photo");
            see_photo.setIcon(imageIcon);
            see_photo.setBorder(titled);
        }
    }

    private boolean check_age() {
        if(GetAge() < 18) {
            age_exception.setText("You must be more then 18 years old");
            age_exception.setForeground(Color.red);
            return false;
        }
        else{
            age_exception.setText("");
        }
        return true;
    }

    private boolean check_deposit() {
        if(GetDeposit().equals("")) {
            money_exception.setText("Enter your deposit");
            money_exception.setForeground(Color.red);
            return false;
        }
        else if(isNumeric(GetDeposit())) {
            money_exception.setText("Enter only numbers");
            money_exception.setForeground(Color.red);
            return false;
        }
        else {
            money_exception.setText("");
        }
        return true;
    }

    private boolean check_login() {
        if(GetLogin().isEmpty() && login_exception.getText().equals("")) {
            login_exception.setText("INPUT LOGIN");
            login_exception.setForeground(Color.red);
            return false;
        }
        else if(!GetLogin().isEmpty() && login_exception.getText().equals("INPUT LOGIN")) { login_exception.setText(""); }
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

    private void SetPath(String FilePath) { this.path = FilePath; }

    private String GetFilePath() { return this.path; }

    private void set_person() throws ClassNotFoundException, NoSuchMethodException {
        String userName = "root";
        String password = "School123";
        String connectionURL = "jdbc:mysql://localhost:3306/employees";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             Statement statement = connection.createStatement()){
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Persons " +
                    "(id MEDIUMINT not null AUTO_INCREMENT, Name VARCHAR (30) not null , Surname VARCHAR (30) not null, " +
                    "MiddleName VARCHAR (30) not null, Login VARCHAR (30) not null , Password VARCHAR (30) not null, INN VARCHAR (30) not null," +
                    "Gender VARCHAR (30) not null, Age INT DEFAULT 18, Deposit DOUBLE, Currency VARCHAR (30) not null, " +
                    "ImgPath VARCHAR (50) not null, PRIMARY KEY (id));");
            String sql = "INSERT INTO Persons (Name , Surname, MiddleName, Login, Password, INN, Gender, Age, Deposit, Currency, ImgPath) Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, GetName());
            preparedStatement.setString(2, GetSurname());
            preparedStatement.setString(3, GetMiddleName());
            preparedStatement.setString(4, GetLogin());
            preparedStatement.setString(5, String.copyValueOf(GetPassword1()));
            preparedStatement.setString(6, GetInn());
            preparedStatement.setString(7, GetPol());
            preparedStatement.setInt(8, GetAge());
            preparedStatement.setDouble(9, Double.parseDouble(GetDeposit()));
            preparedStatement.setString(10, GetCurrency());
            preparedStatement.setString(11, GetFilePath());
            preparedStatement.executeUpdate();
            System.out.println("We are connected");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 500, dimension.height / 2 - 350, 1050, 500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Приват24");
        Image img = new ImageIcon("Логотип.jpg").getImage();
        jFrame.setIconImage(img);
        jFrame.setVisible(true);
        return jFrame;
    }
}
