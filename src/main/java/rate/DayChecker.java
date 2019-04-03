package rate;

import java.util.Calendar;
import java.util.Date;

public class DayChecker {

  public static boolean isNotWeekend() {
    Calendar c = Calendar.getInstance();
    c.setTime(new Date());
    int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

    boolean isWeekend = dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;

    // return true or false to test
    return !isWeekend;
  }
}
