package com.mycompany.app.UnitPropertiesFolder;

public class AttackRangeProperty extends UnitProperty {

    public AttackRangeProperty(double propertyValue) {
        super(propertyValue);
    }
    @Override
    public double getPropertyValue()
    {
        return this.propertyValue;
    }
    @Override
    public void setPropertyValue(double propertyValue)
    {
        this.propertyValue=propertyValue;
    }
    
}
