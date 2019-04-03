package model;

import controller.ParkingPriceUpdateListener;
import rate.*;

class ParkingModelImpl implements ParkingModel {

  private final RateCollection rateCollection;

  ParkingModelImpl(RateCollection rateCollection ) {
    this.rateCollection = rateCollection;
  }

  @Override public void calculatePrice(ParkingPriceUpdateListener listener, int minutes) {

    float price = rateCollection.calculatePrice(minutes);

    listener.didUpdateParkingPrice(price);
  }

  @Override public String getPriceRates() {
    return rateCollection.getRateString();
  }

  @Override
  public void addTimeRate(Rate rate) {
    rateCollection.addTimeRate(rate);
  }

}
