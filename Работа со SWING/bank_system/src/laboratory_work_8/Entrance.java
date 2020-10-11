package laboratory_work_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Entrance {
    public JTextField field1;
    public JPasswordField field2;
    public JLabel login_exception, password_exception;
    private boolean start;

    public Entrance(){
        JFrame jFrame = getFrame();
        JPanel jPanel = new JPanel();
        jFrame.add(jPanel);
        Container contentPane = jFrame.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        JLabel label1 = new JLabel("Enter login:");
        field1 = new JTextField(15);
        login_exception = new JLabel();
        JLabel label2 = new JLabel("Enter password:");
        field2 = new JPasswordField(15);
        field2.setEchoChar('*');
        password_exception = new JLabel();

        contentPane.add(label1);contentPane.add(login_exception);
        contentPane.add(field1);contentPane.add(password_exception);
        contentPane.add(label2);
        contentPane.add(field2);
        layout.putConstraint(SpringLayout.WEST, label1, 90, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, label1, 50, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.NORTH, field1, 50, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, field1, 40, SpringLayout.EAST, label1);
        layout.putConstraint(SpringLayout.NORTH, login_exception, 50, SpringLayout.NORTH, contentPane);
        layout.putConstraint(SpringLayout.WEST, login_exception, 5, SpringLayout.EAST, field1);

        layout.putConstraint(SpringLayout.WEST, label2, 90, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, label2, 25, SpringLayout.NORTH, label1);
        layout.putConstraint(SpringLayout.NORTH, field2, 25, SpringLayout.NORTH, field1);
        layout.putConstraint(SpringLayout.WEST, field2, 11, SpringLayout.EAST, label2);
        layout.putConstraint(SpringLayout.NORTH, password_exception, 25, SpringLayout.NORTH, login_exception);
        layout.putConstraint(SpringLayout.WEST, password_exception, 5, SpringLayout.EAST, field2);

        JButton jButton1 = new JButton("Enter");
        jPanel.add(jButton1);
        JButton jButton2 = new JButton("Registration");
        jPanel.add(jButton2);

        contentPane.add(jButton1);
        contentPane.add(jButton2);

        layout.putConstraint(SpringLayout.WEST, jButton1, 130, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, jButton1, 35, SpringLayout.NORTH, label2);
        layout.putConstraint(SpringLayout.NORTH, jButton2, 35, SpringLayout.NORTH, field2);
        layout.putConstraint(SpringLayout.WEST, jButton2, 40, SpringLayout.EAST, jButton1);

        jButton1.addActionListener(new EnterAction());

        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Registration registration = new Registration();
                } catch (Exception el) {
                    el.printStackTrace();
                }

            }
        });
        jPanel.revalidate();
    }

    private String GetLogin() {
        return field1.getText();
    }

    private char[] GetPassword(){
        return field2.getPassword();
    }

    private class EnterAction implements ActionListener {
        public void actionPerformed(ActionEvent event){
            boolean res = false, in = false, d;
            try {
                res = check_login();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                if(res) {
                    in = check_password();
                    if(in){
                        enter_system();
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean check_login() throws ClassNotFoundException {
        if(GetLogin().isEmpty() && login_exception.getText().equals("")) {
            login_exception.setText("INPUT LOGIN");
            login_exception.setForeground(Color.red);
            return false;
        }
        else if(!login_validation()){
            login_exception.setText("WRONG LOGIN");
            login_exception.setForeground(Color.red);
            return false;
        }
        else if(!GetLogin().isEmpty() && !login_exception.getText().equals("")) { login_exception.setText(""); }
        return true;
    }

    public boolean check_password() throws ClassNotFoundException {
        if(GetPassword().length == 0 && password_exception.getText().equals("")) {
            password_exception.setText("INPUT PASSWORD");
            password_exception.setForeground(Color.red);
            return false;
        }
        else if(!password_validation()){
            password_exception.setText("WRONG PASSWORD");
            password_exception.setForeground(Color.red);
            return false;
        }
        else if(GetPassword().length != 0 && !password_exception.getText().equals("")) { password_exception.setText(""); }
        return true;
    }

    private void enter_system(){
        System.out.println("Nice");
    }

    private boolean login_validation() throws ClassNotFoundException {
        String userName = "root";
        String password = "School123";
        String connectionURL = "jdbc:mysql://localhost:3306/employees";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Login FROM persons WHERE Login = ?");
            preparedStatement.setString(1, GetLogin());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String log = resultSet.getString("Login");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean password_validation() throws ClassNotFoundException {
        String userName = "root";
        String password = "School123";
        String connectionURL = "jdbc:mysql://localhost:3306/employees";
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (Connection connection = DriverManager.getConnection(connectionURL, userName, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Password FROM persons WHERE Login = ?");
            preparedStatement.setString(1, GetLogin());
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String pass = resultSet.getString("Password");
                if(pass.equals(String.copyValueOf(GetPassword()))){ return true; }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean isStart(){ return this.start; }

    private static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width / 2 - 250, dimension.height / 2 - 200, 500, 300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Приват24");
        Image img = new ImageIcon("Логотип.jpg").getImage();
        jFrame.setIconImage(img);
        jFrame.setVisible(true);
        return jFrame;
    }

}