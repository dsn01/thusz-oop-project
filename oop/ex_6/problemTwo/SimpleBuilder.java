package oop.ex_6.problemTwo;

public class SimpleBuilder implements BaseBuilder{
    private VideoSoftware videoSoftware;

    public SimpleBuilder(String mainWindow, String controlBar) {
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

    }

    @Override
    public VideoSoftware getVideoSoftware() {
        return videoSoftware;
    }
}
