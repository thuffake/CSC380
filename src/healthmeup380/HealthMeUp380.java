/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthmeup380;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author thomas
 */
public class HealthMeUp380 {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException{
        
        SQLMethod sql = new SQLMethod();
        Scanner sc = new Scanner(System.in);
        String input = "Text";
        
        try {
        LoginFrame frame=new LoginFrame();
        //frame.setSize(300,100);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
        
       
    }
    
}
