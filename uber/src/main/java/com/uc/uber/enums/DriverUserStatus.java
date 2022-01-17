package com.uc.uber.enums;

public enum DriverUserStatus {

    IDLE("idle"),SEARCHING_FOR_RIDE("searching_for_cab"),IN_RIDE("in_ride");
    private String status;

    DriverUserStatus(String status){
        this.status = status;
    }
}
