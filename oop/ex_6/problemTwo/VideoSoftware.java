package oop.ex_6.problemTwo;

public class VideoSoftware {
    private String mainWindow; // 主窗口
    private String controlBar; // 控制条
    private String menu; // 菜单, optional
    private String playList; // 播放列表, optional
    private String favorites; // 收藏列表, optional

    public VideoSoftware(String mainWindow, String controlBar) {
        this.mainWindow = mainWindow;
        this.controlBar = controlBar;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void setPlayList(String playList) {
        this.playList = playList;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s,%s,%s,%s)", menu, playList, mainWindow, controlBar, favorites);
    }
}
