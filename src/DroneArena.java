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


//		System.out.println("inside the add Drone function");

		Random rand = new Random();


		int w = rand.nextInt(1 , DroneArena.w - 3);

		int y = rand.nextInt(1, DroneArena.h - 1); /* we subtract 3 because we don't loop over the whole arena in our vertical function.
												 we don't loop over the whole arena so the sides of the arena are drawn within instead of
												 of it */

		if(dronesArray.size() >= 1) {
			checkForDuplicate(dronesArray.size(), w, y, rand);

			dronesArray.add(new Drone(w, y));
			dronesArray.get(dronesArray.size() -1).droneId++;
			
		}

		else {
			dronesArray.add(new Drone(w, y));
			dronesArray.get(dronesArray.size() -1).droneId++;
		}

	}
	
	
	
	public void moveArena() {
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
		
		if(dronesArray.size() == 0) {
			return "DroneArena size " + w + " by " + h + " with no Drones to display";
			
		}
			return "DroneArena size " + w + " by " + h + " with Drone " + dronesArray.get(dronesArray.size() -1).droneId + " at " + dronesArray.get(dronesArray.size() -1).droneX + ", " + dronesArray.get(dronesArray.size() -1).droneY ;
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
				this.moveArena();
				this.draw();
			}
			
		} catch (Exception e) {
           
            // catching the exception
            System.out.println(e);
        }
	}



	
	public void addDrone(int w, int y) {

		Random rand = new Random();
		int[] arr = {y, w};
		
		String errorMessage = "The position (" + w + "," + y + ") is occupied, please choose a different coordinate";
		
	if(dronesArray.size() >= 1) {
		
		checkForDuplicate(dronesArray.size(), w, y, errorMessage);
		dronesArray.add(new Drone(y, w));
	}else {
		System.out.println("size: " + dronesArray.size());
		dronesArray.add(new Drone(y, w));
		}
	
	showDrone();
	
}
	

	
	public void DroneLocationOccupied(int droneSize, int w, int y, Random rand) {
		
			w = rand.nextInt(DroneArena.w - 3);
			y = rand.nextInt(DroneArena.h - 1);
			
//			arr[0] = y;
//			arr[1] = w;
			
			checkForDuplicate(droneSize,w, y,  rand);
	}
	
	public void checkForDuplicate(int droneSize, int w, int y, String errorMessage) {
		
		for(int i = 0; i < dronesArray.size() ; i++) {
			
			if((dronesArray.get(i).droneY) == y && dronesArray.get(i).droneX == w) {
			System.out.println(errorMessage);
			System.exit(y);
			
				
		}
	}
}
	
	public void checkForDuplicate(int droneSize, int w, int y, Random rand) {
		
		for(int i = 0; i < dronesArray.size() ; i++) {
			
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
