package oop.ex_5.problemOne;

import java.util.ArrayList;
import java.util.List;

public class Folder implements MetaFile{
    private String name;
    private int depth;
    private List<MetaFile> children = new ArrayList<MetaFile>();

    public Folder(String name, int depth) {
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

    public void create(MetaFile metaFile) {
        children.add(metaFile);
    }

    public void remove(MetaFile metaFile) {
        children.remove(metaFile);
    }
    @Override
    public void killVirus() {
        for(int i = 0;i < this.getDepth();i++) {
            System.out.print("\t");
        }
        System.out.println(this.getName() + "开始杀毒");
        for(MetaFile metaFile: children) {
            metaFile.killVirus();
        }
    }
}
