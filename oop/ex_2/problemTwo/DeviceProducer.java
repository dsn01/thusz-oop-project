package oop.ex_2.problemTwo;

public class DeviceProducer implements BaseProducer{
    private BaseOperation add, process, refrigerator;
    public DeviceProducer() {
        this.add = new AddRawMaterialOperation();
        this.process = new ProcessOperation();
        this.refrigerator = new RefrigerateOperation();
    }
    @Override
    public void produce() {
        this.add.work();
        this.process.work();
        this.refrigerator.work();
    }
}
