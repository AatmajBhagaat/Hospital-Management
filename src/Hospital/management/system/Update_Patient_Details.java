package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Patient_Details  extends JFrame {

    Update_Patient_Details()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(155, 209, 202));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel labelI = new JLabel(imageIcon1);
        labelI.setBounds(600,200,200,200);
        panel.add(labelI);

        JLabel label = new JLabel("Update Patient Details");
        label.setBounds(124,20,350,20);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.BLUE);
        panel.add(label);

        JLabel label2 = new JLabel("Name:");
        label2.setBounds(25,88,100,20);
        label2.setFont(new Font("Tahoma",Font.PLAIN,14));
        label2.setForeground(Color.BLUE);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,80,150,25);
        panel.add(choice);

        try
        {
            LoginData con  = new LoginData();
            ResultSet resultSet = con.statement.executeQuery("select * from patient_info");
            while(resultSet.next())
            {
                choice.add(resultSet.getString("name"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number:");
        label3.setBounds(25,130,150,20);
        label3.setFont(new Font("Tahoma",Font.PLAIN,14));
        label3.setForeground(Color.BLUE);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,130,140,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("Check In Time:");
        label4.setBounds(25,180,150,20);
        label4.setFont(new Font("Tahoma",Font.PLAIN,14));
        label4.setForeground(Color.BLUE);
        panel.add(label4);

        JTextField textFieldT = new JTextField();
        textFieldT.setBounds(248,180,140,20);
        panel.add(textFieldT);

        JLabel label5 = new JLabel("Amount Paid (Rs):");
        label5.setBounds(25,216,150,20);
        label5.setFont(new Font("Tahoma",Font.PLAIN,14));
        label5.setForeground(Color.BLUE);
        panel.add(label5);

        JTextField textFieldA = new JTextField();
        textFieldA.setBounds(248,216,140,20);
        panel.add(textFieldA);

        JLabel label6 = new JLabel("Pending:");
        label6.setBounds(25,261,150,20);
        label6.setFont(new Font("Tahoma",Font.PLAIN,14));
        label6.setForeground(Color.BLUE);
        panel.add(label6);

        JTextField textFieldP = new JTextField();
        textFieldP.setBounds(248,261,140,20);
        panel.add(textFieldP);

        JButton check = new JButton("Check");
        check.setBounds(281,378,100,30);
        check.setBackground(Color.WHITE);
        check.setForeground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id  = choice.getSelectedItem();
                String q = "select * from patient_info where name ='"+id+"'";
                try
                {
                    LoginData con = new LoginData();
                    ResultSet resultSet = con.statement.executeQuery(q);
                    while(resultSet.next())
                    {
                        textFieldR.setText(resultSet.getString("Roome_Number"));
                        textFieldT.setText(resultSet.getString("Time"));
                        textFieldA.setText(resultSet.getString("Deposit"));
                    }
                    ResultSet resultSet1 = con.statement.executeQuery("select * from room where room_no ='"+textFieldR.getText()+"'");

                    while (resultSet1.next())
                    {
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price)-Integer.parseInt(textFieldA.getText());
                        textFieldP.setText(""+amountPaid);

                    }
                }catch (Exception E)
                {
                    E.printStackTrace();
                }
            }
        });

        JButton Update = new JButton("Update");
        Update.setBounds(56,378,100,30);
        Update.setBackground(Color.WHITE);
        Update.setForeground(Color.BLACK);
        panel.add(Update);
        Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    LoginData con = new LoginData();
                    String q =choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldT.getText();
                    String amount = textFieldA.getText();
                    con.statement.executeUpdate("update patient_info set Roome_Number= '"+room+"',Time='"+time+"',Deposit='"+amount+"'where name ='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }catch (Exception e1)
                {
                    e1.printStackTrace();
                }


            }
        });


        JButton back = new JButton("Back");
        back.setBounds(168,378,100,30);
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setSize(950,500);
        setLayout(null);
        setLocation(400,250);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Update_Patient_Details();
    }
}
