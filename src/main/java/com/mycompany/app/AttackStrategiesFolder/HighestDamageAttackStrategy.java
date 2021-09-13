package com.mycompany.app.AttackStrategiesFolder;

import java.util.List;
import com.mycompany.app.Unit;
import com.mycompany.app.UnitType;
import com.mycompany.app.UnitPropertiesFolder.UnitProperty;


public class HighestDamageAttackStrategy implements AttackStrategy {

    @Override
    public Unit PrioritizeUnitToAttack(List<Unit> units) {

        Unit HighestDamageUnit =null;

        if(units.size()!=0)
        {
           
             HighestDamageUnit = units.get(0);
            UnitProperty [] HighestDamageunitProperties = new UnitProperty[7];
            UnitProperty [] unitProperties = new UnitProperty[7];
            HighestDamageunitProperties=HighestDamageUnit.getUnitProperties();
            for (Unit unit : units) {
                if(unit.getUnitType() == UnitType.MAINBASE)
                {
                    return unit;
                }
                unitProperties = unit.getUnitProperties();
                if(unitProperties[2].getPropertyValue() > HighestDamageunitProperties[2].getPropertyValue())
                {
                    HighestDamageUnit=unit;
                }
            }

        }
      
        return HighestDamageUnit;
    }
    
}
