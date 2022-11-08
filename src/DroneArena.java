package src;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 * @author muath
 *
 */
public class DroneArena extends Drone{
	
	char border = '#';
	static boolean showDrone = false;
	static int w;
	static int h;
	private Drone newDrone;
	
	
	public DroneArena(int w, int h) {
		super(10, 10);
		
		newDrone = new Drone(10, 16);
		DroneArena.w = w;
		DroneArena.h = h;
		this.addDrone();
		
//		this.draw();
	
	}
	public DroneArena(String s){
		super(0, 0);
		StringSplitter ss = new StringSplitter(s, ";");
		StringSplitter sbp = new StringSplitter(ss.getNth(0, "5 10"), " ");
		w = sbp.getNthInt(0, 5);
		h = sbp.getNthInt(1, 8);
		newDrone = new Drone(ss.getNth(1, "2 5"));
	}
	
	public void moveTest() {
		
		drones.get(0)[0] = 1;
		drones.get(0)[1] = 1;
		
		draw();
		
		
//		for (int i = 0; i < newDroneList.size(); i++) {
//			if((50 == newDroneList.get(i).) && 50 == newDroneList.get(i)[i]) {
//				System.out.println("we go a match");
//			}
//		}
	}
	
	public void moveArena() {
		newDrone.moveDrone(this);
	}
	
	
	public int canGoHere(int x, int y) {
		int status = 0;
		
		if(x < 0 || x >= w) status += 1;
		if(y < 0 || y >= h) status += 2;
		return status;
	}
	
	@Override
	public String toString() {
		return "DroneArena size " + w + " by " + h + " with Drone " + newDrone.droneId + " at " + newDrone.droneX + ", " + newDrone.droneY ;
	}




	public int getW() {
		return w;
	}


	public int getH() {
		System.out.println("Lets gooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		return h;
	}



	public Drone getDrone() {
		return newDrone;
	}
	
	
	
	public void draw() {
		
		
		
		horizental(DroneArena.w, border);
		
       for(int i = 0; i < DroneArena.h; i++) {
			
			
			vertical(DroneArena.w, i, border);
			
		}
		
		horizental(DroneArena.w, border);
		
		
	}
	
	public void addDrone(int w, int y) {
		
		Random rand = new Random();

		int[] arr = {y, w};
		
		String errorMessage = "The position (" + w + "," + y + ") is occupied, please choose a different coordinate";
		
	if(drones.size() >= 1) {
		
		checkForDuplicate(drones.size(), w, y, arr, errorMessage);
		drones.add(arr);
	}else {
		System.out.println("size: " + drones.size());
		drones.add(arr);
		}
	
	showDrone = true;
	
}
	

	
	public void DroneLocationOccupied(int droneSize, int w, int y, int[] arr, Random rand) {
		
			w = rand.nextInt(DroneArena.w - 3);
			y = rand.nextInt(DroneArena.h - 1);
			
			arr[0] = y;
			arr[1] = w;
			
			checkForDuplicate(droneSize,w, y, arr,  rand);
	}
	
	public void checkForDuplicate(int droneSize, int w, int y, int[] arr, String errorMessage) {
		
		for(int i = 0; i < drones.size() ; i++) {
			
			if((drones.get(i)[0]) == y && drones.get(i)[1] == w) {
			System.out.println(errorMessage);
			System.exit(y);
			
				
		}
	}
}
	
	public void checkForDuplicate(int droneSize, int w, int y, int[] arr, Random rand) {
		
		for(int i = 0; i < drones.size() ; i++) {
			
			if((drones.get(i)[0]) == y && drones.get(i)[1] == w) {
			DroneLocationOccupied(droneSize,w, y, arr, rand);
			

			
			}else {
//				System.out.println("not Equalx: " + i);
				
			}
//			System.out.println("-------------------------------");
		}
}
	
	
	public void addDrone() {
		
		
//		System.out.println("inside the add Drone function");
		
		Random rand = new Random();
		
		
		int yd = 12;
		int w = rand.nextInt(DroneArena.w - 3);
		
		int y = rand.nextInt(DroneArena.h - 1); /* we subtract 3 because we don't loop over the whole arena in our vertical function. 
												 we don't loop over the whole arena so the sides of the arena are drawn within instead of 
												 of it */
		
		
		int[] arr = {y, w};
		
		
		if(drones.size() >= 1) {
			
			
			checkForDuplicate(drones.size(), w, y, arr, rand);
			
			drones.add(arr);
			droneId++;
	}
		
		else {
//				System.out.println("size: " + drones.size());
				drones.add(arr);
				
				droneId++;
			}
		
		
		droneY = y;
		droneX = w;
		showDrone = true;
		this.draw();
		
	}
	
	

		
//	Vertical function draws the sides of the arena and the space with in it. 
		void vertical(int w,int h, char border) {
			System.out.print(border);
			for(int i = 0; i < w -2 ; i++) {
				
				
				if(showDrone == true) {
					showIt(h, i, 'D');
//					System.out.print(h);
				}else {
					System.out.print(" ");
				}
				
				
					
				}
			
			System.out.println(border);
				
			
			
		}
		
		
		void horizental(int w, char border) {
			
			for(int i = 0; i < w -1; i++) {
				
				System.out.print(border);
			}
			System.out.println(border);
		}

		

}
