package com.uc.uber.Repository;

import com.uc.uber.domain.DriverUser;
import com.uc.uber.domain.Location;
import com.uc.uber.domain.NormalUser;
import com.uc.uber.enums.DriverUserStatus;
import com.uc.uber.util.DistanceUtil;

import java.util.HashMap;

public class DriverUserRepository {
    private HashMap<Long, DriverUser> driverUserRepository = new HashMap<>();
    private Long idGenerator = 1L;


//    Current Assumption is if driver requesting for a ride he is valid driver
    public DriverUser findById(Long id){
        return driverUserRepository.get(id);
    }

    public void saveUser(String[] splitStr){
        DriverUser driverUser = new DriverUser();
        driverUser.setStatus(DriverUserStatus.IDLE);
        //This step Will be handled by DB in real-world
        driverUser.setId(idGenerator);
        idGenerator+=1;
        driverUser.setName(splitStr[1]);
        Location location = new Location();
        location.setxCoordinate(Integer.parseInt(splitStr[2]));
        location.setyCoordinate(Integer.parseInt(splitStr[3]));
        driverUser.setLocation(location);
        System.out.println("saved as id" + (idGenerator-1));
        driverUserRepository.put(driverUser.getId(),driverUser);
    }

    public DriverUser checkForDriver(NormalUser normalUser,Double locationDiff){
        DistanceUtil distanceUtil = new DistanceUtil();
        for(DriverUser user :driverUserRepository.values()){
            if(user.getStatus() == DriverUserStatus.SEARCHING_FOR_RIDE && checkIfValidDifference(user.getLocation(),normalUser.getLocation(),locationDiff,distanceUtil)){
                return user;
            }
        }
        return null;
    }

    public boolean checkIfValidDifference(Location location1,Location location2,Double limit,DistanceUtil distanceUtil){
        return limit >= distanceUtil.getDistance(location1,location2);
    }

    public void updateRideInProgressStatus(Long id){
        driverUserRepository.get(id).setStatus(DriverUserStatus.IN_RIDE);
    }


}
