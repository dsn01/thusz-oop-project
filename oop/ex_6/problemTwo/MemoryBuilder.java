package oop.ex_6.problemTwo;

public class MemoryBuilder implements BaseBuilder{
    private VideoSoftware videoSoftware;

    public MemoryBuilder(String mainWindow, String controlBar) {
        videoSoftware = new VideoSoftware(mainWindow, controlBar);
    }
    @Override
    public void setMenu() {

    }

    @Override
    public void setPlayList() {

    }

    @Override
    public void setFavorites() {
        videoSoftware.setFavorites("收藏列表");
    }

    @Override
    public VideoSoftware getVideoSoftware() {
        return videoSoftware;
    }
}
