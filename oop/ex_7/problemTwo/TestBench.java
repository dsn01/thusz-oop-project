package oop.ex_7.problemTwo;

public class TestBench {
    public static void main(String[] args) throws Exception {
        BaseSort baseSort = null;
        // 1. 不排序
        baseSort = new TrivialSort();
        System.out.println("1. 不排序的结果: ");
        baseSort.run();

        // 2. 字典序
        baseSort = new DictSort();
        System.out.println("2. 按照字典序排序结果: ");
        baseSort.run();

        // 3. 单词长度
        baseSort = new LengthSort();
        System.out.println("3. 按照单词长度排序结果: ");
        baseSort.run();

        // 4. 出现次数
        baseSort = new FrequencySort();
        System.out.println("4. 按照单词出现次数排序结果: ");
        baseSort.run();
    }
}
