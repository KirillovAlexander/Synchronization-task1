package ru.netology;

public class Manufacturer implements Runnable{

    public static final long TIME_TO_PRODUCT_MILLIS = 1000L;
    private static final int AMOUNT_OF_CARS = 10;
    private CarShop carShop;

    public Manufacturer(CarShop carShop) {
        this.carShop = carShop;
    }

    @Override
    public void run() {
        for (int i = 0; i < AMOUNT_OF_CARS; i++) {
            try {
                System.out.println(Thread.currentThread().getName() + ": произвожу новый автомобиль.");
                Thread.sleep(TIME_TO_PRODUCT_MILLIS);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            carShop.getNewCar();
        }
    }
}

