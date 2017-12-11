/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diary;

/**
 *
 * @author adagneau
 */
public class Main {
    
    public static void main(String [] args)
	{
		Day day1 = new Day(1);
                Appointment a = new Appointment("tb", 5); 
                Appointment b = new Appointment("test", 3);
                Appointment c = new Appointment("test", 1);                
                day1.makeAppointment(9, a);
                day1.showAppointments();
                day1.findSpace(b);
                day1.makeAppointment(14, b);
                day1.showAppointments();
                System.out.println(day1.findSpace(c));
                
	}
    
}
