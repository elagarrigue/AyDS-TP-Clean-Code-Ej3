package rate;

public class TimeUtils {
  public static String minutesToHsMin(Integer minutes) {

    StringBuilder timeString = new StringBuilder();

    int hs = minutes / 60;

    if (hs > 0) {
      timeString.append(hs).append("hs ");
    }

    int min = minutes % 60;

    if (min > 0) {
      timeString.append(min).append("min");
    }

    return timeString.toString();
  }
}
