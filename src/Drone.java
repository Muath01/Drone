package src;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Drone {
	
	int y;
	int x;
	int id;
	DroneArena arena;
	
//	protected int[][] drones = {{1, 10}, {13, 10}};

	static List<int[]> drones = new ArrayList<>(); // a 2d list, will take in other arrays, each representing a drone position.
	int[] nums = {8,2};
	
	
	
	
	
	private static int counter;
	Random numberGenerator = new Random();
	int randomNumberWidth = numberGenerator.nextInt(10);
	int randomNumberHeight = numberGenerator.nextInt(10);
	

	
	
	
	
	public Drone(int x, int y) {

		this.x = x;
		this.y = y;
		
		this.id = counter;
		counter++;
	}
	
	public String toString() {
		String location = "Drone " + this.id + " is at " + this.x + ", " + this.y;
		return location;
	}

	
	
	void showIt(int h, int w, char drone) {
		
//		System.out.println(drones.get(0));
			for(int j = 0; j < drones.size(); j++) {
//				if((h == drones[j][0]) && (w == drones[j][1])) {
					if((h == drones.get(j)[0]) && (w == drones.get(j)[1])) {
//				if((h == randomNumberHeight) && (w == randomNumberWidth)) {
					System.out.print(drone);
					
					return;
					
				}
				
			}
			System.out.print(" ");	
		}
		

	
}
