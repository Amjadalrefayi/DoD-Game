package com.mycompany.app.AttackStrategiesFolder;

import java.util.List;
import com.mycompany.app.Unit;
import com.mycompany.app.UnitType;
import com.mycompany.app.UnitPropertiesFolder.UnitProperty;

public class LowestHealthAttackStrategy implements AttackStrategy {

    @Override
    public Unit PrioritizeUnitToAttack(List<Unit> units) {

        Unit LowestHealthUnit =null;
        if(units.size()!=0)
        {
            LowestHealthUnit = units.get(0);
            UnitProperty [] LowestHealthProperties = new UnitProperty[7];
            UnitProperty [] unitProperties = new UnitProperty[7];
            LowestHealthProperties=LowestHealthUnit.getUnitProperties();
            for (Unit unit : units) {
                
                if(unit.getUnitType() == UnitType.MAINBASE)
                {
                    return unit;
                }
                unitProperties = unit.getUnitProperties();
                if(unitProperties[0].getPropertyValue() < LowestHealthProperties[0].getPropertyValue())
                {
                    LowestHealthUnit=unit;
                }
            }

        }
        return LowestHealthUnit;
    }
    
}
