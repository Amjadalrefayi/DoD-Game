package com.mycompany.app.UnitPropertiesFolder;

abstract public class UnitProperty
 {
    protected double propertyValue;
    
    public UnitProperty(double propertyValue)
    {
        this.propertyValue = propertyValue;
    }
        abstract public double getPropertyValue();

        abstract public void setPropertyValue(double propertyValue);


    @Override
    public String toString() {
        return "{" +
            " propertyValue='" + getPropertyValue() + "'" +
            "}";
    }
    
 }
   
