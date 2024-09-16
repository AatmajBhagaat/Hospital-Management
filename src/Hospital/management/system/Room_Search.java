package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room_Search extends JFrame {
    Choice choice;
    JTable table;
    Room_Search()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,590);
        panel.setBackground(new Color(155, 209, 202));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Search for Room");
        label.setBounds(250,11,186,30);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.BLUE);
        panel.add(label);

        JLabel label1 = new JLabel("States");
        label1.setBounds(60,70,100,20);
        label1.setFont(new Font("Tahoma",Font.PLAIN,14));
        label1.setForeground(Color.BLUE);
        panel.add(label1);

        choice = new Choice();
        choice.setBounds(170,70,120,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,150,700,350);
        table.setBackground(new Color(155, 209, 202));
        panel.add(table);

        try{
            LoginData con = new LoginData();
            String q = "select * from room";
            ResultSet resultSet = con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label5 = new JLabel("Room No");
        label5.setBounds(5,150,80,50);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(180,150,80,50);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Prize");
        label3.setBounds(355,150,80,50);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(530,150,80,50);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JButton search = new JButton("Search");
        search.setBounds(100,500,120,30);
        search.setForeground(Color.BLACK);
        search.setBackground(Color.WHITE);
        panel.add(search);
        search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q= "select * from Room where Availability ='"+choice.getSelectedItem()+"'";
                try{
                    LoginData con = new LoginData();
                    ResultSet resultSet = con.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }catch (Exception E)
                {
                    E.printStackTrace();
                }

            }
        });


        JButton back = new JButton("Back");
        back.setBounds(300,500,120,30);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(700,600);
        setLayout(null);
        setLocation(400,250);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room_Search();
    }
}
