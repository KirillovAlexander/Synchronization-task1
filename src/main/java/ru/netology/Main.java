package ru.netology;

public class Main {
    public static void main(String[] args) {

        CarShop carShop = new CarShop();
        Manufacturer manufacturer = new Manufacturer(carShop);
        Customer customer = new Customer(carShop);

        new Thread(null, customer, "Иван").start();
        new Thread(null, customer, "Александр").start();
        new Thread(null, customer, "Петр").start();
        new Thread(null, customer, "Юрий").start();
        new Thread(null, customer, "Максим").start();
        new Thread(null, customer, "Анатолий").start();
        new Thread(null, customer, "Роман").start();

        new Thread(null, manufacturer, "Производитель").start();

    }
}
