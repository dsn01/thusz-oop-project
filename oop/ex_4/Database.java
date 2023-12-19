package oop.ex_4;

import java.util.HashMap;

public class Database {
    /*
        使用HashMap模拟用户数据库
     */
    private HashMap<String, Customer> database = new HashMap<String, Customer>();
    private Customer prototype;

    public Database() {
        this.prototype = new Customer("系统", "111", "100", "110", 0);
    }

    public void add(String username, String password, String identityId, String phone){
        Customer customer = (Customer) this.prototype.clone();
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setIdentityId(identityId);
        customer.setPhone(phone);
        customer.setBalance(0);
        this.database.put(customer.getIdentityId(), customer);
    }

    public Customer query(String identityId){
        return this.database.get(identityId);
    }

    public void update(String identityId, double balance) {
        this.database.get(identityId).setBalance(balance);
    }
}
