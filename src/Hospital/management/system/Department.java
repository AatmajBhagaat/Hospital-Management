package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {

    Department()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(155, 209, 202));
        add(panel);

        JTable table = new JTable();
        table.setBounds(20,70,500,350);
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        table.setBackground(new Color(155, 209, 202));
        panel.add(table);

        JLabel label1 = new JLabel("Department");
        label1.setBounds(25,35,200,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Phone Numbers");
        label2.setBounds(275,35,200,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);



        try
        {
            LoginData con = new LoginData();
            String q = "select * from department";
           ResultSet resultSet =con.statement.executeQuery(q);
           table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        JButton back = new JButton("Back");
        back.setBounds(100,420,100,30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setLayout(null);
        setLocation(350,250);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
