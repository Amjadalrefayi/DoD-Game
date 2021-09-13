package com.mycompany.app.GameFolder;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.app.Grid;
import com.mycompany.app.Revier;
import com.mycompany.app.Unit;
import com.mycompany.app.UnitFactory;
import com.mycompany.app.UnitPosition;
import com.mycompany.app.UnitType;
import com.mycompany.app.PlayerFolder.ConsolePlayer;
import com.mycompany.app.TeamFolder.AttackerTeam;
import com.mycompany.app.TeamFolder.Team;

public class GameInitializer {

    public static Grid grid;
    public static Unit mainBase;
    public static int remainingAttackerUnits;
    public static Timeer remainingTime ;
    Team AttackerTeam;
    Team DefenderTeam;
    public static GameState  gameState;
    public static GameInitializer gameInitializer;


    public GameInitializer getgameintializer()
    {
        if(gameInitializer==null)
        {
            gameInitializer = new GameInitializer();
            return gameInitializer;
        }
        else
        return gameInitializer;
    } 

    public GameInitializer()
    {
        //--------------------Grid--------------------
        this.grid = Grid.getGrid(10000, 10000);
        //--------------------------------------------

        //----------------Main Base-------------------
        UnitFactory unitFactory = new UnitFactory();
        this.mainBase = unitFactory.CreateUnit(UnitType.MAINBASE,null);
        UnitPosition unitPosition = new UnitPosition();
        unitPosition.setCenterX(1200);
        unitPosition.setCenterY(500);
        unitPosition.setRadius(mainBase.getPosition().getRadius());
        mainBase.setPosition(unitPosition);
        //--------------------------------------------

        //--------------------List of Players-------------------
        List <ConsolePlayer> AttackerPlayers = new ArrayList<>();
        List <ConsolePlayer> DefenderPlayers = new ArrayList<>();
        //------------------------------------------------------

        //---------------------Players--------------------------
        List <Unit> AttackerUnit = new ArrayList<>();
        List <Unit> DefenderUnit = new ArrayList<>();
        ConsolePlayer AttackerPlayer = new ConsolePlayer(1,2, AttackerUnit, 5000);
        ConsolePlayer DefenderPlayer = new ConsolePlayer(2,1, DefenderUnit, 5000);
        //------------------------------------------------------

        //--------------------Unist of players------------------
        System.out.println("\n\n\t\t\t\t-------------------BUY ATTACKER UNITSt-------------------");
        AttackerUnit = AttackerPlayer.buyUnit(this.grid);
        System.out.println("\n\t\t\t\t-------------------BUY DEFENDER UNITSt-------------------");

        DefenderUnit = DefenderPlayer.buyUnit(this.grid);
        AttackerPlayer.units=AttackerUnit;
        DefenderPlayer.units= DefenderUnit;
        mainBase.setOwner(DefenderPlayer);
        grid.addUnit(mainBase);
        //------------------------------------------------------

        //-----------------Players List-------------------------
        AttackerPlayers.add(AttackerPlayer);
        DefenderPlayers.add(DefenderPlayer);
        this.remainingAttackerUnits=0;
        for(ConsolePlayer consolePlayer: AttackerPlayers)
        {
            for (int i = 0; i < consolePlayer.units.size(); i++)
                this.remainingAttackerUnits++;
        }
        //------------------------------------------------------

        //-----------------Team initializer---------------------
        this.AttackerTeam = new AttackerTeam(AttackerPlayers);
        this.DefenderTeam = new AttackerTeam(DefenderPlayers);
        //------------------------------------------------------

        //-------------------Game State-------------------------
        GameInitializer.gameState = GameState.Paused;
        //------------------------------------------------------

        //------------------Reaminig Time-----------------------
        remainingTime = new Timeer(100);
        //------------------------------------------------------
        DoDGameManager doDGameManager = DoDGameManager.getdDoDGameManager(grid, mainBase, remainingAttackerUnits, remainingTime, AttackerTeam, DefenderTeam, gameState);
       // Revier revier = Revier.getgRevier(275,250,30,700);

    }




    
}
