package com.uc.uber.util;

import com.uc.uber.domain.Location;

public class DistanceUtil {

    public DistanceUtil(){

    }
    public Double getDistance(Location location1,Location location2){
        return  Math.sqrt((location2.getyCoordinate() -location1.getyCoordinate()) * (location2.getyCoordinate() - location1.getyCoordinate())
                + (location2.getxCoordinate() -location1.getxCoordinate()) * (location2.getxCoordinate() - location1.getxCoordinate()));
    }
}
