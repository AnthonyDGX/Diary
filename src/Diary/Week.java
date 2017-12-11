package Diary;
/**
 *
 * @author rzgheib
 */
public class Week {
    
public static final int BOOKABLE_DAYS_PER_WEEK = 5;

// A week number within a particular year (0-52).
    private final int weekNumber;
    private final Day[] days;

    public Week(int weekNumber)
    {
        this.weekNumber = weekNumber;
        days = new Day[BOOKABLE_DAYS_PER_WEEK];
        //
       //
    }
    
    public void showAppointments()
    {
     for (Day d : days){
         d.showAppointments();
     }  
    }
    
      public Day getDay(int dayInWeek)
    {
       if(dayInWeek >= 1 && dayInWeek <= BOOKABLE_DAYS_PER_WEEK) {
            return days[dayInWeek - 1];
        }
        else {
            return null;
}
        
    }

    /**
     * @return The week number (0-52).
     */
    public int getWeekNumber()
    {
        return weekNumber;
    }
    
}
