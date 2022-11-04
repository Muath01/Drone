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
	
	
	
	public void DroneLocationOccupied(int[] arr, Random rand) {
		
			
			
			System.out.println("They're equafsadsfdafsddsfsfdl\n");
			w = rand.nextInt(20);
			y = rand.nextInt(20);
			
			arr[0] = w;
			arr[1] = y;
			
			
	
	}
	
	
	public void addDrone() {
		
		
		Random rand = new Random();
		
//		int w = rand.nextInt(DroneArena.h -1);
//		int y = rand.nextInt(DroneArena.w - 2);
		
		int w = rand.nextInt(2);
		int y = rand.nextInt(2);
		
		int[] arr = {w, y};
		
		

		
		boolean noDuplicates = true;
		
		while(noDuplicates) {
			
			if(drones.size() >= 1) {
				
				for(int i = 0; i < drones.size() ; i++) {
					
					if((drones.get(i)[0]) == w && drones.get(i)[1] == y) {
					System.out.println("They're equal\n");
//					w = rand.nextInt(2);
//					y = rand.nextInt(2);
//					
//					arr[0] = w;
//					arr[1] = y;
					
					DroneLocationOccupied(arr, rand);
					

					
					}else {
						System.out.println("not Equal: " + i);
						
					}	
					
				}
		drones.add(arr);
		noDuplicates = false;
	}
		
		else {
				System.out.println("size: " + drones.size());
				drones.add(arr);
				noDuplicates = false;
			}
		}
		
		
		System.out.println("-------------------------------");
		
		
		
		showDrone = true;
		noDuplicates = false;
		System.out.println("h");
		
	}

		
		void vertical(int w,int h, char border) {
			System.out.print(border);
			for(int i = 0; i < w -2 ; i++) {
				
				
				if(showDrone == true) {
					showIt(h, i, 'D');
//					System.out.print(i);
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
