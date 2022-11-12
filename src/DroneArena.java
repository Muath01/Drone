package src;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author muath
 *
 */
public class DroneArena {
	
	char border = '#';
	static int w;
	static int h;
	char[][] myarr;

	ArrayList<Drone> dronesArray = new ArrayList<Drone>();
	
	Drone myDrone;
	
	public DroneArena(int w, int h) {
		this.myarr = new char[h][w];

		DroneArena.w = w;
		DroneArena.h = h;
//		this.createArena();

	}
	
	public void addDrone() {



		Random rand = new Random();

		
		// find a random number between 1-w/h-1. the 1 and -1 is so the drone isn't placed on the border. 
		int w = rand.nextInt(1, DroneArena.w -1); // 

		int y = rand.nextInt(1, DroneArena.h -1); 

		if(dronesArray.size() >= 1) { // if the arena has drones, check for duplicates. 
			isHere(dronesArray.size(), w, y, rand);

			dronesArray.add(new Drone(w, y));
			dronesArray.get(dronesArray.size() -1).droneId++;
			
		}

		else { // if there are no items in the drone. add a new drone with w and y coordinates, because there are no duplicates by definition. 
			dronesArray.add(new Drone(w, y));
			dronesArray.get(dronesArray.size() -1).droneId++;
		}

	}
	
	
	
	public void moveAllDrones() {
		dronesArray.get(dronesArray.size()-1).moveDrone(this, dronesArray);
		this.draw();
	}

	public int canGoHere(int x, int y, Directions.direction dir) {
		int status = 0;
		System.out.println("x: "+ x + " y: " + y);
		if(x < 1 || x >= w -1) status += 1;
		if(y < 1 || y >= h -1) status += 2;
		
		return status;
	}
	
	@Override
	public String toString() {
		String dronesPositions = "";
		if(dronesArray.size() == 0) {
			return "DroneArena size " + w + " by " + h + " with no Drones to display";
			
		}
		
		for(Drone d: dronesArray) {
			dronesPositions += "DroneArena size " + w + " by " + h;
			dronesPositions += "with drone" +  d.droneId + " at position " + d.droneX + ", " + d.droneY + "\n"; 
		}
		
		return dronesPositions;

}		
	
	
	
	// loops over array in consoleCanvas to show all the drones within the arena. 
	
	public void showDrones(ConsoleCanvas c) {
		for(Drone d : dronesArray) {
			d.displayDrone(c);
		}
	}




	public int getW() {
		return w;
	}


	public int getH() {
		return h;
	}

	
	public void createArena() {

		for(int i = 0; i < DroneArena.h; i++){
			for(int j = 0; j < DroneArena.w; j++){
				if(j > DroneArena.w-2 || j == 0 || i == 0 || i == DroneArena.h-1){
					myarr[i][j] = '#';
				}else{
					myarr[i][j] = ' ';
				}
			}


		}

	}
	
	
	public void draw(){

		this.createArena();
		this.showDrone();
		for(int i = 0; i < myarr.length; i++){
			System.out.println(myarr[i]);
		}
	}

	public void moveDrones(){

		try {
			for(int i = 0; i < 350; i++){
                Thread.sleep(150);
				this.moveAllDrones();
				this.draw();
			}
			
		} catch (Exception e) {
           
            // catching the exception
            System.out.println(e);
        }
	}



	

	
	// this function is invoked to find a newly place for a newly created drone who's original position is occupied. 
	public void DroneLocationOccupied(int droneSize, int w, int y, Random rand) {
		
		// create a new random position
			w = rand.nextInt(DroneArena.w - 3); 
			y = rand.nextInt(DroneArena.h - 1);
			
			
		// check again if the newly created position is occupied. 	
			isHere(droneSize,w, y,  rand);
	}
	
	
    // check if the position of the newly added drone is occupied. 
	public void isHere(int droneSize, int w, int y, Random rand) {
		
		for(int i = 0; i < dronesArray.size() ; i++) {
			
			// if yes then try to find a new place, if not then just added it to where it's original place. 
			if((dronesArray.get(i).droneY) == y && dronesArray.get(i).droneX == w) DroneLocationOccupied(droneSize,w, y, rand);}
		}

//	Vertical function draws the sides of the arena and the space with in it.

	public void showDrone() {

		for (int i = 0; i < dronesArray.size(); i++) {
			for (int j = 1; j < DroneArena.h; j++) {

				for (int k = 1; k < DroneArena.w; k++) {
					if ((j == dronesArray.get(i).droneY) && (k == dronesArray.get(i).droneX)) {
						myarr[j][k]= 'D';}}}}}

}
