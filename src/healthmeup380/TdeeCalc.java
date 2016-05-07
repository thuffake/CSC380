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
public class TdeeCalc {
    //Scanner sc = new Scanner(System.in);
    
    public TdeeCalc(){
    
    }
    
    //Make sure to uncomment the user input for the scanner
    public int calculate(int fHeight,int iHeight,int weight,int age, String gender){
        double tdee=0;
        double kgweight=weight/2.2;
        fHeight=fHeight * 12;
        double inchHeight=fHeight+iHeight;
        double cmHeight=inchHeight*2.54; 
        double bmr=0;

        //System.out.println("What is your activity level on a level of 1 - 5?");
        //int actlvl = sc.nextInt();
        //int actlvl = 3;
        int actlvl=3;
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
        Double d = tdee;
        Integer i = d.intValue();
        //System.out.println(tdee);
        return i;
    }
}
