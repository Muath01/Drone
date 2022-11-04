package src;

import java.util.*;
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
	
	public void addDrone() {
		
		Random rand = new Random();
		
		int w = rand.nextInt(DroneArena.h -1);
		int y = rand.nextInt(DroneArena.w -1);
		System.out.println("DW: " + DroneArena.w + " DH: " + DroneArena.h + " h: " + w + " w: " + y);
		
		int[] arr = {w, y};
		
		drones.add(arr);
		
		showDrone = true;
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
