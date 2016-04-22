/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthmeup380;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;
/**
 *
 * @author thomas
 */
public class LoginFrame extends JFrame{
    JButton login,createUser;
    JPanel panel;
    JLabel label1,label2;
    JTextField  text1,text2;
   
  public LoginFrame() {  
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Login");
    setSize(400, 150);
    
    label1 = new JLabel();
    label1.setText("Username:");
    text1 = new JTextField(15);
    
    label2 = new JLabel();
    label2.setText("Password:");
    text2 = new JPasswordField(15);
    
    createUser = new JButton("Create User");
    login = new JButton("Login");
    
    panel = new JPanel(new GridLayout(3,1));
    panel.add(label1);
    panel.add(text1);
    panel.add(label2);
    panel.add(text2);
    panel.add(login);
    panel.add(createUser);
    
    add(panel,BorderLayout.CENTER);
    
    //login.addActionListener(this);
    //createUser.addActionListener(this);
   
    //setTitle("Login Menu");
    
    ActionListener loginButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
	String uName=text1.getText();
        String password=text2.getText();
    SQLMethod sql = new SQLMethod();
        try {
            if(sql.auth(uName, password)== true){
                dispose();
                String fName=sql.getUserFirstName(uName);
                MenuFrame page=new MenuFrame(fName,uName);
                page.setVisible(true);
                //String fName=sql.getUserFirstName(value1);
                //JLabel label = new JLabel("Welcome "+fName);
                //page.getContentPane().add(label);
            }   } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        };
    login.addActionListener(loginButtonListener);
    
    ActionListener createUserButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
	
    SQLMethod sql = new SQLMethod();
        dispose();
        CreateFrame page=new CreateFrame();
        page.setVisible(true);
            }
        };
    createUser.addActionListener(createUserButtonListener);
    
  }
  
  
  

  
//  @Override
//  public void actionPerformed(ActionEvent ae){
//      
//    String value1=text1.getText();
//    String value2=text2.getText();
//    SQLMethod sql = new SQLMethod();
//    
//        try {
//            if(sql.auth(value1, value2)== true){
//                dispose();
//                String fName=sql.getUserFirstName(value1);
//                //MenuFrame page=new MenuFrame(fName);
//                CreateFrame page=new CreateFrame();
//                page.setVisible(true);
//                //String fName=sql.getUserFirstName(value1);
//                //JLabel label = new JLabel("Welcome "+fName);
//                //page.getContentPane().add(label);
//            }   } catch (SQLException ex) {
//            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
//  }
    
}


