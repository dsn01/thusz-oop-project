package oop.ex_5.problemOne;

public class TestBench {
    public static void main(String[] args) {
        // 1. 创建目录结构, 简单起见就不写递归了...
        Folder root = new Folder("根文件夹", 0);
            Folder imageFolder = new Folder("图片文件夹", 1);
                File photo = new File("照片.jpg", 2);
                File screenShot = new File("截图.gif", 2);
                imageFolder.create(photo);
                imageFolder.create(screenShot);
            Folder  videoFolder = new Folder("视频文件夹", 1);
                File screenRecord = new File("录屏.mp4", 2);
                Folder  voiceFolder = new Folder("音频文件夹", 2);
                    File voiceRecord = new File("录音.mp3", 3);
                    voiceFolder.create(voiceRecord);
                videoFolder.create(screenRecord);
                videoFolder.create(voiceFolder);
            root.create(imageFolder);
            root.create(videoFolder);
        // 2. 杀毒
        root.killVirus();
    }
}
