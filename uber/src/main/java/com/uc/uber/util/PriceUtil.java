package com.uc.uber.util;


import com.uc.uber.domain.Location;

public class PriceUtil {
    public PriceUtil(){

    }

    public Double getPrice(Location location1,Location location2){
        DistanceUtil distanceUtil = new DistanceUtil();
        Double minRidPrice = 50.0;
        Double price = minRidPrice;
        Double totalDistance = distanceUtil.getDistance(location1,location2);
        if(totalDistance>2.0){
            price+=20.0;
            if(totalDistance>5.0){
                price+=24.0;
                price+=(totalDistance-5)*5;
                return price;
            }
            else{
                price+=(totalDistance-2)*8;
                return price;
            }
        }
        else{
            price+=totalDistance*10;
            return price;
        }

    }

}
