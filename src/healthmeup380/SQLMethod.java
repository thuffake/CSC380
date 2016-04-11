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
    
    
    public Boolean userNameExists ()throws SQLException {
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
    
    public void createUser(String uName,String password,String fName,
            String lName,int weight,int weightGoal, int fHeight,
            int iHeight,int age,String gender,int tdee) throws SQLException{
        //System.out.println("creating user");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();

        sql="insert into user (id,fName,lName,weight,weightgoal,tdee,userName,passWord,fHeight,iHeight,age,gender)"
                + "VAlUES (NULL,'"+fName+"','"+lName+"','"+weight+"','"+weightGoal+"','"+tdee+"',"
                + "'"+uName+"','"+password+"','"+fHeight+"','"+iHeight+"','"+age+"','"+gender+"')";
            stmt.executeUpdate(sql);
    }
    
    //maybe change this method to require a username DONE
    public void submitFood(String uName,String food,int calories) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        //System.out.println("Name of food?");
        //String food = sc.next();
        //System.out.println("How many calories?");
        //String calorie=sc.next();
        CurrentDate CDate = new CurrentDate();
        String date = CDate.getDate();
        //String CUsername = uName;
        sql="insert into foodlog (id,userName,food,log,totalCalories) "
                + "VAlUES (NULL,'"+uName+"','"+food+"','"+date+"','"+calories+"')";
            stmt.executeUpdate(sql);
        
    }
    
    public Boolean auth (String AuthUserName, String AuthPassword)throws SQLException {
        //System.out.println("Logging in...");
        //System.out.println("Enter Username: ");
        //checkUserName = sc.next();
        //System.out.println("Enter Password: ");
        //checkPassword= sc.next();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        sql = "SELECT * FROM user WHERE userName='"+AuthUserName+"'";
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
                    
        //System.out.println("Welcome, "+fName+"!");
        User u = new User(fName,lName,gender,fHeight,iHeight,age,weight,tdee,weightgoal,uName,password);
        return true;
    }
    
    public String getUserFirstName(String userName) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        sql = "SELECT * FROM user WHERE userName='"+userName+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
        fName=rs.getString("fName");
        }
        return fName;
    }
    
    public int getUserTDEE(String userName) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        sql = "SELECT * FROM user WHERE userName='"+userName+"'";
        rs = stmt.executeQuery(sql);
        while(rs.next()){
        tdee=rs.getInt("tdee");
        }
        return tdee;
    }
    
    public ResultSet getFoodInfo(String userName) throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        CurrentDate CDate = new CurrentDate();
        String date = CDate.getDate();
        sql = "SELECT * FROM foodlog WHERE userName='"+userName+"' AND log='"+date+"'";
        rs = stmt.executeQuery(sql);
        return rs;
    }
        
}

