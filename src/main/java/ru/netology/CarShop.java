package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class CarShop {
    private static final int TIME_TO_SELL = 100;
    Manufacturer manufacturer = new Manufacturer(this);
    List<Car> carList = new ArrayList<>();

    public List<Car> getCarList() {
        return carList;
    }

    public synchronized void sellCar() {
        try {
            Thread.sleep(TIME_TO_SELL);
            while (carList.size() == 0) {
                System.out.println("В магазине отсутствуют автомобили!");
                wait();
            }
            carList.remove(0);
            System.out.println(Thread.currentThread().getName() + ": купил новенький автомобиль!");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void getNewCar() {
        try {
            Thread.sleep(Manufacturer.TIME_TO_PRODUCT_MILLIS);
            System.out.println("В магазин поступил новый автомобиль от производителя!");
            carList.add(new Car("VW", manufacturer));
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
