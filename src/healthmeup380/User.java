/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthmeup380;

import java.util.Scanner;

/**
 *
 * @author thomas
 */
public class User {
    String fName;
    String lName;
    String uName;
    String gender;
    private String password;
    int weight;
    int fHeight;
    int iHeight;
    int age;
    double tdee;
    int weightgoal;
    Scanner sc = new Scanner(System.in);
    
    public User(String fName, String lName, String gender, int fHeight, int iHeight,
            int age, int weight, double tdee, int weightgoal, String uName, String password){
        this.fName = fName;
        this.lName = lName;
        this.tdee = tdee;
        this.weight = weight;
        this.weightgoal = weightgoal;
        this.fHeight = fHeight;
        this.iHeight = iHeight;
        this.age = age;
        this.uName = uName;
        this.password = password;
        this.gender = gender;
    }
    
    //Make sure to uncomment the user input for the scanner
    public double calculate(){
        double tdee=0;
        double kgweight=weight/2.2;
        fHeight=fHeight * 12;
        double inchHeight=fHeight+iHeight;
        double cmHeight=inchHeight*2.54; 
        double bmr=0;

        System.out.println("What is your activity level?");
        int actlvl = 3;
        //actlvl=sc.nextInt();
        if(gender.equalsIgnoreCase("m")){
            bmr=66 + (13.7 * kgweight) + (5 * cmHeight) - (6.8 * age);
        } else if(gender.equalsIgnoreCase("f")){
            bmr=655 + (9.6 * kgweight) + (1.8 * cmHeight) - (4.7 * age);
        }
        
        //bmr=66 + (13.7 * kgweight) + (5 * cmHeight) - (6.8 * age);
        switch (actlvl) {
            case 1:  tdee = bmr*1.2;
                     break;
            case 2:  tdee = bmr*1.375;
                     break;
            case 3:  tdee = bmr*1.55;
                     break;
            case 4:  tdee = bmr*1.725;
                     break;
            case 5:  tdee = bmr*1.9;
                     break;
        }
        tdee = (int) Math.round(tdee);
        System.out.println(tdee);
        return tdee;
    }

    
    public void logonSuccses(){
        
    }
    
    public void isActiveUser(){
        
    }
    
    public String getCurrentUserName(){
        return uName;
    }
    
}

