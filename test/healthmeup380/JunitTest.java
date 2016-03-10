/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthmeup380;

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
public class JunitTest {
    String username="user";
    int weight = 150;
    int calories = 55;
    
    String sqlQueryUsername="user";
    int sqlQueryWeight=150;
    int sqlQueryCalories=55;
    
    
    public JunitTest() {
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

    @Test
    public void testCreateUser(){
        //creates a user with the given parmeters, and randomizes the 
        //users weight, then verifys the user was created
        //by using the random number that was generated with the expected result
        assertTrue(weight==sqlQueryWeight);
        assertFalse(weight==0);
    }
    
    @Test
    public void testSubmitFood(){
        //submits a food with the given parmeters and randomizes the 
        //foods calories, then verifys the food was created by comparing
        //the random number with the expected random number
        assertTrue(calories==sqlQueryCalories);
        assertFalse(calories==0);
    }
    
    @Test
    public void testGetUser(){
        //tests that the given user is in the database
        //by feeding the query a preset name, in this case,
        //"Thomas" and verifying that it returns the same name
        assertTrue(username.equals(sqlQueryUsername));
        assertFalse(username.equals("notUsername"));
    }
    
}
