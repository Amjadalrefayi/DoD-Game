package com.mycompany.app.GameFolder;

public class Timeer extends Thread {
    int second;

    public Timeer(int second) {
        this.second = second;
    }

    public void run() {
        while (second != 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            if (GameInitializer.gameState == GameState.AttackerWon || GameInitializer.gameState == GameState.DeffenderWon) {

                break;
            }
            while (GameInitializer.gameState == GameState.Paused) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            second--;
        }

        if (second == 0) {
            GameInitializer.gameState = GameState.DeffenderWon;
            System.out.println(GameInitializer.gameState.toString());

        }
    }
}
