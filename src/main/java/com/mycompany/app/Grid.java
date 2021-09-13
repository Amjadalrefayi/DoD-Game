package com.mycompany.app;

import java.util.ArrayList;
import com.mycompany.app.UnitPropertiesFolder.UnitProperty;


public class Grid {
    //Inner class
    public class Region{
        public ArrayList<Unit> units = new ArrayList<>(); 
    }
    //Attribute:
    public int NUM_CELLS=100;
    public int CELL_SIZE=100;
    public int AaA=(NUM_CELLS*NUM_CELLS) / (CELL_SIZE*CELL_SIZE); //number of regions in the grid
    public Region regions[][];
    private static Grid grid ;
    //method:
    public Grid(){
        
    }
    public static Grid getGrid(int NUM_CELLS , int CELL_SIZE)
    {
        if(grid==null)
        {
            grid = new Grid(NUM_CELLS, CELL_SIZE);
            return grid;
        }
  
        else
        return grid;
    }
    private Grid( int NUM_CELLS , int CELL_SIZE)
    {
        this.NUM_CELLS=NUM_CELLS;
        this.CELL_SIZE=CELL_SIZE;
        AaA=(NUM_CELLS*NUM_CELLS) / (CELL_SIZE*CELL_SIZE);
        regions=new Region[AaA][AaA];
        for(int i=0 ; i<AaA ; i++)
        {
            for(int j=0 ; j<AaA ; j++)
            {
                regions[i][j]=new Region();
            }
        }
    }
    

    public int getNUM_CELLS() {
        return this.NUM_CELLS;
    }

    public void setNUM_CELLS(int NUM_CELLS) {
        this.NUM_CELLS = NUM_CELLS;
    }

    public int getCELL_SIZE() {
        return this.CELL_SIZE;
    }

    public void setCELL_SIZE(int CELL_SIZE) {
        this.CELL_SIZE = CELL_SIZE;
    }



    private boolean isPointIncircle( int Xcircle ,int Ycircle , int raduis , int x ,int y )
    {
        return((Xcircle - x)*(Xcircle - x) + (Ycircle - y)*(Ycircle - y) <= raduis*raduis);
    }

    public ArrayList<Unit> GetAllUnitsInRange(Unit unit)
    {
        // int x = unit.position.centerX/CELL_SIZE;
        // int y = unit.position.centerY/CELL_SIZE;
        ArrayList<Unit> AllUnitsInRange = new ArrayList<>();
        UnitProperty []unitProperties = new UnitProperty [7];
        unitProperties = unit.getUnitProperties();

        for (int i=0 ; i< AaA ;i++) //to check all units in all regions 
            for(int j=0;j<AaA;j++)
                 for (int k = 0; k < regions[i][j].units.size(); k++)
                    {
                        
                        if((isPointIncircle(unit.position.centerX, unit.position.centerY,(int)unitProperties[3].getPropertyValue(), 
                        regions[i][j].units.get(k).position.centerX, regions[i][j].units.get(k).position.centerY)) || 
                        (isPointIncircle(unit.getPosition().centerX  , unit.getPosition().centerY,(int)unitProperties[3].getPropertyValue(), 
                        regions[i][j].units.get(k).getPosition().centerX - regions[i][j].units.get(k).getPosition().radius , regions[i][j].units.get(k).getPosition().centerY - regions[i][j].units.get(k).getPosition().radius))
                        || (isPointIncircle(unit.getPosition().centerX  , unit.getPosition().centerY,(int)unitProperties[3].getPropertyValue(), 
                        regions[i][j].units.get(k).getPosition().centerX + regions[i][j].units.get(k).getPosition().radius , regions[i][j].units.get(k).getPosition().centerY - regions[i][j].units.get(k).getPosition().radius))
                        ||(isPointIncircle(unit.getPosition().centerX  , unit.getPosition().centerY,(int)unitProperties[3].getPropertyValue(), 
                        regions[i][j].units.get(k).getPosition().centerX - regions[i][j].units.get(k).getPosition().radius , regions[i][j].units.get(k).getPosition().centerY + regions[i][j].units.get(k).getPosition().radius))
                        ||(isPointIncircle(unit.getPosition().centerX  , unit.getPosition().centerY,(int)unitProperties[3].getPropertyValue(), 
                        regions[i][j].units.get(k).getPosition().centerX + regions[i][j].units.get(k).getPosition().radius , regions[i][j].units.get(k).getPosition().centerY + regions[i][j].units.get(k).getPosition().radius)))
                        //if it's in range add it
                        {
                            AllUnitsInRange.add(regions[i][j].units.get(k));
                           // System.out.println(regions[i][j].units.get(k).getUnitName());
                        }
                           
                    }

        return AllUnitsInRange;
    }

    public void addUnit (Unit unit) 
    { 
        if(AcceptUnitMovement(unit , unit.position.centerX , unit.position.centerY))
            regions[unit.position.centerX/CELL_SIZE][unit.position.centerY/CELL_SIZE].units.add(unit);
        else
            System.out.println("you cant do that dode");//the unit can not be in that x,y
    }

