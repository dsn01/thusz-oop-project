package oop.ex_4;

public class Validate {
    /*
        用于管理登录和注册时的用户信息
     */
    public boolean hasUser(Database database, String username, String password, String identityId, String phone) {
        Customer customer = database.query(identityId);
        if(customer == null) return false;
        if(customer.getUsername() != username) return false;
        if(customer.getPassword() != password) return false;
        if(customer.getIdentityId() != identityId) return false;
        if(customer.getPhone() != phone) return false;
        return true;
    }

    public void register(Database database, String username, String password, String identityId, String phone) {
        database.add(username, password, identityId, phone);
        System.out.println("注册成功...");
    }

    public void login(String username) {
        // actually nothing
    }
}
