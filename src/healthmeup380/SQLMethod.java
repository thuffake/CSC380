/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthmeup380;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author thomas
 */
public class SQLMethod {
    ResultSet rs;
    Scanner sc = new Scanner(System.in);
    String sql;
    public SQLMethod(){
    }
    
    
    public ResultSet getUser ()throws SQLException {
        System.out.println("Enter name to search: ");
        String name = sc.next();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        sql = "SELECT * FROM user WHERE fName='"+name+"'";
        rs = stmt.executeQuery(sql);
            
        while(rs.next()){
        System.out.println("Name: "+ rs.getString("fName"));
        System.out.println("Weight: "+ rs.getInt("weight"));
        }
        
        return rs;
    }
    
    public void createUser() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        sql="insert into user (id,fName,lName,weight,weightgoal,tdee,userName,passWord)"
                + "VAlUES (NULL,'Bob','Smith','200','160','2500','bob1','bobpassword')";
            stmt.executeUpdate(sql);
    }
    
    public void submitFood() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        sql="insert into foodlog (id,userName,food,log,totalCalories) "
                + "VAlUES (NULL,'thuff','Apple','2016-03-09','95')";
            stmt.executeUpdate(sql);
        
    }
        
}
