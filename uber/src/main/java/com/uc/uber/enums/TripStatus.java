package com.uc.uber.enums;

public enum TripStatus {
    FINISHED("finished"),INPROGRESS("in_progress");
    private String status;

    TripStatus(String status){
        this.status = status;
    }
}
