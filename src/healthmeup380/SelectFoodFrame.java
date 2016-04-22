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
    JLabel result1Label,result2Label,result3Label;
    JPanel panel;
    String food1,food2,food3;    
    String amount1,amount2,amount3;
    int calories1,calories2,calories3;

    
    public SelectFoodFrame(String uName,ResultSet rs) throws SQLException{
        
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Results");
    setSize(700, 300);
    panel = new JPanel(new GridLayout(6,1));
    
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
    
    result1Label = new JLabel(food1+" "+amount1+" "+calories1);
    panel.add(result1Label);
    submit1 = new JButton("Select");
    panel.add(submit1);
    
    result2Label = new JLabel(food2+" "+amount2+" "+calories2);
    panel.add(result2Label);
    submit2 = new JButton("Select");
    panel.add(submit2);
    
    result3Label = new JLabel(food3+" "+amount3+" "+calories3);
    panel.add(result3Label);
    submit3 = new JButton("Select");
    panel.add(submit3);
    
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
    submit1.addActionListener(submit1ButtonListener);
    
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
    submit2.addActionListener(submit2ButtonListener);
    
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
    submit3.addActionListener(submit3ButtonListener);
    
    ActionListener cancelButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
            }
        };
    cancel.addActionListener(cancelButtonListener);

    }
}
