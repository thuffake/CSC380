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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author thomas
 */
public class SubmitFoodFrame extends JFrame{
    
    JButton submit, cancel;
    JTextField food,calories;
    JLabel foodLabel,caloriesLabel;
    JPanel panel;
    
    public SubmitFoodFrame(String uName) {
    
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Menu");
    setSize(400, 200);
    panel = new JPanel(new GridLayout(3,1));
    
    foodLabel = new JLabel("Food Name:");
    panel.add(foodLabel);
    food = new JTextField(15);
    panel.add(food);
    
    caloriesLabel = new JLabel("Calories:");
    panel.add(caloriesLabel);
    calories = new JTextField(15);
    panel.add(calories);
    
    submit = new JButton("Submit Food");
    panel.add(submit);
    cancel = new JButton("Cancel");
    panel.add(cancel);
    
    add(panel,BorderLayout.CENTER);
        
    ActionListener submitButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        
    SQLMethod sql = new SQLMethod();
    int caloriesSQL = Integer.parseInt(calories.getText());
    String foodSQL=food.getText();
        try {
            sql.submitFood(uName,foodSQL,caloriesSQL);
            
              } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
            }
        };
    submit.addActionListener(submitButtonListener);
    
    
    ActionListener cancelButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
            }
        };
    cancel.addActionListener(cancelButtonListener);
    }
}
