/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthmeup380;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author thomas
 */
public class CurrentDate {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar cal = Calendar.getInstance();
    //System.out.println(dateFormat.format(cal.getTime()));
    
    public String getDate(){
        
    //System.out.println(dateFormat.format(cal.getTime()));
    String date = dateFormat.format(cal.getTime());
    return date;
    }
}
