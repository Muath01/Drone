package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.*;

public class Drone {
	
	int droneX, droneY, droneId, dy, dx; // droneX & droneY are the positions of the drone, 
	private static int counter;
	DroneArena arena;
//	static ArrayList<int[]> drones = new ArrayList<>(); // a 2d list, will take in other arrays, each representing a drone position.
	static ArrayList<Drone> drones = new ArrayList<Drone>();

	public Drone(int x, int y) {
		
		droneX = x;
		droneY = y;
		this.droneId = counter++;
		dy = 1;
		dx = 1;
	}
	
	public Drone(String s) {
		this(0, 0);
		StringSplitter ss = new StringSplitter(s, " ");
		setDroneXY(ss.getNthInt(0, 5), ss.getNthInt(1, 8));
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
	
	public void moveDrone(DroneArena da) {
		
		int newx = droneX + dx;
		int newy = droneY + dy;
	
		
		switch(da.canGoHere(newx, newy)) {
		case 0:

			droneX = newx;
			droneY = newy;
			break;
		case 1:
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

	
	


	void showIt(int h, int w, char drone) {
		
		for(int j = 0; j < drones.size(); j++) {
			if((h == drones.get(j).droneX) && (w == drones.get(j).droneY)) {
				System.out.print(drone);
				return;
				
			}
			
		}
			System.out.print(" ");	
		}
	
//	public static void main(String[] args) {
//
////		Drone d = new Drone(10, 15);
////		System.out.println(d.toString());
////		Drone dy = new Drone(110, 15);
////		System.out.println(dy.toString());
////		Drone dx = new Drone("5 3");
////		System.out.println(dx.toString());
//	}
		
	
}
