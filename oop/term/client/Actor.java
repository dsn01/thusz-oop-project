package oop.term.client;

import oop.term.backend.ChessState;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Actor {
    public String username;
    public String password;
    public int total;
    public int wins;

    public Actor(String username, String password, int total, int wins) {
        this.username = username;
        this.password = password;
        this.total = total;
        this.wins = wins;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public abstract String sendCommand(ChessState state);

    public void saveToLocal(boolean win) {
        if (this.username.equals("游客") || this.username.contains("AI")) return;
        try {
            File file = new File(this.username);
            FileWriter writer = new FileWriter(file, false);
            writer.write(this.password + "\n");
            this.total += 1;
            if (win) this.wins += 1;
            writer.write(this.total + " " + this.wins + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("IOException occurs");
        }
    }
}
