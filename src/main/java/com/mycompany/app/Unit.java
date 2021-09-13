package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import com.mycompany.app.AttackStrategiesFolder.AttackStrategy;
import com.mycompany.app.GameFolder.GameInitializer;
import com.mycompany.app.GameFolder.GameState;
import com.mycompany.app.MovementFolder.Movement;
import com.mycompany.app.PlayerFolder.ConsolePlayer;
import com.mycompany.app.UnitPropertiesFolder.UnitProperty;

public class Unit implements Runnable {

    List<UnitType> canAttack = new ArrayList<>();
    Movement movement;
    ConsolePlayer owner;
    UnitPosition position;
    Unit targetUnit;
    List<UnitDestroyObserver> unitDestroyedObservers = new ArrayList<>();
    UnitType uniteType;
    UnitDestroyObserver destructionObservers;
    UnitProperty[] unitProperties = new UnitProperty[7];
    UnitType unitName;
    UnitType unitType;
    AttackStrategy attackStrategy;

    public Unit() {
    }

    public Unit(List<UnitType> canAttack, Movement movement, ConsolePlayer owner, UnitPosition position,
            Unit targetUnit, List<UnitDestroyObserver> unitDestroyedObservers, UnitType uniteType,
            UnitDestroyObserver destructionObservers, UnitProperty[] unitProperties, UnitType unitName,
            UnitType unitType) {
        this.canAttack = canAttack;
        this.movement = movement;
        this.owner = owner;
        this.position = position;
        this.targetUnit = targetUnit;
        this.unitDestroyedObservers = unitDestroyedObservers;
        this.uniteType = uniteType;
        this.destructionObservers = destructionObservers;
        this.unitProperties = unitProperties;
        this.unitName = unitName;
        this.unitType = unitType;
    }

    public List<UnitType> getCanAttack() {
        return this.canAttack;
    }

    public void setCanAttack(List<UnitType> canAttack) {
        this.canAttack = canAttack;
    }

