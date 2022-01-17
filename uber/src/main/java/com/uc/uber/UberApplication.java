package com.uc.uber;

import com.uc.uber.Repository.DriverUserRepository;
import com.uc.uber.Repository.NormalUserRepository;
import com.uc.uber.Repository.TripRepository;
import com.uc.uber.domain.DriverUser;
import com.uc.uber.domain.Location;
import com.uc.uber.domain.NormalUser;
import com.uc.uber.domain.Trip;
import com.uc.uber.util.PriceUtil;

import java.util.Scanner;


public class UberApplication {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		boolean loop = true;
		DriverUserRepository driverUserRepository = new DriverUserRepository();
		NormalUserRepository normalUserRepository = new NormalUserRepository();
		TripRepository tripRepository = new TripRepository();
		PriceUtil priceUtil = new PriceUtil();

		try {
			while (loop) {
				System.out.println("Please input a line");
				line = scanner.nextLine();
				String[] splitStr = line.split(",");
				switch (splitStr[0]){
					case "1":
						System.out.println("RegisterNormalUserCase");
						normalUserRepository.saveUser(splitStr);
						break;
					case "2":
						System.out.println("RegisterDriverUserCase");
						driverUserRepository.saveUser(splitStr);
						break;
					//book a cab
					case "3":
						System.out.println("BookCabCase");
						NormalUser normalUser = normalUserRepository.findById(Long.parseLong(splitStr[1]));
						DriverUser driverUser = driverUserRepository.checkForDriver(normalUser,Double.parseDouble(splitStr[4]));
						Location toLocation = new Location();
						toLocation.setxCoordinate(Integer.parseInt(splitStr[2]));
						toLocation.setyCoordinate(Integer.parseInt(splitStr[3]));
						Double price = priceUtil.getPrice(normalUser.getLocation(),toLocation);
						Trip trip = tripRepository.saveTrip(driverUser,normalUser,normalUser.getLocation(),toLocation,price);
						driverUserRepository.updateRideInProgressStatus(driverUser.getId());
						normalUserRepository.upDateUserStatus(normalUser.getId());
						break;
					//This will be some anotherAPI
					case "4":
						System.out.println("UpdateNormalUserLocation");
						Location location = new Location();
						location.setxCoordinate(Integer.parseInt(splitStr[2]));
						location.setyCoordinate(Integer.parseInt(splitStr[3]));
//						normalUserRepository.upDateLocation(location)
						break;
					case "5":
						System.out.println("UpdateDriverLocation");
					default:
						loop = false;
						break;
				}


			}
		} catch(IllegalStateException e) {
			System.out.println("System.in was closed; exiting");
		}
		System.out.println("processEnded");
	}

}
