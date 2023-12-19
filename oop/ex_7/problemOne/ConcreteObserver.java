package oop.ex_7.problemOne;

public class ConcreteObserver implements AbstractObserver{
    private String username;
    private String position;
    private String location;

    public ConcreteObserver(String username, String position, String location) {
        this.username = username;
        this.position = position;
        this.location = location;
    }

    @Override
    public void update(String company, String position, String location) {
        if (this.getPosition().equals(position) && this.getLocation().equals(location)) {
            System.out.println(String.format("%s: 收到来自(%s, %s, %s)的招聘通知", this.getUsername(), company, position, location));
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
