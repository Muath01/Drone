package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Drone {
	
	int droneX, droneY, droneId, dy, dx; // droneX & droneY are the positions of the drone, 
	private static int counter;
	DroneArena arena;
	static List<int[]> drones = new ArrayList<>(); // a 2d list, will take in other arrays, each representing a drone position.
	

	public Drone() {
		
		this.droneId = counter++;
	}
	
	
	public String toString() {
		String location = "Drone " + this.droneId + " is at " + this.droneX + ", " + this.droneY;
		System.out.println("Location: " + location);
		return location;
	}

	
	
	void showIt(int h, int w, char drone) {
		
		for(int j = 0; j < drones.size(); j++) {
			if((h == drones.get(j)[0]) && (w == drones.get(j)[1])) {
				System.out.print(drone);
				return;
				
			}
			
		}
			System.out.print(" ");	
		}
		
	
}
