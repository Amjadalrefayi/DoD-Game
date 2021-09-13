package com.mycompany.app.UnitPropertiesFolder;


public class AttackDamageProperty extends UnitProperty {

    public AttackDamageProperty(double propertyValue) {
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
    

