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
    double tdee;
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
        System.out.println("Create Username");
        uName=sc.next();
        //if(userNameExists(uName)==true){
           // return;
       // }
        System.out.println("Create password");
        password=sc.next();
        System.out.println("First Name?");
        fName=sc.next();
        System.out.println("Last name?");
        lName=sc.next();
        System.out.println("Gender? Type M or F");
        gender=sc.next();
        System.out.println("Height in feet");
        fHeight=sc.nextInt();
        System.out.println(fHeight+" foot and how many inches?");
        iHeight=sc.nextInt();
        System.out.println("Age");
        age=sc.nextInt();
//        System.out.println("Tdee?");
//        TdeeCalc calc = new TdeeCalc();
//        tdee = calc.calculate(fHeight, iHeight, weight, age, gender);
//        tdee=sc.nextInt();
        System.out.println("Weight in pounds");
        weight=sc.nextInt();
        System.out.println("Goal weight");
        weightgoal=sc.nextInt();
        System.out.println("Lets calculate your TDEE");
        TdeeCalc calc = new TdeeCalc();
        tdee = calc.calculate(fHeight, iHeight, weight, age, gender);

        sql="insert into user (id,fName,lName,weight,weightgoal,tdee,userName,passWord,fHeight,iHeight,age,gender)"
                + "VAlUES (NULL,'"+fName+"','"+lName+"','"+weight+"','"+weightgoal+"','"+tdee+"',"
                + "'"+uName+"','"+password+"','"+fHeight+"','"+iHeight+"','"+age+"','"+gender+"')";
            stmt.executeUpdate(sql);
    }
    
    //maybe change this method to require a username
    public void submitFood() throws SQLException{
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        System.out.println("Name of food?");
        String food = sc.next();
        System.out.println("How many calories?");
        String calorie=sc.next();
        CurrentDate CDate = new CurrentDate();
        String date = CDate.getDate();
        //String CUsername = uName;
        sql="insert into foodlog (id,userName,food,log,totalCalories) "
                + "VAlUES (NULL,'"+uName+"','"+food+"','"+date+"','"+calorie+"')";
            stmt.executeUpdate(sql);
        
    }
    
    public User login ()throws SQLException {
        System.out.println("Logging in...");
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
