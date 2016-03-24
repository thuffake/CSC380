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
    String fName;
    String lName;
    String gender;
    String uName;
    String checkUserName;
    String checkPassword;
    private String password;
    int weight;
    int fHeight;
    int iHeight;
    int age;
    int tdee;
    int weightgoal;
    
    public SQLMethod(){
    }
    
    
    public Boolean userNameExists (String uName)throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        sql = "SELECT * FROM user WHERE userName='"+uName+"'";
        rs = stmt.executeQuery(sql);
            
        while(rs.next()){
        uName=rs.getString("username");
        }
        
        boolean exists=false;
        if(uName==null){
            System.out.println("Username does not exist!");
            exists=false;
            return exists;
        }
        System.out.println("Username already exists!");
        exists=true;
        return exists;
    }
    
    public void createUser() throws SQLException{
        System.out.println("creating user");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        uName=sc.next();
        if(userNameExists(uName)==true){
            return;
        }
        password=sc.next();
        fName=sc.next();
        lName=sc.next();
        gender=sc.next();
        fHeight=sc.nextInt();
        iHeight=sc.nextInt();
        age=sc.nextInt();
        tdee=sc.nextInt();
        weight=sc.nextInt();
        weightgoal=sc.nextInt();

        sql="insert into user (id,fName,lName,weight,weightgoal,tdee,userName,passWord,fHeight,iHeight,age,gender)"
                + "VAlUES (NULL,'"+fName+"','"+lName+"','"+weight+"','"+weightgoal+"','"+tdee+"',"
                + "'"+uName+"','"+password+"','"+fHeight+"','"+iHeight+"','"+age+"','"+gender+"')";
            stmt.executeUpdate(sql);
    }
    
    public void submitFood() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        sql="insert into foodlog (id,userName,food,log,totalCalories) "
                + "VAlUES (NULL,'thuff','Apple','2016-03-09','95')";
            stmt.executeUpdate(sql);
        
    }
    
    public User login ()throws SQLException {
        System.out.println("Enter Username: ");
        checkUserName = sc.next();
        System.out.println("Enter Password: ");
        checkPassword= sc.next();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        sql = "SELECT * FROM user WHERE userName='"+checkUserName+"'";
        rs = stmt.executeQuery(sql);
            
        while(rs.next()){
        fName=rs.getString("fName");
        lName=rs.getString("lName");
        gender=rs.getString("gender");
        uName=rs.getString("username");
        password=rs.getString("passWord");
        fHeight=rs.getInt("fHeight");
        iHeight=rs.getInt("iHeight");
        age=rs.getInt("age");
        tdee=rs.getInt("tdee");
        weight=rs.getInt("weight");
        weightgoal=rs.getInt("weightgoal");
        }
                    
        System.out.println("Welcome, "+fName+"!");
        User u = new User(fName,lName,gender,fHeight,iHeight,age,weight,tdee,weightgoal,uName,password);
        return u;
    }
        
}
