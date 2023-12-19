package oop.ex_2.problemOne;

public class CameraFactory implements BaseFactory{
    @Override
    public BaseProduct produce() {
        return new Camera();
    }
}
