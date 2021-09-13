package com.mycompany.app.MovementFolder;

import com.mycompany.app.Grid;
import com.mycompany.app.Unit;

public class DefenderMovement extends Movement {
    @Override
    public void move(Unit unit , Unit base , Grid g) {
       
        //Unit 
        int x = unit.getPosition().centerX;
        int y = unit.getPosition().centerY;
        //Base
        int base_x=base.getPosition().centerX;
        int base_y=base.getPosition().centerY;
        //temp
        int x1=x;
        int y1=y;
        if(base_x!=x)
        {
            if(base_x>x)
                x1+=1;
            else if(base_x<x)
                x1-=1;
        }

        if(base_y!=y)
        {
            if(base_y>y)
                y1+=1;
            else
                y1-=1;
        }
        
        if(g.AcceptUnitMovement(unit, x1, y1))
        {
            //when I change the range(x,y)
            if( x1/g.CELL_SIZE != x/g.CELL_SIZE && y1/g.CELL_SIZE != y/g.CELL_SIZE)
            {
                g.regions[x/g.CELL_SIZE][y/g.CELL_SIZE].units.remove(unit);
                g.regions[x1/g.CELL_SIZE][y1/g.CELL_SIZE].units.add(unit);
            }
            //when I change the range (x)
            else if( x1/g.CELL_SIZE != x/g.CELL_SIZE)
            {
                g.regions[x/g.CELL_SIZE][y/g.CELL_SIZE].units.remove(unit);
                g.regions[x1/g.CELL_SIZE][y/g.CELL_SIZE].units.add(unit);
            }
            //when I change the range (y)
            else if( y1/g.CELL_SIZE != y/g.CELL_SIZE)
            {
                g.regions[x/g.CELL_SIZE][y/g.CELL_SIZE].units.remove(unit);
                g.regions[x/g.CELL_SIZE][y1/g.CELL_SIZE].units.add(unit);
            }

            unit.getPosition().setCenterX(x1);
            unit.getPosition().setCenterY(y1);
        }



        else    //to test the 8 places around the unit
        {
            //System.out.println("ana ftt 3l else ***********************************************");
            int[] temp_x={x-1,x,x+1};
            int[] temp_y={y-1,y,y+1};
            boolean q=false;
            for(int i=0 ; i<3 ; i++)
            {
                x1=temp_x[i];
                for(int j=0 ; j<3; j++)
                {   
                    
                    y1=temp_y[j];
                    //System.out.println("the second x1 y1 "+x1 +" " +y1);
                    if(g.AcceptUnitMovement(unit, x1, y1))
                    {
                        //if(g.AcceptUnitMovement(unit, x1, y1))
                        //{
                            
                            //when I change the range(x,y)
                            if( x1/g.CELL_SIZE != x/g.CELL_SIZE && y1/g.CELL_SIZE != y/g.CELL_SIZE)
                            {
                                g.regions[x/g.CELL_SIZE][y/g.CELL_SIZE].units.remove(unit);
                                g.regions[x1/g.CELL_SIZE][y1/g.CELL_SIZE].units.add(unit);
                            }
                            //when I change the range (x)
                            else if( x1/g.CELL_SIZE != x/g.CELL_SIZE)
                            {
                                g.regions[x/g.CELL_SIZE][y/g.CELL_SIZE].units.remove(unit);
                                g.regions[x1/g.CELL_SIZE][y/g.CELL_SIZE].units.add(unit);
                            }
                            //when I change the range (y)
                            else if( y1/g.CELL_SIZE != y/g.CELL_SIZE)
                            {
                                g.regions[x/g.CELL_SIZE][y/g.CELL_SIZE].units.remove(unit);
                                g.regions[x/g.CELL_SIZE][y1/g.CELL_SIZE].units.add(unit);
                            }
                            unit.getPosition().setCenterX(x1);
                            unit.getPosition().setCenterY(y1);
                       // }
                    }
                    else {}   //System.out.println("mamshi al7al");
                }
                //if(q=true)
                  //  break;
            }
            //after getting the x1 and y1 from around me :)
            
        }
    }
    @Override
    public String toString() {
       // System.out.println("ana attack");
        return "ana attack";
    }
}
