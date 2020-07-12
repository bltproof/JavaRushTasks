package com.javarush.task.task36.task3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }

    public void increaseSpeed(int seconds) {
        int speed = getCarSpeed();
        int maxSpeed = getCarMaxSpeed();

        if (speed < maxSpeed) {
            speed += (3.5 * seconds);
            setCarSpeed(speed);
        }
        if (speed > maxSpeed) {
            speed = maxSpeed;
            setCarSpeed(speed);
        }
    }

    public void decreaseSpeed(int seconds) {
        int speed = getCarSpeed();

        if (speed > 0) {
            speed -= (12 * seconds);
            setCarSpeed(speed);
        }
        if (speed < 0) {
            speed = 0;
            setCarSpeed(speed);
        }
    }
}