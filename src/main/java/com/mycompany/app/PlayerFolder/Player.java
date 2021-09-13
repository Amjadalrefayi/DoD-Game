package com.mycompany.app.PlayerFolder;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.app.Unit;

abstract public class Player {

    protected int teamId;
    protected int coins;
    protected int id ;
    protected List <Unit> units = new ArrayList<>();


    public Player(){
        
    }

    public int getTeamId() {
        return this.teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getCoins() {
        return this.coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Unit> getUnits() {
        return this.units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }


    public Player(int id, int teamId, int coins, List<Unit> units) {
        this.teamId = teamId;
        this.coins = coins;
        this.id = id;
        this.units = units;
    }

    
}
