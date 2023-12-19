package oop.ex_4;

public class SystemProxy implements BaseSystem{
    /*
        系统代理类, 当存在不同的信息系统时, 只需实现BaseSystem接口而无需提前知道是哪个系统
     */
    private BaseSystem sys;

    public SystemProxy(BaseSystem sys) {
        this.sys = sys;
    }

    @Override
    public void search() {
        this.sys.search();
    }
}
