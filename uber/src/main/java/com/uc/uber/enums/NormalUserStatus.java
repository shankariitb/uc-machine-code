package com.uc.uber.enums;

public enum NormalUserStatus {

    IDLE("idle"),SEARCHING_FOR_CAB("searching_for_cab"),IN_RIDE("in_ride");
    private String status;

    NormalUserStatus(String status){
        this.status = status;
    }
}
