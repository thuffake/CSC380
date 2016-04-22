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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author thomas
 */
public class SearchFoodFrame extends JFrame{
    JButton submit, cancel;
    JTextField search;
    JLabel searchLabel;
    JPanel panel;
    
    public SearchFoodFrame(String userName) {
        
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Search Food");
    setSize(400, 200);
    panel = new JPanel(new GridLayout(3,1));
    
    searchLabel = new JLabel("Search Food:");
    panel.add(searchLabel);
    search = new JTextField(15);
    panel.add(search);
    
    submit = new JButton("Search");
    panel.add(submit);
    cancel = new JButton("Done");
    panel.add(cancel);
    
    add(panel,BorderLayout.CENTER);
    
    ActionListener submitButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        SQLMethod sql = new SQLMethod();
        String searchSQL=search.getText();
        try {
            ResultSet rs=sql.searchFood(searchSQL);
            SelectFoodFrame page=new SelectFoodFrame(userName,rs);
            page.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SearchFoodFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        };
    submit.addActionListener(submitButtonListener);
    
    ActionListener cancelButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        MenuFrame.updateText(userName);
        dispose();
            }
        };
    cancel.addActionListener(cancelButtonListener);
}
   
}