    public boolean AcceptUnitMovement( Unit unit , int x , int y)
    {
        boolean bbb=false;
        int regionX=unit.getPosition().centerX /CELL_SIZE;
        //System.out.println("region x "+regionX);
        int regionY=unit.getPosition().centerY /CELL_SIZE;
        //System.out.println("region y "+regionY);
        //x,y for the new unit 
        int P_X1= unit.getPosition().centerX - unit.position.radius;
        int P_Y1= unit.getPosition().centerY - unit.position.radius;
        //System.out.println(P_X1 + P_Y1);
        //x,y for the new unit (END x,y)
        int P_X2= unit.getPosition().centerX + unit.position.radius;
        int P_Y2= unit.getPosition().centerY + unit.position.radius;
        //System.out.println(P_X2 + P_Y2);
        
        //if the size of unit in one region
        if(P_X1/CELL_SIZE == regionX && P_Y1/CELL_SIZE == regionY 
        && P_X2/CELL_SIZE == regionX && P_Y2/CELL_SIZE == regionY) 
        {
            for (int i = 0; i < regions[regionX][regionY].units.size(); i++) 
            {
                //System.out.println("the kind is " +regions[regionX][regionY].units.get(i).getUnitName().toString());
                if((regions[regionX][regionY].units.get(i).getPosition().centerX == unit.getPosition().centerX 
                && regions[regionX][regionY].units.get(i).getPosition().centerY == unit.getPosition().centerY
                && regions[regionX][regionY].units.get(i).getPosition().radius == unit.getPosition().radius
                && regions[regionX][regionY].units.get(i).owner == unit.owner
                && regions[regionX][regionY].units.get(i).getAttackStrategy() == unit.attackStrategy))
                    {
                        //System.out.println("ana 3m karen 7ale ###########################");
                        continue;//if Iam compaire with my self
                    }
                int P_R=regions[regionX][regionY].units.get(i).position.radius;
                //x,y for the each region unit 
                int P_X3=regions[regionX][regionY].units.get(i).position.centerX - P_R;
                int P_Y3=regions[regionX][regionY].units.get(i).position.centerY - P_R;
                //x,y for the each region unit (END x,y)
                int P_X4=regions[regionX][regionY].units.get(i).position.centerX + P_R;
                int P_Y4=regions[regionX][regionY].units.get(i).position.centerY + P_R;
                //to check if there any overlap in square
                if(P_X3 > P_X2 || P_Y3 > P_Y2 || P_X1> P_X4 || P_Y1> P_Y4)
                {
                    //do nothing 
                }
                else
                {
                    if(unit.getPosition().centerX == x && unit.getPosition().centerY == y){
                        
                        return false;
                    }
                    else {
                        bbb=true;
                        //System.out.println("****************************************");
                        break;
                    }
                }
            }
            if(bbb==false)
           //System.out.println("aana 7rd true");
                return true;
            
        }
        
        //if not check the x and y 
        //else
        //{
            if(unit.getPosition().centerX == x && unit.getPosition().centerY == y) //if the unit is not moveing (using the fun for add)
            {
                return false;
            }
            else//the unit is moving to new region I'll check if there overlap
            {
                int P_X5= x - unit.getPosition().radius;
                int P_Y5= y - unit.getPosition().radius;

                int P_X6= x + unit.getPosition().radius;
                int P_Y6= y + unit.getPosition().radius;
                for (int i = 0; i < regions[x/CELL_SIZE][y/CELL_SIZE].units.size(); i++) 
                {
                    if((regions[regionX][regionY].units.get(i).getPosition().centerX == unit.getPosition().centerX 
                && regions[regionX][regionY].units.get(i).getPosition().centerY == unit.getPosition().centerY
                && regions[regionX][regionY].units.get(i).getPosition().radius == unit.getPosition().radius
                && regions[regionX][regionY].units.get(i).owner == unit.owner
                && regions[regionX][regionY].units.get(i).getAttackStrategy() == unit.attackStrategy))
                    {
                        //System.out.println("ana 3m karen 7ale ###########################");
                        continue;//if Iam compaire with my self
                    }
                    int P_R=regions[x/CELL_SIZE][y/CELL_SIZE].units.get(i).position.radius;
                    //x,y for the each region unit 
                    int P_X3=regions[x/CELL_SIZE][y/CELL_SIZE].units.get(i).position.centerX - P_R;
                    int P_Y3=regions[x/CELL_SIZE][y/CELL_SIZE].units.get(i).position.centerY - P_R;
                    //x,y for the each region unit (END x,y)
                    int P_X4=regions[x/CELL_SIZE][y/CELL_SIZE].units.get(i).position.centerX + P_R;
                    int P_Y4=regions[x/CELL_SIZE][y/CELL_SIZE].units.get(i).position.centerY + P_R;
                    //to check if there any overlap in square
                    if(P_X3 > P_X6 || P_Y3 > P_Y6 || P_X5> P_X4 || P_Y5> P_Y4)
                    {
                        //do nothing 
                    }
                    else
                    {
                        //System.out.println("reeeeeeeeeeeeeeturn false ");
                        return false;
                    }
                }
                //System.out.println("hon 3m rd false");
                return true;
            }
            
        //}
        //System.out.println("return trueb963963 ");
        //return false;
    }
}
