/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.Diary;

import Diary.Appointment;
import Diary.Day;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rzgheib
 */
public class DayTest {
    
    public DayTest() {
        
       
    }
    Day day1;
    Day day2;
    Day day3;
    
    
    
    @Before
    public void setUp() {
        day1 = new Day(1);
        day3 = new Day(3);
        day2 = new Day(2);
        Appointment appointm1 = new Appointment("lang", 2);
        day2.makeAppointment(9, appointm1);
       
    }
    
    @After
    public void tearDown() {
    }
    
    

    /**
     * Test of findSpace method, of class Day.
     */
    
    @Test
    public void findPlaceTest(){
        Appointment a = new Appointment("tb", 1);       
        assertEquals(9, day1.findSpace(a));
        day1.makeAppointment(day1.findSpace(a), a);
        Appointment b = new Appointment ("test", 5);
        
        
        
       
    }
}
