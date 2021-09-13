package com.mycompany.app.PlayerFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mycompany.app.Grid;
import com.mycompany.app.Unit;
import com.mycompany.app.UnitFactory;
import com.mycompany.app.UnitPosition;
import com.mycompany.app.UnitType;
import com.mycompany.app.AttackStrategiesFolder.AttackStrategy;
import com.mycompany.app.AttackStrategiesFolder.HighestDamageAttackStrategy;
import com.mycompany.app.AttackStrategiesFolder.LowestHealthAttackStrategy;
import com.mycompany.app.MovementFolder.AttackerMovement;
import com.mycompany.app.MovementFolder.DefenderMovement;
import com.mycompany.app.MovementFolder.Movement;
import com.mycompany.app.UnitPropertiesFolder.UnitProperty;


public class ConsolePlayer {


    public int teamId;
    public int coins;
    public int id ;
    public List <Unit> units = new ArrayList<>();

    public ConsolePlayer() {
        
    }
    

    public ConsolePlayer(int id, int teamId, List<Unit> units, int coins) {
        this.id = id;
        this.teamId =teamId;
        this.units = units;
        this.coins = coins;
    }

    public List<Unit> buyUnit(Grid grid) {
        
        Scanner input = new Scanner(System.in);
        List<Unit> Units = new ArrayList<>();
        int coins=this.coins;
        // System.out.println(java.util.Arrays.asList(UnitType.values()));
        while (coins != 0) {
            int i = 0;
            UnitType myType = UnitType.Tank;
            String menu = "\n1-TeslaTank\t2-Sniper\t3-MirageTank\t4-Infantry\t5-GrizzlyTank\t6-NavySEAL\t7-TankDestroyer\n\n8-PrismTank\t9-Pillbox\t10-PrismTower\t11-GrandCannon\t12-BlackEagle\t13-PatriotMissileSystem\t14-Valley\n15-EXIT";
            System.out.println(menu);
            int UnitChoic = input.nextInt();
            switch(UnitChoic)
            {
                case 1 :
                myType = UnitType.TeslaTank;
                break;

                case 2 :
                myType = UnitType.Sniper;

                break;

                case 3 :
                myType = UnitType.MirageTank;

                break;

                case 4 :
                myType = UnitType.Infantry;

                break;

                case 5 :
                myType = UnitType.GrizzlyTank;

                break;

                case 6 :
                myType = UnitType.NavySEAL;

                break;

                case 7 :
                myType = UnitType.TankDestroyer;

                break;

                case 8 :
                myType = UnitType.PrismTank;

                break;

                case 9 :
                myType = UnitType.Pillbox;

                break;

                case 10 :
                myType = UnitType.PrismTower;

                break;

                case 11 :
                myType = UnitType.GrandCannon;

                break;

                case 12 :
                myType = UnitType.BlackEagle;

                break;

                case 13 :
                myType = UnitType.PatriotMissileSystem;

                break;


                case 14 :
                myType = UnitType.Valley;

                break ;

                case 15:
                return Units;
            

                default:
       
            }
            Unit myUnit = new Unit();
            UnitFactory unitFactory = new UnitFactory();
            if(myType == UnitType.Valley)
            {
                myUnit = unitFactory.CreateUnit(myType,null);
                System.out.println("Enter X and Y:");
                int x= input.nextInt();
                int y= input.nextInt();
                UnitPosition unitPosition = new UnitPosition();
                unitPosition.setCenterX(x);
                unitPosition.setCenterY(y);
                unitPosition.setRadius(myUnit.getPosition().getRadius());
                myUnit.setPosition(unitPosition);
                if(grid.AcceptUnitMovement(myUnit, x, y)){
                    grid.addUnit(myUnit);
                }
                else
                {
                    System.out.println("You Can't add Unit Here");
                }


            }
        
            else{
            System.out.println("Enter Your Strategy:\n1-HighestDamageAttackStrategy\n2-LowestHealthAttackStrategy");
            int choice = input.nextInt();
            AttackStrategy attackStrategy;
            if(choice == 1)
                 attackStrategy = new HighestDamageAttackStrategy();
            else
                 attackStrategy = new LowestHealthAttackStrategy();       
            myUnit = unitFactory.CreateUnit(myType,attackStrategy);
            System.out.println("Enter X and Y:");
            int x= input.nextInt();
            int y= input.nextInt();
            UnitPosition unitPosition = new UnitPosition();
            unitPosition.setCenterX(x);
            unitPosition.setCenterY(y);
            unitPosition.setRadius(myUnit.getPosition().getRadius());
            myUnit.setPosition(unitPosition);

            if(grid.AcceptUnitMovement(myUnit, x, y))
            {
                if(this.teamId == 1)
                {
                    Movement movement = new DefenderMovement();
                    myUnit.setMovement(movement);
                }
                else{
                    Movement movement = new AttackerMovement();
                    myUnit.setMovement(movement);      
                }
                UnitProperty[] unitProperties = new UnitProperty[7];
                unitProperties = myUnit.getUnitProperties();
                double price = unitProperties[6].getPropertyValue();
                System.out.println("The price is: " + price);
                if (coins < price || coins < 0) {
                    System.out.println("Your coins is less than the price ");
                } else {
                    coins = coins - (int) price;
                    this.coins = coins;
                    myUnit.setOwner(this);
                    grid.addUnit(myUnit);
                    Units.add(myUnit);
                    System.out.println("Your coins is: " + coins);
                }

            }
            else
            {
                System.out.println("You Can't add Unit Here");
            }
        }
          
        }

        return Units;
    }
    

}
