package com.mycompany.app.GameFolder;


public enum GameState {

    Running("Running") , 
    AttackerWon("AttackerWon") ,
    DeffenderWon("DeffenderWon"),
    Paused ("Paused") ;

    public final String gamestate;

    private GameState(String gamestate) {
        this.gamestate = gamestate;
    }

}
