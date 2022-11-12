package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import src.Directions.direction;

import java.util.*;

public class Drone {
	
	int droneX, droneY, droneId, dy, dx; // droneX & droneY are the positions of the drone, 
	DroneArena arena;
	Directions.direction droneDirection;
	private static int counter;

	

	public Drone(int x, int y) {
		
		droneX = x;
		droneY = y;
		this.droneId = counter++;
		dy = 1;
		dx = 1;
		droneDirection = direction.getRandomDirection();
	}


	
//	public Drone(String s) {
//		this(0, 0);
//		StringSplitter ss = new StringSplitter(s, " ");
//		setXY(ss.getNthInt(0, 5), ss.getNthInt(1, 8));
//	}
	
	public int getDrone() {
		return 21;
	}
	public int getDroneX() {
		return droneX;
	}


	public int getDroneY() {
		return droneY;
	}
	
	public void setDroneXY(int setX, int setY) {
		droneX = setX;
		droneY = setY;
		
	}


	public String toString() {
		String location = "Drone " + droneId + " is at " + droneX + ", " + droneY;
//		System.out.println("Location: " + location);
		return location;
	}
	
	public void moveDrone(DroneArena da, ArrayList<Drone> drone) {
		
							
		for(int i = 0; i < drone.size(); i++) {
			int newx = drone.get(i).droneX + dx;
			int newy = drone.get(i).droneY + dy;
//			System.out.println(dx);
			switch(da.canGoHere(newx, newy, droneDirection)) {
			
				case 0:
					drone.get(i).droneX = newx;
					drone.get(i).droneY = newy;
					break;
				case 1:
//					drone.get(i).droneX = newx;
//					drone.get(i).droneY = newy;
					dx = -dx;
					break;
				case 2:
					dy = -dy;
					break;
				case 3:
					dx = -dx;
					dy = -dy;
					break;
				
			}
		}

	}
	
	public void displayDrone(ConsoleCanvas c) {
		c.showIt(droneX, droneY, 'D');
	}
		
	
}
