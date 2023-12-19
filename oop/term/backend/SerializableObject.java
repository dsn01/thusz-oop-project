package oop.term.backend;

import java.io.*;

public abstract class SerializableObject implements Serializable {
    public void save(String path) {
        /*
            将对象序列化到本地
         */
        try {
            // 创建文件输出流
            FileOutputStream fileOut = new FileOutputStream(path);
            // 创建对象输出流
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            // 将对象进行序列化并保存到文件
            out.writeObject(this);
            // 关闭流
            out.close();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SerializableObject read(String path) {
        /*
            反序列化
         */
        try {
            // 创建文件输入流
            FileInputStream fileIn = new FileInputStream(path);
            // 创建对象输入流
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // 从文件中读取对象并进行反序列化
            SerializableObject object = (SerializableObject) in.readObject();
            // 关闭流
            in.close();
            fileIn.close();
            return object;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
