package Diary;
public class Day
{
    // The first and final bookable hours in a day.
    public static final int START_OF_DAY = 9;
    public static final int FINAL_APPOINTMENT_TIME = 17;
    // The number of bookable hours in a day.
    public static final int MAX_APPOINTMENTS_PER_DAY =
                                FINAL_APPOINTMENT_TIME -
                                START_OF_DAY;
    
    // A day number within a particular year. (1-366)
    private int dayNumber;
    // The current list of appointments for this day.
    private Appointment[] appointments;

    /**
     * Constructor for objects of class Day.
     * @param dayNumber The number of this day in the year (1-366).
     */
    public Day(int dayNumber)
    {
        this.dayNumber = dayNumber;
        appointments = new Appointment[MAX_APPOINTMENTS_PER_DAY];
    }

    /**
     * Try to find space for an appointment.
     * @param appointment The appointment to be accommodated.
     * @return The earliest time today that can accommodate
     *         the appointment. Return -1 if there is 
     *         insufficient space.
     */ 
public int findSpace(Appointment appointment)
    {
        int ret = 9;
        int duree = appointment.getDuration();
        
        for (int i = 0 ; i < appointments.length; i++){            
            if (appointments[i] == null){
                int valide =0;
                for (int o = 0; o < duree; o++){
                    if (appointments[i+o] == null){
                        valide += 1;
                        if (valide == duree && ret + duree <= FINAL_APPOINTMENT_TIME ){
                            System.out.println(ret);
                            return ret;
                            
                        }                        
                    }
                }
            }
            else{
                ret += 1;
                
            }        
        }
        return -1;
    }

    /**
     * Make an appointment.
     * @param time The hour at which the appointment starts.
     * @param appointment The appointment to be made.
     * @return true if the appointment was successful,
     *         false otherwise.
     */
    public boolean makeAppointment(int time,
                                   Appointment appointment)
    {
        if (validTime(time)){
            int valide =0;
            int timeListe = time - START_OF_DAY;
            if (appointments[timeListe] == null){
                
                for(int i = 0; i < appointment.getDuration(); i++){
                    if (appointments[timeListe+i] == null)
                        valide ++;
                }
                if (valide == appointment.getDuration() && time+appointment.getDuration() <= FINAL_APPOINTMENT_TIME){
                    for (int i =0; i < appointment.getDuration(); i++){
                        appointments[timeListe+i] = appointment;
                    }
                    return true;
                }
                else{
                    return false;
                }
            }
                     
        }
        return false;
    }

    /**
     * Print a list of the day's appointments on standard output.
     */
    public void showAppointments()
    {
        System.out.println("=== Day " + dayNumber + " ===");
        int time = START_OF_DAY;
        for(Appointment appointment : appointments) {
            System.out.print(time);
            if(appointment != null) {
                System.out.println(appointment.getDescription());
            }
            else {
                System.out.println();
            }
            time++;
        }
    }

    /**
     * @return The number of this day within the year (1 - 366).
     */
    public int getDayNumber()
    {
        return dayNumber;
    }
    
    /**
     * @return true if the time is between FINAL_APPOINTMENT_TIME and
     *         END_OF_DAY, false otherwise.
     */
    public boolean validTime(int time)
    {
        return time >= START_OF_DAY && time <= FINAL_APPOINTMENT_TIME;
    }
}
