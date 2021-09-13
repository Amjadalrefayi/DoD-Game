package com.mycompany.app;

public class UnitPosition {

    public int centerX;
    public int centerY;
    public int radius;
    public int regionX;
    public int regionY;

    public UnitPosition() {
    }

    public UnitPosition(int centerX, int centerY, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    public int getCenterX() {
        return this.centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return this.centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getRadius() {
        return this.radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UnitPosition)) {
            return false;
        }
        UnitPosition unitPosition = (UnitPosition) o;
        return centerX == unitPosition.centerX && centerY == unitPosition.centerY && radius == unitPosition.radius;
    }


    @Override
    public String toString() {
        return "{" +
            " centerX='" + getCenterX() + "'" +
            ", centerY='" + getCenterY() + "'" +
            ", radius='" + getRadius() + "'" +
            "}";
    }

    public boolean squareIsOccupied()
    {
        return false;
    }
    
}
