package oop.ex_1;

public class ValueConverter {
    public ValueConverter() {
    }

    public void convert(double x) {
        System.out.println(x);
    }

    public void convert(double x, int y) {
        String format = "%." + y + "f";
        String result = String.format(format, x);
        System.out.println(result);
    }

    public void convert(double[] x) {
        for (int i = 0;i < x.length;i++) System.out.print(x[i] + " ");
        System.out.println();
    }

    public void convert(double[] x, int y) {
        String format = "%." + y + "f";
        for (int i = 0; i < x.length; i++) System.out.print(String.format(format, x[i]) + " ");
        System.out.println();
    }
}