    public Movement getMovement() {
        return this.movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public ConsolePlayer getOwner() {
        return this.owner;
    }

    public void setOwner(ConsolePlayer owner) {
        this.owner = owner;
    }

    public UnitPosition getPosition() {
        return this.position;
    }

    public void setPosition(UnitPosition position) {
        this.position = position;
    }

    public Unit getTargetUnit() {
        return this.targetUnit;
    }

    public void setTargetUnit(Unit targetUnit) {
        this.targetUnit = targetUnit;
    }

    public UnitType getUniteType() {
        return this.uniteType;
    }

    public void setUniteType(UnitType uniteType) {
        this.uniteType = uniteType;
    }

    public UnitDestroyObserver getDestructionObservers() {
        return this.destructionObservers;
    }

    public void setDestructionObservers(UnitDestroyObserver destructionObservers) {
        this.destructionObservers = destructionObservers;
    }

    public UnitProperty[] getUnitProperties() {
        return this.unitProperties;
    }

    public void setUnitProperties(UnitProperty[] unitProperties) {
        this.unitProperties = unitProperties;
    }

    public UnitType getUnitName() {
        return this.unitName;
    }

    public void setUnitName(UnitType unitName) {
        this.unitName = unitName;
    }

    public UnitType getUnitType() {
        return this.unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public Unit canAttack(List<UnitType> canAttack) {
        this.canAttack = canAttack;
        return this;
    }

    public Unit movement(Movement movement) {
        this.movement = movement;
        return this;
    }

    public Unit owner(ConsolePlayer owner) {
        this.owner = owner;
        return this;
    }

    public Unit position(UnitPosition position) {
        this.position = position;
        return this;
    }

    public Unit targetUnit(Unit targetUnit) {
        this.targetUnit = targetUnit;
        return this;
    }

    public List<UnitDestroyObserver> getUnitDestroyedObservers() {
        return this.unitDestroyedObservers;
    }

    public void setUnitDestroyedObservers(List<UnitDestroyObserver> unitDestroyedObservers) {
        this.unitDestroyedObservers = unitDestroyedObservers;
    }

    public Unit uniteType(UnitType uniteType) {
        this.uniteType = uniteType;
        return this;
    }

    public Unit destructionObservers(UnitDestroyObserver destructionObservers) {
        this.destructionObservers = destructionObservers;
        return this;
    }

    public Unit unitProperties(UnitProperty[] unitProperties) {
        this.unitProperties = unitProperties;
        return this;
    }

    public Unit unitName(UnitType unitName) {
        this.unitName = unitName;
        return this;
    }

    public Unit unitType(UnitType unitType) {
        this.unitType = unitType;
        return this;
    }

    public AttackStrategy getAttackStrategy() {
        return this.attackStrategy;

    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void AcceptDamage(double damage) {

        double health = this.unitProperties[0].getPropertyValue();

        if (this.unitProperties[1].getPropertyValue() == 0) {
            health = health - damage;
            this.unitProperties[0].setPropertyValue(health);

        } else {
            health = health - (damage - (damage * this.unitProperties[1].getPropertyValue()));
            this.unitProperties[0].setPropertyValue(health);

        }
        if (health == 0 || health < 0) {
            System.out.println(this.getUnitName() + ": IS DEAED! ");
            onDestory();
        }

    }

    public Unit AttackUnit(List<Unit> targetUnits, AttackStrategy attackStrategy) {
        List<Unit> FinalCanAttack = new ArrayList<>();

        if (targetUnits.size() == 0)
            return null;

        for (Unit unit : targetUnits) {

            if (this.getUnitName() == UnitType.BlackEagle) {
                if (unit.getUnitName() == UnitType.MAINBASE)
                    FinalCanAttack.add(unit);
            }

            else {

                if( unit.getUnitName() == UnitType.Valley)
                    continue;

              else if (unit.getOwner().teamId == this.getOwner().teamId)
                    continue;

                else {
                    for (UnitType unitType : this.getCanAttack()) {

                        if (unitType == unit.getUnitType()) {
                            FinalCanAttack.add(unit);
                        }
                    }

                }

            }

        }

        Unit FinalUnitAttack = this.attackStrategy.PrioritizeUnitToAttack(FinalCanAttack);
        if (FinalUnitAttack != null) {
            System.out.println(this.getUnitName() + "  is Attack   " + FinalUnitAttack.getUnitName());
            FinalUnitAttack.AcceptDamage(this.unitProperties[2].getPropertyValue());
            return FinalUnitAttack;
        }

        return null;

    }

    void onDestory() {



        // if(this.getOwner().teamId==2)
        //     GameInitializer.remainingAttackerUnits--;

        if(this.getUnitName() == UnitType.MAINBASE)
        {
            GameInitializer.gameState=GameState.AttackerWon;
            System.out.println( GameInitializer.gameState.toString());
        }
          

        // if(GameInitializer.remainingAttackerUnits ==0)
        // {
        //     GameInitializer.gameState = GameState.DeffenderWon;
        //     System.out.println( GameInitializer.gameState.toString());
        // }
           

        GameInitializer.grid.regions[this.getPosition().centerX
                / GameInitializer.grid.CELL_SIZE][this.getPosition().centerY / GameInitializer.grid.CELL_SIZE].units
                        .remove(this);

                
        // if(this.getOwner().teamId==2)
        // gameInitializer.remainingAttackerUnits--;

        // if(this.getUnitName() == UnitType.MAINBASE)
        // gameInitializer.gameState=GameState.AttackerWon;

        // if(gameInitializer.remainingAttackerUnits ==0)
        // gameInitializer.gameState = GameState.DeffenderWon;
    }

    @Override
    public synchronized void run() {

        while (GameInitializer.gameState == GameState.Running || GameInitializer.gameState == GameState.Paused) {
            if (this.unitProperties[0].getPropertyValue() <= 0) {
                this.onDestory();
                break;
            }
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (this.unitProperties[2].getPropertyValue() != 0) {
                if (GameInitializer.gameState == GameState.Running) {
                    this.targetUnit = this.AttackUnit(GameInitializer.grid.GetAllUnitsInRange(this),
                            this.getAttackStrategy());
                    // ---------------------Have A Target------------------------
                    if (this.targetUnit != null) {
                        try {
                            Thread.sleep((long) (1000 * this.unitProperties[4].getPropertyValue()));
                        } catch (InterruptedException e1) {
                            e1.getMessage();
                        }
                    }

                    if (GameInitializer.gameState == GameState.Running) {

                        if (this.unitProperties[5].getPropertyValue() > 0) {

                            if(Revier.CheckRevier(this) && this.getUnitName() != UnitType.BlackEagle)
                            {
                                this.getMovement().move(this, GameInitializer.mainBase, GameInitializer.grid);
                                System.out.println(this.getUnitName() + "  TeamId: " + this.getOwner().teamId
                                        + "  move to  x= " + this.getPosition().getCenterX() + "  Y= "
                                        + this.getPosition().getCenterY());
                                try {
                                    Thread.sleep((long) (10000 / this.unitProperties[5].getPropertyValue()));
                                } catch (InterruptedException e) {
    
                                    e.getMessage();
                                }
                            }
                                else
                                {
                                    this.getMovement().move(this, GameInitializer.mainBase, GameInitializer.grid);
                                    System.out.println(this.getUnitName() + "  TeamId: " + this.getOwner().teamId
                                            + "  move to  x= " + this.getPosition().getCenterX() + "  Y= "
                                            + this.getPosition().getCenterY());
                                    try {
                                        Thread.sleep((long) (1000 / this.unitProperties[5].getPropertyValue()));
                                    } catch (InterruptedException e) {
        
                                        e.getMessage();
                                    }
                                }

                            }
                           

                        }

                    }

                }

            }

        }
        // while (this.unitProperties[0].getPropertyValue() > 0) {

        // this.targetUnit =
        // this.AttackUnit(GameInitializer.grid.GetAllUnitsInRange(this),
        // this.getAttackStrategy());
        // // ---------------------Have A Target------------------------
        // while (this.targetUnit != null) {
        // System.out.println(this.getUnitName() + " is Attack " +
        // this.getTargetUnit().getUnitName());
        // try {
        // Thread.sleep((long) (10000 * this.unitProperties[4].getPropertyValue()));
        // } catch (InterruptedException e1) {
        // e1.getMessage();
        // }
        // this.targetUnit =
        // this.AttackUnit(GameInitializer.grid.GetAllUnitsInRange(this),
        // this.getAttackStrategy());
        // }
        // if (this.unitProperties[0].getPropertyValue() <= 0) {
        // return;
        // }
        // // ---------------------MOVE UNIT------------------------------
        // if (this.getUnitType() != UnitType.Structure) {
        // this.getMovement().move(this, GameInitializer.mainBase,
        // GameInitializer.grid);
        // System.out.println(this.getUnitName() + " " + "move to x= " +
        // this.getPosition().getCenterX()
        // + " Y= " + this.getPosition().getCenterY());
        // try {
        // Thread.sleep((long) (10000 / this.unitProperties[5].getPropertyValue()));
        // } catch (InterruptedException e) {

        // e.getMessage();
        // }

        // }

        // }



    // while
    // (DoDGameManager.gameState==GameState.Running||DoDGameManager.gameState==GameState.Paused){
    // if(unitProperty.getMaxHealth()<=0){
    // break;
    // }
    // try {
    // Thread.sleep(0);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // if(DoDGameManager.gameState==GameState.Running) {
    // try {
    // activeUnitAttack.Attack();
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // if(unitProperty.getMovementSpeed()>0) {
    // try {
    // movement.move();
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }

    // }
    // }
    // System.out.println("hiii");
    // List<Unit> units = new ArrayList<>();
    // UnitProperty[] unitProperty = this.getUnitProperties();
    // System.out.println("hiii");

    // units.equals(grid.GetAllUnitsInRange(this));
    // System.out.println("thbaaaaaaaaaat");

    // this.targetUnit = this.AttackUnit(units, this.getAttackStrategy());
    // System.out.println("hiii000000");
    // System.out.println(doDGameManager.hashCode());
    // while(this.getTargetUnit() ==null)
    // {

    // System.out.println("hiiiiiiii ftt 3la al while");
    // System.out.println(doDGameManager.hashCode());
    // this.movement.move(this,doDGameManager.getMainBase(), grid );
    // System.out.println("3mlt move sede");
    // System.out.println(this.getPosition().getCenterX()+ " " +
    // this.getPosition().getCenterY());
    // try {
    // Thread.sleep((long) (10000 / unitProperty[5].getPropertyValue()));
    // } catch (InterruptedException e) {

    // e.getMessage();
    // }
    // units=this.grid.GetAllUnitsInRange(this);
    // this.setTargetUnit(this.AttackUnit(units, this.getAttackStrategy()));
    // //System.out.println(this.getTargetUnit());

    // }

    // System.out.println("hinl2et wa7d");

    // // while (this.getTargetUnit().getUnitType() != UnitType.MAINBASE) {
    // // System.out.println("'iam in while looooop'");
    // // units = grid.GetAllUnitsInRange(this);
    // // if(this.AttackUnit(units, this.attackStrategy)!=null)
    // // {
    // try {
    // Thread.sleep((long) (1000 * unitProperty[4].getPropertyValue()));
    // } catch (InterruptedException e1) {
    // e1.getMessage();
    // }
    // }
    // //Unit move
    // this.movement.move(this, this.doDGameManager.getMainBase(), grid );
    // try {
    // Thread.sleep((long) (1000 / unitProperty[5].getPropertyValue()));
    // } catch (InterruptedException e) {

    // e.getMessage();
    // }
    // }

    // while(unitProperty[0].getPropertyValue()!=0)
    // {
    // units = grid.GetAllUnitsInRange(this);
    // if(this.AttackUnit(units, this.attackStrategy)!=null)
    // {
    // try {
    // Thread.sleep((long) (1000 * unitProperty[4].getPropertyValue()));
    // } catch (InterruptedException e1) {
    // e1.getMessage();
    // }
    // }

    // }

    // class MyThread extends Thread {
    // boolean suspendFlag=false;
    // public void run()
    // {

    // System.out.println("unit start: ");
    // while (this.isAlive()) {

    // synchronized (this) {
    // while (this.isSuspendFlag()) {
    // try {
    // System.out.println("suspend;");
    // wait();
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }

    // } System.out.println("runn;");
    // }
    // }

    // public synchronized void Suspend()
    // {
    // suspendFlag = true;
    // }

    // public synchronized void Resume()
    // {
    // suspendFlag = false;
    // notifyAll();
    // }

    // public boolean isSuspendFlag() {
    // return suspendFlag;
    // }

    // }

    public void print() {
    }
    

}
