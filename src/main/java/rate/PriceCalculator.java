package rate;

public interface PriceCalculator {

  float calculatePrice(int minutes);

  void setRateCollection(RateCollection rateCollection);
}
