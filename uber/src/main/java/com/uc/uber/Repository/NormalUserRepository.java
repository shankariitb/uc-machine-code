package com.uc.uber.Repository;

import com.uc.uber.domain.DriverUser;
import com.uc.uber.domain.Location;
import com.uc.uber.domain.NormalUser;
import com.uc.uber.enums.NormalUserStatus;

import java.util.HashMap;

public class NormalUserRepository {
    private HashMap<Long, NormalUser> normalUserRepository;
    private Long idGenerator=1L;

    public  NormalUserRepository(){
        normalUserRepository = new HashMap<>();
    }

    //    Current Assumption is if user requesting for a ride he is valid user
    public NormalUser findById(Long id){
        return normalUserRepository.get(id);
    }


    public void saveUser(String[] splitStr) {
        NormalUser normalUser = new NormalUser();
        normalUser.setStatus(NormalUserStatus.IDLE);
        //This step Will be handled by DB in real-world
        normalUser.setId(idGenerator);
        idGenerator+=1;
        normalUser.setName(splitStr[1]);
        Location location = new Location();
        location.setxCoordinate(Integer.parseInt(splitStr[2]));
        location.setyCoordinate(Integer.parseInt(splitStr[3]));
        normalUser.setLocation(location);
        System.out.println("saved as id" + (idGenerator-1));
        normalUserRepository.put(normalUser.getId(),normalUser);
//        normalUserRepository.save(normalUser);
    }

    public void upDateUserStatus(Long id){
        normalUserRepository.get(id).setStatus(NormalUserStatus.IN_RIDE);
    }
}
