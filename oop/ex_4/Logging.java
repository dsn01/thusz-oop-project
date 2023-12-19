package oop.ex_4;

import java.util.HashMap;

public class Logging {
    /*
        日志类, 用于记录用户查询次数(HashMap)
     */
    private HashMap<String, Integer> log = new HashMap<String, Integer>();

    public int getTimes(String identityId) {
        if(this.log.containsKey(identityId)) return this.log.get(identityId);
        return 0;
    }

    public void record(String identityId) {
        if (this.log.containsKey(identityId)) {
            int pre = this.getTimes(identityId);
            this.log.put(identityId, pre + 1);
        } else {
            this.log.put(identityId, 1);
        }
        System.out.println(identityId + "第" + this.getTimes(identityId) + "次访问成功...");
    }
}
