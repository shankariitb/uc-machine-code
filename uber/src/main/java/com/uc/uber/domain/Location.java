package com.uc.uber.domain;

public class Location {
    private int xCoordinate;
    private int yCoordinate;

    public Location(){}

    public Location(int x,int y){
        xCoordinate = x;
        yCoordinate = y;
    }

    public int getxCoordinate() { return xCoordinate; }

    public void setxCoordinate(int xCoordinate) { this.xCoordinate = xCoordinate; }

    public int getyCoordinate() { return yCoordinate; }

    public void setyCoordinate(int yCoordinate) { this.yCoordinate = yCoordinate; }

}
