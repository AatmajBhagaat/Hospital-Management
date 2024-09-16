package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class PatientEntry extends JFrame implements ActionListener {
    JComboBox comboBox;
    JTextField textFieldNumber, textFieldName, textFieldDisease, textFieldDeposit;
    JRadioButton r1,r2;
    JButton b1,b2;
    Choice c1;

    JLabel date;
    PatientEntry()
    {
        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(155, 209, 202));
        panel.setLayout(null);
        add(panel);

      ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,100,200,200);
        panel.add(label);
        JLabel labelName = new JLabel("NEW PATIENT FORM");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("Tahoma",Font.BOLD,15));
        labelID.setForeground(Color.BLUE);
        panel.add(labelID);

        comboBox = new JComboBox(new String []{"Adhar Card","Voter ID","Driving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setForeground(Color.white);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number:");
        labelNumber.setBounds(35,111 ,200,14);
        labelNumber.setForeground(Color.BLUE);
        labelNumber.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(271,111,150,20);
        panel.add(textFieldNumber);

        JLabel labelNamePatient = new JLabel("Name:");
        labelNamePatient.setBounds(35,151,200,14);
        labelNamePatient.setForeground(Color.BLUE);
        labelNamePatient.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelNamePatient);

        textFieldName = new JTextField();
        textFieldName.setBounds(271,151,150,20);
        panel.add(textFieldName);

        JLabel labelGender = new JLabel("Gender:");
        labelGender.setBounds(35,191,200,14);
        labelGender.setForeground(Color.BLUE);
        labelGender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.BOLD,14));
        r1.setForeground(Color.BLUE);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(271,191,80,15);
        panel.add(r1);

        r2= new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.BOLD,14));
        r2.setForeground(Color.BLUE);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(350,191,80,15);
        panel.add(r2);

        JLabel labelDisease = new JLabel("Disease:");
        labelDisease.setBounds(35,231 ,200,14);
        labelDisease.setForeground(Color.BLUE);
        labelDisease.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(271,231,150,20);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room:");
        labelRoom.setBounds(35,271,200,14);
        labelRoom.setForeground(Color.BLUE);
        labelRoom.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelRoom);

        c1 = new Choice();
        try
        {
            LoginData c = new LoginData();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while(resultSet.next())
            {
                c1.add(resultSet.getString("room_No"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel labelTime= new JLabel("Time:");
        labelTime.setBounds(35,311,200,14);
        labelTime.setForeground(Color.BLUE);
        labelTime.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelTime);

        Date date1 = new Date();
        date= new JLabel(""+date1);
        date.setBounds(271,311,250,14);
        date.setForeground(Color.BLUE);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);

        JLabel labelDeposit = new JLabel("Deposit:");
        labelDeposit.setBounds(35,351 ,200,17);
        labelDeposit.setForeground(Color.BLUE);
        labelDeposit.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(271,351,150,20);
        panel.add(textFieldDeposit);


        b1 = new JButton("ADD");
        b1.setBounds(100,430,120,30);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(260,430,120,30);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(300,250);
        setVisible(true);

    }

    public static void main(String[] args) {
        new PatientEntry();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(e.getSource()==b1)
    {
        LoginData con = new LoginData();
        String radioBTN = null;
        if(r1.isSelected()) {
            radioBTN = "Male";
        }
        else if(r2.isSelected()){
            radioBTN="Female";
        }

        String s1=(String)comboBox.getSelectedItem();
        String s2 = textFieldNumber.getText();
        String s3 = textFieldName.getText();
        String s4 = radioBTN;
        String s5 = textFieldDisease.getText();
        String s6 = c1.getSelectedItem();
        String s7 = date.getText();
        String s8 = textFieldDeposit.getText();

        try{
            String q = "insert into patient_info values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
            String q1 = "update Room set Availability = 'Occupied' where room_no = "+s6;
            con.statement.executeUpdate(q);
            con.statement.executeUpdate(q1);
            JOptionPane.showMessageDialog(null,"Added Successfully");
            setVisible(false);
        }catch (Exception E)
        {
            E.printStackTrace();
        }

    } else
        {
            setVisible(false);
        }
    }
}
