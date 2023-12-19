package oop.ex_2.problemTwo;

public class DeviceFactory implements BaseFactory{
    private BaseProducer producer;
    public DeviceFactory() {
        this.producer = new DeviceProducer();
    }
    @Override
    public BaseProduct produce() {
        this.producer.produce();
        System.out.println("Device has been produced successfully......");
        return new Device();
    }
}
