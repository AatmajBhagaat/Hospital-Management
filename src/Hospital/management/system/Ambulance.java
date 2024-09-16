package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance extends JFrame {
    Ambulance()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(155, 209, 202));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,70,980,400);
        table.setBackground(new Color(155, 209, 202));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);
        try
        {
            LoginData con = new LoginData();
            String q = "select * from Ambulance";
            ResultSet resultSet = con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        JLabel label = new JLabel("Name");
        label.setBounds(10,40,100,20);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label);

        JLabel label1 = new JLabel("Gender");
        label1.setBounds(190,40,100,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label5 = new JLabel("Vehicle");
        label5.setBounds(340,40,100,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(505,40,100,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Location");
        label3.setBounds(665,40,100,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Number");
        label4.setBounds(840,40,100,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JButton back = new JButton("Back");
        back.setBounds(100,480,100,30);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,14));
        back.setForeground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(1000,600);
        setLocation(350,250);
        setUndecorated(true);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ambulance();
    }
}
