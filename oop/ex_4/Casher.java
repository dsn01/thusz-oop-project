package oop.ex_4;

import java.util.Scanner;

public class Casher {
    /*
        用于用户的充值和消费
     */
    public double calculateFee(int times) {
        if(times <= 200) return 0.1;
        if(times > 500) return 0.5;
        int factor = (times - 200) / 100;
        return 0.1 + factor * 0.1;
    }

    public double check(Database database, String identityId) {
        return database.query(identityId).getBalance();
    }

    public void recharge(Database database, String identityId) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入你需要充值的金额: ");
        double money = scanner.nextDouble();
        database.update(identityId, this.check(database, identityId) + money);
        System.out.println("充值成功...账户余额为: " + check(database, identityId) + "元");
    }

    public void cash(Database database, String identityId, double fee) {
        database.update(identityId, this.check(database, identityId) - fee);
        System.out.println("支付" + fee + "元成功...账户余额为: " + check(database, identityId));
    }
}
