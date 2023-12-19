package oop.ex_1;

public class TestBench {
    public static void main(String[] args) {
        ValueConverter converter = new ValueConverter();
        double x = 3.1415926;
        int y = 3;
        double[] x_list = new double[]{3.1415926, 3.1412926, 3.14};

        converter.convert(x);

        converter.convert(x, y);

        converter.convert(x_list);

        converter.convert(x_list, y);
    }
}
