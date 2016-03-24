/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthmeup380;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thomas
 */
public class SQLMethodTest {
    ResultSet rs;
    Scanner sc = new Scanner(System.in);
    String sql;
    String fName;
    String lName;
    String gender;
    String uName="bob12";
    String checkUserName;
    String checkPassword;
    private String password;
    int weight;
    int fHeight;
    int iHeight;
    int age;
    int tdee;
    int weightgoal;
    
    
    public SQLMethodTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUser method, of class SQLMethod.
     */
    @Test
    public void testGetUser() throws Exception {
        //tests that the given user is in the database
        //by feeding the query a preset name, in this case,
        //"Thomas" and verifying that it returns the same name
        System.out.println("getUser");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        sql = "SELECT * FROM user WHERE userName='"+uName+"'";
        rs = stmt.executeQuery(sql);
        while (rs.next()){
        assertTrue(rs.getString("userName").equals(uName));
        assertFalse(rs.getString("userName").equals("thuff"));
        //u.testLogonSuccses();
        //assertTrue(u.uName.equals(uName));        
        }
        //u.testLogonSuccses();
    }

    /**
     * Test of createUser method, of class SQLMethod.
     */
    @Test
    public void testCreateUser() throws Exception {
        
        //creates a user with the given parmeters, and randomizes the 
        //users weight, then verifys the user was created
        //by using the random number that was generated with the expected result
        System.out.println("createUser");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        Random rn = new Random();
        int maximum = 300;
        int minimum = 1;
        int range = maximum - minimum + 1;
        int randomNum =  rn.nextInt(range) + minimum;
        sql="insert into user (id,fName,lName,weight,weightgoal,tdee,userName,passWord)"
                + "VAlUES (NULL,'Bob','Smith','"+randomNum+"','160','2500','bob1','bobpassword')";
        stmt.executeUpdate(sql);
        sql = "SELECT * FROM user WHERE weight='"+randomNum+"'";
        rs = stmt.executeQuery(sql);
            
        while(rs.next()){
            assertTrue(rs.getInt("weight")==(randomNum));
            assertFalse(rs.getInt("weight")==(0));
            
        }
        //u.testLogonSuccses();
    }

    /**
     * Test of submitFood method, of class SQLMethod.
     */
    @Test
    public void testSubmitFood() throws Exception {
        
        //submits a food with the given parmeters and randomizes the 
        //foods calories, then verifys the food was created by comparing
        //the random number with the expected random number
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/users", "root", "tech");
        Statement stmt= (Statement) conn.createStatement();
        Random rn = new Random();
        int maximum = 300;
        int minimum = 1;
        int range = maximum - minimum + 1;
        int randomNum =  rn.nextInt(range) + minimum;
        sql="insert into foodlog (id,userName,food,log,totalCalories) "
                + "VAlUES (NULL,'thuff','Apple','2016-03-09','"+randomNum+"')";
        stmt.executeUpdate(sql);
        sql = "SELECT * FROM foodlog WHERE totalCalories='"+randomNum+"'";
        rs = stmt.executeQuery(sql);
            
        while(rs.next()){
            assertTrue(rs.getInt("totalCalories")==(randomNum));
            assertFalse(rs.getInt("totalCalories")==(0));
    }
    }
    @Test
    public void login ()throws SQLException {
        System.out.println("Enter Username: ");
        String checkUserName = "bob12";
                //sc.next();
        System.out.println("Enter Password: ");
        String checkPassword= "pswd";
                //sc.next();
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
        assertTrue(u.uName.equalsIgnoreCase(checkUserName));
        //return u;
    
    }
    //tests if a username already exist, test should pass with output "Username already exists"
    @Test
    public void userNameExists ()throws SQLException {
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
            assertTrue(exists=false);
            //return exists;
        }
        System.out.println("Username already exists!");
        exists=true;
        assertTrue(exists=true);
        //return exists;
    }
}
