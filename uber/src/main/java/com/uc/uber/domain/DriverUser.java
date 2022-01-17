package com.uc.uber.domain;


import com.uc.uber.enums.DriverUserStatus;

public class DriverUser extends User {
    public DriverUserStatus getStatus() {
        return status;
    }

    public void setStatus(DriverUserStatus status) {
        this.status = status;
    }

    private DriverUserStatus status;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private Location location;


}
