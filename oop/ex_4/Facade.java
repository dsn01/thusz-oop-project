package oop.ex_4;

public class Facade {
    /*
        子系统的外观模式, 定义访问该系统的全部流程
     */
    private Database database;
    private Validate val;
    private SystemProxy proxy;
    private Logging log;
    private Casher casher;

    public Facade(Database database, Validate val, SystemProxy proxy, Logging log, Casher casher) {
        this.database = database;
        this.val = val;
        this.proxy = proxy;
        this.log = log;
        this.casher = casher;
    }

    public void search(String username, String password, String identityId, String phone) {
        // 第一步: 检查用户是否存在于系统中
        boolean isExist = this.val.hasUser(this.database,username,password,identityId,phone);
        // 第二步：如果不存在则注册, 否则直接登录
        if(!isExist) {
            System.out.println("用户不存在...即将创建新用户");
            this.val.register(this.database,username,password,identityId,phone);
        }
        else {
            this.val.login(username);
        }
        // 第三步: 根据用户的访问次数进行收费的计算
        double fee = this.casher.calculateFee(this.log.getTimes(identityId));
        // 第四步: 判断账户余额是否足够支付, 如果不够则进行充值
        double balance = this.casher.check(this.database, identityId);
        if(balance < fee) {
            System.out.println("余额不足, 请充值...");
            this.casher.recharge(this.database, identityId);
        }
        // 第五步: 收费
        this.casher.cash(this.database, identityId, fee);
        // 第六步: 查询系统
        this.proxy.search();
        // 第七步: 日志记录本次访问
        this.log.record(identityId);
    }
}







