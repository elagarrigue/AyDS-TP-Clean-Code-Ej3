package rate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RateCollection {

  private final PriceCalculator priceCalculator;

  public RateCollection(PriceCalculator priceCalculator) {
    this.priceCalculator = priceCalculator;
  }

  private List<Rate> rates = new ArrayList<>();

  public void addTimeRate(Rate rate) {
    rates.add(rate);
  }

  public void sortAscending() {
    rates.sort(Comparator.comparingInt(Rate::getTimeFraction));
  }

  public void sortDescending() {
    rates.sort(new Comparator<Rate>() {
      @Override
      public int compare(Rate o1, Rate o2) {
        return o2.getTimeFraction() - o1.getTimeFraction();
      }
    });
  }

  public String getRateString() {
    sortAscending();

    StringBuilder ratesString = new StringBuilder();
    for (Rate rate : rates) {
      ratesString.append(rate.getRateString());
    }
    return ratesString.toString();
  }

  public float calculatePrice(int minutes) {
    priceCalculator.setRateCollection(this);

    return priceCalculator.calculatePrice(minutes);
  }

  public List<Rate> getRates() {
    return rates;
  }

  public int size() {
    return rates.size();
  }
}
