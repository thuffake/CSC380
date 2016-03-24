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
import java.util.Random;
import java.util.Scanner;

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
        //sql.createUser();
        User u = sql.login();
        u.calculate();
       //TdeeCalc calc = new TdeeCalc();
       //calc.calculate(u.fHeight,u.iHeight,u.weight,u.age,u.gender);
        //String name = u.fName;
        //System.out.println(name);
        //sql.getUser();
//        while(!input.equalsIgnoreCase("exit")){
//            input = sc.next();
//            if(input.equalsIgnoreCase("Create User")){
//                System.out.println("creating user");
//                sql.createUser();
//            }
//        }
        
        //sql.getUser();
        //sql.createUser();
        //sql.submitFood();
        
        
       //TdeeCalc calc = new TdeeCalc();
       //calc.calculate(6, 0, 200,35, "Male");
        
       
       
    }
    
}
