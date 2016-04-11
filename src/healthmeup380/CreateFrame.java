/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthmeup380;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author thomas
 */
public class CreateFrame extends JFrame{
    
    JTextField userName,password,fName,lName,weight,weightGoal,fHeight,iHeight,
            age,gender,tdee;
    JLabel userNameLabel,passwordLabel,fNameLabel,lNameLabel,weightLabel,weightGoalLabel,fHeightLabel
            ,iHeightLabel,ageLabel,genderLabel,tdeeLabel,calcTdeeLabel;
    JPanel panel;
    JButton ok,cancel,calcTdee;
    
    
    public CreateFrame(){
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create User");
        setSize(500, 300);
        panel = new JPanel(new GridLayout(14,2));
        
        userNameLabel = new JLabel();
        userNameLabel.setText("Username:");
        userName = new JTextField(15);
        panel.add(userNameLabel);
        panel.add(userName);
        
        passwordLabel = new JLabel();
        passwordLabel.setText("Password:");
        password = new JPasswordField(15);
        panel.add(passwordLabel);
        panel.add(password);
        
        fNameLabel = new JLabel();
        fNameLabel.setText("First Name:");
        fName = new JTextField(15);
        panel.add(fNameLabel);
        panel.add(fName);
    
        lNameLabel = new JLabel();
        lNameLabel.setText("Last Name:");
        lName = new JTextField(15);
        panel.add(lNameLabel);
        panel.add(lName);
        
        weightLabel = new JLabel();
        weightLabel.setText("Weight:");
        weight = new JTextField(15);
        panel.add(weightLabel);
        panel.add(weight);
    
        weightGoalLabel = new JLabel();
        weightGoalLabel.setText("Weight Goal:");
        weightGoal = new JTextField(15);
        panel.add(weightGoalLabel);
        panel.add(weightGoal);
        
        fHeightLabel = new JLabel();
        fHeightLabel.setText("Feet tall:");
        fHeight = new JTextField(15);
        panel.add(fHeightLabel);
        panel.add(fHeight);
    
        iHeightLabel = new JLabel();
        iHeightLabel.setText("Inches Tall:");
        iHeight = new JTextField(15);
        panel.add(iHeightLabel);
        panel.add(iHeight);
        
        ageLabel = new JLabel();
        ageLabel.setText("Age:");
        age = new JTextField(15);
        panel.add(ageLabel);
        panel.add(age);
    
        genderLabel = new JLabel();
        genderLabel.setText("Gender:");
        gender = new JTextField(15);
        panel.add(genderLabel);
        panel.add(gender);
        
        tdeeLabel = new JLabel();
        tdeeLabel.setText("Tdee:");
        tdee = new JTextField(15);
        panel.add(tdeeLabel);
        panel.add(tdee);
        
        calcTdeeLabel = new JLabel();
        calcTdeeLabel.setText("Calculate Tdee");
        panel.add(calcTdeeLabel);        
        
        calcTdee = new JButton("Calculate Tdee");
        ok = new JButton("Ok");
        cancel = new JButton("Cancel");
        panel.add(calcTdee);
        panel.add(ok);
        panel.add(cancel);
   
        add(panel,BorderLayout.CENTER);
        
        ActionListener calcTdeeButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
	
    TdeeCalc calc = new TdeeCalc();
    
    int weightSQL = Integer.parseInt(weight.getText());
    int fHeightSQL = Integer.parseInt(fHeight.getText());
    int iHeightSQL = Integer.parseInt(iHeight.getText());
    int ageSQL = Integer.parseInt(age.getText());
    String genderSQL=gender.getText();
    int tdeeSet=calc.calculate(fHeightSQL,iHeightSQL,weightSQL,ageSQL,genderSQL);
    String aString = Integer.toString(tdeeSet);
    tdee.setText(aString);

    
        //CreateFrame page=new CreateFrame();
        //page.setVisible(true);
            }
        };
    calcTdee.addActionListener(calcTdeeButtonListener);
        
        ActionListener okButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
	String userNameSQL=userName.getText();
        String passwordSQL=password.getText();
        String fNameSQL=fName.getText();
        String lNameSQL=lName.getText();
        int weightSQL = Integer.parseInt(weight.getText());
        int weightGoalSQL = Integer.parseInt(weightGoal.getText());
        int fHeightSQL = Integer.parseInt(fHeight.getText());
        int iHeightSQL = Integer.parseInt(iHeight.getText());
        int ageSQL = Integer.parseInt(age.getText());
        String genderSQL=gender.getText();
        int tdeeSQL = Integer.parseInt(tdee.getText());
        
        //String value1=text1.getText();
        SQLMethod sql = new SQLMethod();
        try {
            sql.createUser(userNameSQL,passwordSQL,fNameSQL,lNameSQL,weightSQL,
                    weightGoalSQL,fHeightSQL,iHeightSQL,ageSQL,genderSQL,tdeeSQL);
              }catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dispose();
        MenuFrame page=new MenuFrame(fNameSQL,userNameSQL);
        page.setVisible(true);
            }
        };
    ok.addActionListener(okButtonListener);
        
    }
  
}
