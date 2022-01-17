package com.uc.uber.Repository;

import com.uc.uber.domain.DriverUser;
import com.uc.uber.domain.Location;
import com.uc.uber.domain.NormalUser;
import com.uc.uber.domain.Trip;

import java.util.HashMap;

public class TripRepository {
    private HashMap<Long, Trip> tripRepository = new HashMap<>();
    private HashMap<Long,Long> tripNormalUserRepository = new HashMap<>();
    private HashMap<Long,Long> tripDriverUserRepository = new HashMap<>();
    private Long idGenerator = 1L;

    public Trip saveTrip(DriverUser driverUser, NormalUser normalUser, Location fromLocation,
                         Location toLocation,Double price){
        Trip trip = new Trip(normalUser,driverUser,price,fromLocation,toLocation);
        tripRepository.put(idGenerator,trip);
        tripNormalUserRepository.put(normalUser.getId(),idGenerator);
        tripDriverUserRepository.put(driverUser.getId(),idGenerator);
        idGenerator+=1;
        return trip;
    }
}
