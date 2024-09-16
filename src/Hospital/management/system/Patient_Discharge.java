package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Patient_Discharge extends JFrame {
    Patient_Discharge()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(155, 209, 202));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check Out");
        label.setBounds(100,20,150,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.BLUE);
        panel.add(label);

        JLabel label2 = new JLabel("Customer ID");
        label2.setBounds(30,80,100,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.BLUE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try
        {
            LoginData con  = new LoginData();
            ResultSet resultSet = con.statement.executeQuery("select * from patient_info");
            while(resultSet.next())
            {
                choice.add(resultSet.getString("number"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30,130,150,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.BLUE);
        panel.add(label3);

        JLabel RoomNo = new JLabel();
        RoomNo.setBounds(200,130,100,20);
        RoomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        RoomNo.setForeground(Color.BLUE);
        panel.add(RoomNo);

        JLabel label4 = new JLabel("Check In Time");
        label4.setBounds(30,180,150,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.BLUE);
        panel.add(label4);

        JLabel inTime = new JLabel();
        inTime.setBounds(200,180,250,20);
        inTime.setFont(new Font("Tahoma",Font.BOLD,14));
        inTime.setForeground(Color.BLUE);
        panel.add(inTime);

        JLabel outTime = new JLabel("Out Time");
        outTime.setBounds(30,230,100,20);
        outTime.setFont(new Font("Tahoma",Font.BOLD,14));
        outTime.setForeground(Color.BLUE);
        panel.add(outTime);

        Date date = new Date();

        JLabel outTimeShow = new JLabel(""+date);
        outTimeShow.setBounds(200,230,250,20);
        outTimeShow.setFont(new Font("Tahoma",Font.BOLD,14));
        outTimeShow.setForeground(Color.BLUE);
        panel.add(outTimeShow);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30,300,100,30);
        discharge.setBackground(Color.WHITE);
        discharge.setForeground(Color.BLACK);
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginData con = new LoginData();
                try{
                    con.statement.executeUpdate("delete from patient_info where number='"+choice.getSelectedItem()+"'");
                    con.statement.executeUpdate("update Room set Availability ='Available' where room_No='"+RoomNo.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                }catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(170,300,100,30);
        check.setBackground(Color.WHITE);
        check.setForeground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginData con = new LoginData();
                try
                {
                    ResultSet resultSet = con.statement.executeQuery("select * from patient_info where number = '"+choice.getSelectedItem()+"'");
                    while(resultSet.next())
                    {
                        RoomNo.setText(resultSet.getString("Roome_Number"));
                        inTime.setText(resultSet.getString("Time"));
                    }
                }catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(300,300,100,30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setSize(800,400);
        setLayout(null);
        setLocation(400,250);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Patient_Discharge();
    }
}
