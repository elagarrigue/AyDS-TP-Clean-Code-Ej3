package model;

import controller.ParkingPriceUpdateListener;
import rate.DayOfTheWeekRate;
import rate.Rate;

public interface ParkingModel {

  void calculatePrice(ParkingPriceUpdateListener listener, int minutes);

  String getPriceRates();

  void addTimeRate(Rate rate);
}
