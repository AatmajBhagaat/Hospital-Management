package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainWindow extends JFrame {
    public MainWindow(){
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,160,1525,700);
        panel.setBackground(new Color(155, 209, 202));
        add(panel);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(null);
        topPanel.setBounds(5,5,1525,150);
        topPanel.setBackground(new Color(107, 162, 171));
        add(topPanel);

       JButton b1 = new JButton("Add New Patient");
        b1.setBounds(30,10,200,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.setBackground(new Color(155, 209, 202));
        topPanel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PatientEntry();
            }
        });

        JButton b2 = new JButton("Room");
        b2.setBounds(240,10,200,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(new Color(155, 209, 202));
        topPanel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new Room();

            }
        });
        JButton b3 = new JButton("Department");
        b3.setBounds(450,10,200,30);
        b3.setFont(new Font("serif",Font.BOLD,15));
        b3.setBackground(new Color(155, 209, 202));
        topPanel.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });
        JButton b4 = new JButton("All Employee Info");
        b4.setBounds(660,10,200,30);
        b4.setFont(new Font("serif",Font.BOLD,15));
        b4.setBackground(new Color(155, 209, 202));
        topPanel.add(b4);
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }
        });
        JButton b5 = new JButton("Patient Info");
        b5.setBounds(870,10,200,30);
        b5.setFont(new Font("serif",Font.BOLD,15));
        b5.setBackground(new Color(155, 209, 202));
        topPanel.add(b5);
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_info();
            }
        });
        JButton b6 = new JButton("Patient Discharge");
        b6.setBounds(30,50,200,30);
        b6.setFont(new Font("serif",Font.BOLD,15));
        b6.setBackground(new Color(155, 209, 202));
        topPanel.add(b6);
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new Patient_Discharge();
            }
        });
        JButton b7 = new JButton("Update Patient Details");
        b7.setBounds(240,50,200,30);
        b7.setFont(new Font("serif",Font.BOLD,15));
        b7.setBackground(new Color(155, 209, 202));
        topPanel.add(b7);
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update_Patient_Details();
            }
        });
        JButton b8 = new JButton("Search Room");
        b8.setBounds(450,50,200,30);
        b8.setFont(new Font("serif",Font.BOLD,15));
        b8.setBackground(new Color(155, 209, 202));
        topPanel.add(b8);
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room_Search();
            }
        });
        JButton b9 = new JButton("Hospital Ambulance");
        b9.setBounds(660,50,200,30);
        b9.setFont(new Font("serif",Font.BOLD,15));
        b9.setBackground(new Color(155, 209, 202));
        topPanel.add(b9);
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Ambulance();
            }
        });
        JButton b10= new JButton("Logout");
        b10.setBounds(1080,10,200,30);
        b10.setFont(new Font("serif",Font.BOLD,15));
        b10.setBackground(new Color(155, 209, 202));
        topPanel.add(b10);
        b10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/dr.png"));
        Image image = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i2= new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1300,0,250,250);
        topPanel.add(label);

        ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Icon/amb.png"));
        Image image1= i3.getImage().getScaledInstance(300,100,Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(image1);
        JLabel label1 = new JLabel(i4);
        label1.setBounds(1000,50,300,100);
        topPanel.add(label1);


        setSize(1950,1090);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public static void main(String [] args)
    {
        new MainWindow();
    }
}
