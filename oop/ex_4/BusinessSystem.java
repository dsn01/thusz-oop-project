package oop.ex_4;

public class BusinessSystem implements BaseSystem{
    /*
        商务信息系统, 可能存在其他具体的系统, 只需实现BaseSystem接口
     */
    @Override
    public void search() {
        System.out.println("查询ing......");
    }
}
