package com.mycompany.app.GameFolder;

import com.mycompany.app.Grid;
import com.mycompany.app.Unit;
import com.mycompany.app.TeamFolder.Team;

public class DoDGameManager  {

    public  Grid grid ;
    public Unit mainBase;
    public  int remainingAttackerUnits;
    public  Timeer remainingTime;
    public  Team AttackerTeam;
    public  Team DefenderTeam;
    public  GameState  gameState;
    public static DoDGameManager doDGameManager ;
    
    public static DoDGameManager getdDoDGameManager(Grid grid , Unit mainBase , int remainingAttackerUnits , Timeer remainingTime , Team AttackerTeam ,Team DefenderTeam ,GameState  gameState )
    {
        if(doDGameManager==null)
        {
            doDGameManager =new DoDGameManager(grid , mainBase , remainingAttackerUnits ,remainingTime , AttackerTeam , DefenderTeam , gameState );
            return doDGameManager;
        }
        else return doDGameManager;
    }


    public DoDGameManager(Grid grid , Unit mainBase , int remainingAttackerUnits , Timeer remainingTime , Team AttackerTeam ,Team DefenderTeam ,GameState  gameState){}
    {
        this.grid = grid;
        this.mainBase = mainBase;
        this.remainingAttackerUnits = remainingAttackerUnits;
        this.remainingTime = remainingTime;
        this.AttackerTeam = AttackerTeam;
        this.DefenderTeam = DefenderTeam;
        this.gameState = gameState;

    }
   public DoDGameManager(){}



}

