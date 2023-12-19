package oop.ex_2.problemOne;

public class TestBench {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.order("computer");
        customer.order("phone");
        customer.order("camera");
        customer.order("apple");
    }
}
