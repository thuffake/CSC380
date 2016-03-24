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
public class UserTest {
    
    public UserTest() {
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
     * Test of calculate method, of class User.
     */
    @Test
    public void testCalculate() {
        System.out.println("calculate");
        User instance = new User("Nik","Merl","m",6,0,35,200,2200,160,"nik1","passw");
        double expResult = 3081.0;
        double result = instance.calculate();
        assertEquals(expResult, result, 3081.0);
    }

    /**
     * Test of logonSuccses method, of class User.
     */
    @Test
    public void testLogonSuccses() {
        System.out.println("logonSuccses");
        User instance = null;
        instance.logonSuccses();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isActiveUser method, of class User.
     */
    @Test
    public void testIsActiveUser() {
        System.out.println("isActiveUser");
        User instance = null;
        instance.isActiveUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
