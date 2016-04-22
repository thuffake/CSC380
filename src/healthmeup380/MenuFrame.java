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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author thomas
 */
public class MenuFrame extends JFrame{
    
    JButton submitFood, showFood, searchFood,logout;
    JLabel submitFoodLabel,welcome;
    public static JLabel caloriesLeft;
    JPanel panel;
    SQLMethod sql = new SQLMethod();
    int calories;

    
    public MenuFrame(String name,String uName){
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu");
        setSize(400, 200);
        panel = new JPanel(new GridLayout(3,1));
        
        try {
           calories= sql.getUserCaloriesLeft(uName);
        } catch (SQLException ex) {
            Logger.getLogger(MenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        welcome = new JLabel("Welcome "+name);
        panel.add(welcome);
        caloriesLeft = new JLabel("You have "+calories+" Calories left");
        panel.add(caloriesLeft);
        showFood = new JButton("Show Food");
        panel.add(showFood);
        searchFood = new JButton("Search Food");
        panel.add(searchFood);
        submitFood = new JButton("Submit Food");
        panel.add(submitFood);
        logout = new JButton("Log Out");
        panel.add(logout);
        
        add(panel,BorderLayout.CENTER);
        
        ActionListener submitFoodButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        SubmitFoodFrame page=new SubmitFoodFrame(uName);
        page.setVisible(true);
            }
        };
    submitFood.addActionListener(submitFoodButtonListener);
    
    ActionListener showFoodButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            SQLMethod sql = new SQLMethod();
            ResultSet rs = sql.getFoodInfo(uName);
            JTable table = new JTable(buildTableModel(rs));
            
            // Closes the Connection

            JOptionPane.showMessageDialog(null, new JScrollPane(table));
        } catch (SQLException ex) {
            Logger.getLogger(MenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            }
        };
    showFood.addActionListener(showFoodButtonListener);
    
    ActionListener searchFoodButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        SearchFoodFrame page=new SearchFoodFrame(uName);
        page.setVisible(true);
            }
        };
    searchFood.addActionListener(searchFoodButtonListener);
    
    ActionListener logoutButtonListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        LoginFrame frame=new LoginFrame();
        frame.setVisible(true);
            }
        };
    logout.addActionListener(logoutButtonListener);
    }
  
    
    
    
    public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

    }
    public static void updateText(String uName){
        int calories=0;
        SQLMethod sql1 = new SQLMethod();

        try {
           calories= sql1.getUserCaloriesLeft(uName);
        } catch (SQLException ex) {
            Logger.getLogger(MenuFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        caloriesLeft.setText("You have "+calories+" Calories left");
    }
    
    public void updateCaloriesLeft(int cal){
        caloriesLeft.setText("You have "+cal+" Calories left");
    }
 }

