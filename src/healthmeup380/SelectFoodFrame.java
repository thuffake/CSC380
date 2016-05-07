/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthmeup380;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author thomas
 */
public class SelectFoodFrame extends JFrame{
    JButton submit1,submit2,submit3,cancel;
    JTextField search;
    JLabel result1Label,result2Label,result3Label,emptyLabel;
    JPanel panel;
    String food1,food2,food3;    
    String amount1,amount2,amount3;
    int calories1,calories2,calories3;

    
    public SelectFoodFrame(String uName,ResultSet rs) throws SQLException{
        
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Results");
    setSize(700, 300);
    panel = new JPanel(new GridLayout(0,2));
    
    int i = 0;
    while(rs.next()){
        if(i==0){
            food1=rs.getString("food");
            amount1=rs.getString("amount");
            calories1=rs.getInt("calories");
        }
        if(i==1){
            food2=rs.getString("food");
            amount2=rs.getString("amount");
            calories2=rs.getInt("calories");
        }
        if(i==2){
            food3=rs.getString("food");
            amount3=rs.getString("amount");
            calories3=rs.getInt("calories");
        }
        i++;
    }
    
    try {
            
        if(food1 != null && !uName.isEmpty()){
            //action performed
            result1Label = new JLabel("<html>"+food1+"<br> Amount: "+amount1+
                    "<br> Calories:"+calories1+"</html>");
            panel.add(result1Label);
            submit1 = new JButton("Select");
            panel.add(submit1);
        }
        
        if(food2 != null && !uName.isEmpty()){
            //action performed
            result2Label = new JLabel("<html>"+food2+"<br> Amount: "+amount2+
                    "<br> Calories:"+calories2+"</html>");
            panel.add(result2Label);
            submit2 = new JButton("Select");
            panel.add(submit2);
        }
        
        if(food3 != null && !uName.isEmpty()){
            //action performed
            result3Label = new JLabel("<html>"+food3+"<br> Amount: "+amount3+
                    "<br> Calories:"+calories3+"</html>");
            panel.add(result3Label);
            submit3 = new JButton("Select");
            panel.add(submit3);
        }
        } catch (NullPointerException ex) {
            
        }
//    result1Label = new JLabel(food1+" "+amount1+" "+calories1);
//    panel.add(result1Label);
//    submit1 = new JButton("Select");
//    panel.add(submit1);
    
//    result2Label = new JLabel(food2+" "+amount2+" "+calories2);
//    panel.add(result2Label);
//    submit2 = new JButton("Select");
//    panel.add(submit2);
//    
//    result3Label = new JLabel(food3+" "+amount3+" "+calories3);
//    panel.add(result3Label);
//    submit3 = new JButton("Select");
//    panel.add(submit3);

    emptyLabel= new JLabel("");
    panel.add(emptyLabel);
    
    cancel = new JButton("Cancel");
    panel.add(cancel);
    
    
    
    add(panel,BorderLayout.CENTER);
    
    SQLMethod sql = new SQLMethod();
    
    ActionListener submit1ButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sql.submitFood(uName, food1, calories1);
        } catch (SQLException ex) {
            Logger.getLogger(SelectFoodFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
            }
        };
    
    try {
            
        if(food1 != null && !uName.isEmpty()){
            //action performed
            submit1.addActionListener(submit1ButtonListener);
        }
        } catch (NullPointerException ex) {
            
        }
//    submit1.addActionListener(submit1ButtonListener);
    
    ActionListener submit2ButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sql.submitFood(uName, food2, calories2);
        } catch (SQLException ex) {
            Logger.getLogger(SelectFoodFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
            }
        };
    try {
            
        if(food1 != null && !uName.isEmpty()){
            //action performed
            submit2.addActionListener(submit2ButtonListener);
        }
        } catch (NullPointerException ex) {
            
        }
//    submit2.addActionListener(submit2ButtonListener);
    
    ActionListener submit3ButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            sql.submitFood(uName, food3, calories3);
        } catch (SQLException ex) {
            Logger.getLogger(SelectFoodFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
            }
        };
    try {
            
        if(food3 != null && !uName.isEmpty()){
            //action performed
            submit3.addActionListener(submit3ButtonListener);
        }
        } catch (NullPointerException ex) {
            
        }
//    submit3.addActionListener(submit3ButtonListener);
    
    ActionListener cancelButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
            }
        };
    cancel.addActionListener(cancelButtonListener);

    }
}
