package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {
JTextField textField;
JPasswordField passwordField;
JButton b1,b2;
    Login() {
        JLabel nameLabel = new JLabel("Username");
        nameLabel.setBounds(40,30,100,30);
        nameLabel.setFont(new Font("Tahoma",Font.BOLD,16));
        nameLabel.setForeground(Color.BLACK);
        add(nameLabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        password.setForeground(Color.black);
        add(password);

        textField =new JTextField();
        textField.setBounds(150,20,150,30);
        textField.setFont(new Font("Tahoma",Font.PLAIN,15));
        textField.setBackground(new Color(110, 245, 166));
        textField.setForeground(Color.black);
        add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(150,70,150,30);
        passwordField.setFont(new Font("Tahoma",Font.PLAIN,15));
        passwordField.setBackground(new Color(110, 245, 166));
        passwordField.setForeground(Color.black);
        add(passwordField);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/Main logo.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320,-30,400,300);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setForeground(Color.white);
        b1.setBackground(new Color(5, 105, 107));
        b1.addActionListener(this);
        add(b1);

        b2= new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setForeground(Color.white);
        b2.setBackground(new Color(5, 105, 107));
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(155, 209, 202));

        setSize(750,300);
        setLocation(375,300);
        setLayout(null);
        setVisible(true);

}
public static void main(String []args) {
    new Login();

}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1)
        {
            try{
                LoginData con = new LoginData();
                String user = textField.getText();
                String pass = passwordField.getText();

                String query = "select * from login where ID ='"+user+"' and password='"+pass+"'";
                ResultSet resultSet = con.statement.executeQuery(query);
                if(resultSet.next()){
                    new MainWindow();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid username of Password");
                }
            }catch (Exception E) {
                E.printStackTrace();

            }
        }
        else{
            System.exit(10);
        }
    }
}
