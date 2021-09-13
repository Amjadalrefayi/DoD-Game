package com.mycompany.app.TeamFolder;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.app.PlayerFolder.ConsolePlayer;

abstract public class Team {

    private int id;
    private List <ConsolePlayer> players = new ArrayList<>();

    public Team() {
    }

    public Team(int id, List<ConsolePlayer> players) {
        this.id = id;
        this.players = players;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ConsolePlayer> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<ConsolePlayer> players) {
        this.players = players;
    }

    public Team id(int id) {
        this.id = id;
        return this;
    }

    public Team players(List<ConsolePlayer> players) {
        this.players = players;
        return this;
    }



    
}
