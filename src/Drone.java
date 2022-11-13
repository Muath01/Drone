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
	private static int counter;
	public direction droneDirection;

	

	public Drone(int x, int y, direction d) {
		
		droneX = x;
		droneY = y;
		this.droneId = counter++;
		dy = 1;
		dx = 1;
		droneDirection = d;
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
	
	public Directions.direction getDirection(){
		return droneDirection;
	}


	public String toString() {
		String location = "Drone " + droneId + " is at " + droneX + ", " + droneY;
//		System.out.println("Location: " + location);
		return location;
	}
	
	public void tryToMove(DroneArena a) {
		
							
			switch(droneDirection) {
			
				case NORTH:
					if(a.tryHere(droneX - 1, droneY)) {
						droneX = droneX - 1;
					}else {
						droneDirection = droneDirection.nextDirection();
					}
					break;
				case EAST:
					if(a.tryHere(droneX, droneY + 1)) {
						droneY = droneY + 1;
					}else {
						droneDirection = droneDirection.nextDirection();
					}
					break;
				case SOUTH:
					if(a.tryHere(droneX + 1, droneY)) {
						droneX = droneX +1 ;
					}else {
						droneDirection = droneDirection.nextDirection();
					}
					break;
				case WEST:
					if(a.tryHere(droneX, droneY -1)) {
						droneY = droneY - 1;
					}else {
						droneDirection = droneDirection.nextDirection();
					}
				
			}

	}
	
	public boolean isHere(int tx, int ty) {
		if(tx == droneX && ty == droneY) {
			return true;
		}else {
			return false;
		}
	}
	
	public void displayDrone(ConsoleCanvas c) {
		c.showIt(droneX, droneY, 'D');
	}
		
	
}
