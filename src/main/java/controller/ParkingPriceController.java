package controller;

import model.ParkingModel;
import model.ParkingModule;
import rate.*;
import view.ParkingPriceView;

import static rate.DayChecker.isNotWeekend;

public class ParkingPriceController implements ParkingPriceUpdateListener {

  private ParkingModel parkingModel = ParkingModule.getInstance().getParkingModel();
  private ParkingPriceView parkingPriceView;

  public ParkingPriceController() {
    initRates();
  }

  private void initRates() {
    if (isNotWeekend()) {
      parkingModel.addTimeRate(new DayOfTheWeekRate(15, 20));
      parkingModel.addTimeRate(new DayOfTheWeekRate(60, 60));
      parkingModel.addTimeRate(new DayOfTheWeekRate(24 * 60, 800));
      parkingModel.addTimeRate(new DayOfTheWeekRate(12 * 60, 600));
    } else {
      parkingModel.addTimeRate(new Rate(15, 20));
      parkingModel.addTimeRate(new Rate(60, 60));
      parkingModel.addTimeRate(new Rate(24 * 60, 800));
      parkingModel.addTimeRate(new Rate(12 * 60, 600));
    }
  }

  public void onEventCalculate(int minutes) {
    parkingModel.calculatePrice(this, minutes);
  }

  public void setParkingPriceView(ParkingPriceView parkingPriceView) {
    this.parkingPriceView = parkingPriceView;
  }

  @Override public void didUpdateParkingPrice(float price) {
    parkingPriceView.updatePriceResult(price);
  }
}
