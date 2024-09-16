package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {

    JTable table;
    Room()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(155, 209, 202));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/roomm.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel labelI = new JLabel(imageIcon1);
        labelI.setBounds(600,200,200,200);
        panel.add(labelI);

        table = new JTable();
        table.setBounds(10,80,500,400);
        table.setBackground(new Color(155, 209, 202));
        panel.add(table);

        try
        {
            LoginData con = new LoginData();
            String q = "select * from Room";
            ResultSet resultSet = con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        JLabel label1 = new JLabel("Room No");
        label1.setBounds(15,40,80,50);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(145,57,80,15);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Prize");
        label3.setBounds(290,40,80,50);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Bed Type");
        label4.setBounds(400,57,80,15);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JButton back = new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setForeground(Color.BLACK);
        back.setBackground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900,600);
        setLayout(null);
        setLocation(300,230);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Room();

    }
}
