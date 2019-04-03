package model;

import rate.PriceCalculator;
import rate.PriceCalculatorImp;
import rate.RateCollection;

public class ParkingModule {
  private static ParkingModule instance;
  private ParkingModel parkingModel;

  private PriceCalculator priceCalculator = new PriceCalculatorImp();
  private RateCollection rateCollection = new RateCollection(priceCalculator);

  private ParkingModule() {
    parkingModel =  new ParkingModelImpl(rateCollection);
  }

  public static ParkingModule getInstance() {
    if(instance == null) {
      instance =  new ParkingModule();
    }
    return instance;
  }

  public ParkingModel getParkingModel() {
    return parkingModel;
  }
}
