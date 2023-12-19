package oop.ex_3.policyPattern;

public class BaseSize {
    private String size;
    private int price;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "大小：" + size + ", 价格：" + price;
    }
}
