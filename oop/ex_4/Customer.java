package oop.ex_4;

public class Customer implements Cloneable{
    /*
        用户类
        @username: 账号
        @password: 密码
        @identityId: 身份证号
        @phone: 手机号
        @balance: 余额
     */
    private String username;
    private String password;
    private String identityId;
    private String phone;
    private double balance;

    public Customer(String username, String password, String identityId, String phone, double balance) {
        this.username = username;
        this.password = password;
        this.identityId = identityId;
        this.phone = phone;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    protected Object clone() {
        Customer customer = null;
        try{
            customer = (Customer) super.clone();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }
}
