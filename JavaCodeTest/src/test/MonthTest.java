package test;
import java.time.LocalDate;
import java.time.Month;

public class MonthTest {

	public static void main(String[] args) {
	      LocalDate currentdate = LocalDate.now();
	      //Getting the current month
	      Month currentMonth = currentdate.getMonth();
	      //getting the current year
	      int currentYear = currentdate.getYear();
	      
	      String monthyear = currentMonth+" "+currentYear;
	      System.out.println(monthyear);
	      
	      int currentDay = currentdate.getDayOfMonth();
	      System.out.println("Current day: "+currentDay);

	}

}
