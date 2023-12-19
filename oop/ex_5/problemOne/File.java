package oop.ex_5.problemOne;

public class File implements MetaFile{
    private String name;
    private int depth;

    public File(String name, int depth) {
        this.name = name;
        this.depth = depth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public void killVirus() {
        for(int i = 0;i < this.getDepth();i++) {
            System.out.print("\t");
        }
        System.out.println(this.getName() + "杀毒完成...");
    }
}
