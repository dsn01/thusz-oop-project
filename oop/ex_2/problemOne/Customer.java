package oop.ex_2.problemOne;

public class Customer {
    BaseFactory computerFactory, phoneFactory, cameraFactory;

    public Customer() {
        /*
            模拟用户下单界面
         */
        this.computerFactory = new ComputerFactory();
        this.phoneFactory = new PhoneFactory();
        this.cameraFactory = new CameraFactory();
    }

    public void order(String name) {
        /*
            模拟用户下单操作
         */
        if(name.equalsIgnoreCase("computer")) {
            this.computerFactory.produce();
        } else if(name.equalsIgnoreCase("phone")) {
            this.phoneFactory.produce();
        } else if(name.equalsIgnoreCase("camera")) {
            this.cameraFactory.produce();
        } else {
            System.out.println("Sorry, we don't have the commodity called " + name + " now......");
        }
    }
}
