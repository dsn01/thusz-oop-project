package oop.ex_4;

import java.util.Scanner;

public class TestBench {
    public static void main(String[] args) {
        Facade facade = new Facade(new Database(),
                                    new Validate(),
                                    new SystemProxy(new BusinessSystem()),
                                    new Logging(),
                                    new Casher()
        );
        System.out.println("===============测试一,演示用户第一次注册,登录,充值的过程===============");
        Scanner scanner = new Scanner(System.in);
        String username, password, identityId, phone;
        System.out.print("请输入用户名: ");
        username = scanner.nextLine();
        System.out.print("请输入密码: ");
        password = scanner.nextLine();
        System.out.print("请输入身份证号: ");
        identityId = scanner.nextLine();
        System.out.print("请输入手机号: ");
        phone = scanner.nextLine();
        facade.search(username, password, identityId, phone);
        System.out.println("===============测试二,演示用户第二次直接登录,并且一直访问知道把第一次充的钱花完的过程===============");
        while(true) {
            facade.search(username, password, identityId, phone);
        }
    }
}
