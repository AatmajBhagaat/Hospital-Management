package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JFrame {
    JButton login;
    WelcomePage()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,1940,1040);
        panel.setBackground(new Color(155, 209, 202));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("WELCOME To Hospital Management System");
        label.setBounds(200,200,1500,100);
        label.setFont(new Font("Tahoma",Font.CENTER_BASELINE,50));
        label.setBackground(new Color(155, 209, 202));
        label.setForeground(new Color(109, 169, 228));
        panel.add(label);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/WelcomeLogo.png"));
        Image image = imageIcon.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label1  = new JLabel(imageIcon1);
        label1.setBounds(580,250,400,400);
        panel.add(label1);


        login = new JButton("Login");
        login.setBounds(640,620,100,30);
        login.setBackground(new Color(5, 105, 107));
        login.setForeground(Color.BLACK);
        login.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(login);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Login();
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(810,620,100,30);
        back.setBackground(new Color(5, 105, 107));
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(1950,1050);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }

    public static void main(String[] args) {
        new WelcomePage();

    }
}
