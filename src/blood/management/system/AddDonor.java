package blood.management.system;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

class AddDonor implements ActionListener{
    JFrame f;
    JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1,b2;
    JComboBox c1;
    Random ran = new Random();
    long last4 = (ran.nextLong() % 9000L) +1000L ;
    long last = Math.abs(last4);
    
    
    public AddDonor(){
        f = new JFrame ("Add Donor");
        f.setBackground(Color.white);
        f.setLayout(null);
        
        
        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("blood/management/system/d.jpg"));
        Image i4 = ic4.getImage().getScaledInstance(1605,970,Image.SCALE_DEFAULT);
        ImageIcon  icc4 = new ImageIcon(i4);
        id10 = new JLabel(icc4);
        id10.setSize(1605,895);
        id10.setLayout(null);
        
        id9 = new JLabel("REGISTER NEW DONOR DETAILS");
        id9.setBounds(150,30,800,50);
        id9.setFont(new Font("serif",Font.ITALIC,40));
        id9.setForeground(Color.black);
        id10.add(id9);
        f.add(id10);
        
        id1 = new JLabel("Name :");
        id1.setBounds(210,220,100,30);
        id1.setFont(new Font("serif",Font.BOLD,25));
        id10.add(id1);
        
        t1 = new JTextField();
        t1.setBounds(390,220,250,30);
        id10.add(t1);
        
        id2 = new JLabel("Blood Group :");
        id2.setBounds(210,270,200,30);
        id2.setFont(new Font("serif",Font.BOLD,25));
        id10.add(id2);
        
        
        String group[] = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
        c1 = new JComboBox(group);
        c1.setBackground(Color.white);
        c1.setBounds(390,270,50,30);
        id10.add(c1);
        
        id3 = new JLabel("Contact :");
        id3.setBounds(210,320,150,30);
        id3.setFont(new Font("serif",Font.BOLD,25));
        id10.add(id3);
        
        t3 = new JTextField();
        t3.setBounds(390,320,250,30);
        id10.add(t3);
        
        id4 = new JLabel("Email :");
        id4.setBounds(210,370,150,30);
        id4.setFont(new Font("serif",Font.BOLD,25));
        id10.add(id4);
        
        t4 = new JTextField();
        t4.setBounds(390,370,250,30);
        id10.add(t4);
        
        id5 = new JLabel("Address :");
        id5.setBounds(210,420,150,30);
        id5.setFont(new Font("serif",Font.BOLD,25));
        id10.add(id5);
        
        t5 = new JTextField();
        t5.setBounds(390,420,250,30);
        id10.add(t5);
        
        id6 = new JLabel("Medical Report :");
        id6.setBounds(210,470,200,30);
        id6.setFont(new Font("serif",Font.BOLD,25));
        id10.add(id6);
        
        t6 = new JTextField();
        t6.setBounds(390,470,250,30);
        id10.add(t6);
     
        b1 = new JButton("Submit");
        b1.setBackground(Color.GREEN);
        b1.setForeground(Color.white);
        b1.setFont(new Font("serif",Font.BOLD,25));
        b1.setBounds(410,570,150,40);
        id10.add(b1);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.white);
        b2.setFont(new Font("serif",Font.BOLD,25));
        b2.setBounds(210,570,150,40);
        id10.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(1610,905);
    }
    
    public void actionPerformed(ActionEvent ae){
        String a = t1.getText();
        String b = (String)c1.getSelectedItem();
        String c = t3.getText();
        String d = t4.getText();
        String e = t5.getText();
        String ff = t6.getText();
        if(ae.getSource() == b1){
          try{
              ConnectionClass cc = new ConnectionClass();
              String q = "insert into donor (`name`, `blood_group`, `contact`, `email`, `address`, `medical_report`) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+ff+"')";
              cc.s.executeUpdate(q);
              JOptionPane.showMessageDialog(null,"Donor Details Inserted Successfully");
              f.setVisible(false);
              new Home().setVisible(true);
          }catch(Exception ee){
              System.out.println("The error is:"+ee);
          }  
        }else if(ae.getSource() == b2){
            f.setVisible(false);
            new Home().setVisible(true);
        }
     }
    public static void main(String[] args) {
        new AddDonor().f.setVisible(true);
       
    } 

}
