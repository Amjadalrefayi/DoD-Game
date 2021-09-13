package com.mycompany.app;

public class Revier {
    
    public static int x=-1;  public static int y=-1 ;  public static int length=-1 ;  public static int width=-1;


    public static Revier revier;


    public static Revier getgRevier(int x, int y , int length , int widht)
    {
        if(revier==null)
        {
            revier = new Revier(x, y , length , widht);
            return revier;
        }
        else
        return revier;
    } 


    public  Revier(int x, int y , int length , int width)
    {
        this.x=x;
        this.y=y;
        this.length=length;
        this.width=width;
    }
    public  Revier()
    {}

    public static boolean CheckRevier(Unit unit)
    {
        
        if(length==-1 || width==-1 || x==-1 || y==-1)
            return false;
        else
        {

            //Bottom Left coordinate of (reiver) rectangle.
            int p1_X= x - (length/2);
            int p1_Y= y - (width/2);
            
            //Top Right coordinate of (reiver) rectangle.
            int p2_X= x + (length/2);
            int p2_Y= y + (width/2);

            //Bottom Left coordinate of (Unit) rectangle.
            int p3_X= unit.getPosition().centerX - unit.position.radius;
            int p3_Y= unit.getPosition().centerY - unit.position.radius;

            //Top Right coordinate of (Unit) rectangle.
            int p4_X= unit.getPosition().centerX + unit.position.radius;
            int p4_Y= unit.getPosition().centerY + unit.position.radius;

            //if there any overlap (if the unit is inside the reiver)
            if( p1_X>p4_X || p1_Y>p4_Y || p3_X>p2_X || p3_Y>p2_Y )
            {
                return false;
            }
            else
                return true;


        }

    }

}
