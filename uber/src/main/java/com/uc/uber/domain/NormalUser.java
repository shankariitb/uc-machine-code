package com.uc.uber.domain;

import com.uc.uber.enums.NormalUserStatus;

public class NormalUser extends User{

    private NormalUserStatus status;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private Location location;

    public NormalUserStatus getStatus() { return status; }

    public void setStatus(NormalUserStatus status) { this.status = status; }

}
