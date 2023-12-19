package oop.ex_6.problemTwo;

public class CompleteBuilder implements BaseBuilder{
    private VideoSoftware videoSoftware;

    public CompleteBuilder(String mainWindow, String controlBar) {
        videoSoftware = new VideoSoftware(mainWindow, controlBar);
    }
    @Override
    public void setMenu() {
        videoSoftware.setMenu("菜单");
    }

    @Override
    public void setPlayList() {
        videoSoftware.setPlayList("播放列表");
    }

    @Override
    public void setFavorites() {

    }

    @Override
    public VideoSoftware getVideoSoftware() {
        return videoSoftware;
    }
}
