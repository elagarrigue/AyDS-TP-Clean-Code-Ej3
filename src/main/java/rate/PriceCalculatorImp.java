package rate;

public class PriceCalculatorImp implements PriceCalculator {
  private int minutesToPrice;
  private float price;

  private RateCollection rateCollection;

  public void setRateCollection(RateCollection rateCollection) {
    this.rateCollection = rateCollection;
  }

  public float calculatePrice(int minutes) {

    price = 0;

    minutesToPrice = minutes;

    applyBestRate();

    chargeRestingMinutes();

    fixOverprice(minutes);

    return price;
  }

  private void applyBestRate() {
    rateCollection.sortDescending();
    for (Rate rate : rateCollection.getRates()) {
      if (minutesToPrice / rate.getTimeFraction() > 0) {
        int units = minutesToPrice / rate.getTimeFraction();
        price += units * rate.getFractionPrice();
        minutesToPrice -= units * rate.getTimeFraction();
      }
    }
  }

  private void chargeRestingMinutes() {
    if (minutesToPrice > 0) {
      price += rateCollection.getRates().get(rateCollection.size() - 1).getFractionPrice();
    }
  }

  private void fixOverprice(int minutes) {
    rateCollection.sortAscending();
    for (Rate rate : rateCollection.getRates()) {
      int t = (int) Math.ceil((float) minutes / (float) rate.getTimeFraction());
      float p = rate.getFractionPrice() * t;

      if (t > 0 && p < price) {
        price = p;
        break;
      }
    }
  }
}
