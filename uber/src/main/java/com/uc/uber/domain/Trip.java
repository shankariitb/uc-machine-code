package com.uc.uber.domain;

import com.uc.uber.enums.TripStatus;

public class Trip {
    private NormalUser normalUser;
    private DriverUser driverUser;
    private TripStatus status;
    private Double price;
    private Location fromLocation;
    private Location toLocation;


    public Trip(NormalUser normalUser,DriverUser driverUser,Double price,Location fromLocation,Location toLocation){
        this.normalUser = normalUser;
        this.driverUser = driverUser;
        this.status = TripStatus.INPROGRESS;
        this.price = price;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;

    }

    public NormalUser getNormalUser() {
        return normalUser;
    }

    public void setNormalUser(NormalUser normalUser) {
        this.normalUser = normalUser;
    }

    public DriverUser getDriverUser() {
        return driverUser;
    }

    public void setDriverUser(DriverUser driverUser) {
        this.driverUser = driverUser;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Location fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public void setToLocation(Location toLocation) {
        this.toLocation = toLocation;
    }
}
