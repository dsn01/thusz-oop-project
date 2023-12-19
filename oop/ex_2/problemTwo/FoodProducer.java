package oop.ex_2.problemTwo;

public class FoodProducer implements BaseProducer{
    private BaseOperation cut, dye;
    public FoodProducer() {
        this.cut = new CutOperation();
        this.dye = new DyeOperation();
    }
    @Override
    public void produce() {
        this.cut.work();
        this.dye.work();
    }
}
