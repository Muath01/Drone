package src;

import java.util.Arrays;
import java.util.Random;

public class DroneArena extends Drone{
	
	char myDrone = 'X';
	char border = '-';
	static boolean showDrone = false;
	static int w;
	static int h;
	static String hello = "hello";
	
	
	public DroneArena(int w, int h) {
		super(20, 1);
		
		DroneArena.w = w;
		DroneArena.h = h;
	
	}
	
	
	
	public void draw() {
		
		
		
		horizental(DroneArena.w, border);
		
       for(int i = 0; i < DroneArena.h; i++) {
			
			
			vertical(DroneArena.w, i, border);
			
		}
		
		horizental(DroneArena.w, border);
		
		
	}
	
	public void addDrone(int w, int y) {
		
		int[] arr = {w, y};

    	
    	drones.add(arr);
    	
    	
		showDrone = true;
	}
	
	
	
	public void DroneLocationOccupied(int droneSize, int w, int y, int[] arr, Random rand) {
		
			w = DroneArena.w - 3;
			y = DroneArena.h - 1;
			
			arr[0] = y;
			arr[1] = w;
			
			checkForDuplicate(droneSize,w, y, arr,  rand);
	}
	
	public void checkForDuplicate(int droneSize, int w, int y, int[] arr, Random rand) {
		
		for(int i = 0; i < drones.size() ; i++) {
			
			if((drones.get(i)[0]) == y && drones.get(i)[1] == w) {
			System.out.println("They're equal\n");
			DroneLocationOccupied(droneSize,w, y, arr, rand);
			

			
			}else {
				System.out.println("not Equalx: " + i);
				
			}
		}
}
	
	public void addDrone() {
		
		
		Random rand = new Random();
		
		
		int w = rand.nextInt(DroneArena.w - 3);
		
		int y = rand.nextInt(DroneArena.h - 1); /* we subtract 3 because we don't loop over the whole arena in our vertical function. 
												 we don't loop over the whole arena so the sides of the arena are drawn within instead of 
												 of it */
		
		
		int[] arr = {y, w};
		
		
		if(drones.size() >= 1) {
			
			checkForDuplicate(drones.size(), w, y, arr, rand);
			
			drones.add(arr);
	}
		
		else {
				System.out.println("size: " + drones.size());
				drones.add(arr);
			}
		
		System.out.println("-------------------------------");
		
		showDrone = true;
		
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
