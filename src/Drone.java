package src;
import java.util.Random;

public class Drone {
	
	int y;
	int x;
	int id;
	protected int[][] drones = {{1, 10}};
	private static int counter;
	
	Random numberGenerator = new Random();
	int randomNumber = numberGenerator.nextInt(20);
	
	
	
	
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
		
        
			for(int j = 0; j < drones.length; j++) {
//				System.out.print("i: " + i + " h: "+ h + "---------------");
				
//				if((h == drones[j][0]) && (w == drones[j][1])) {
				if((h == randomNumber) && (w == randomNumber)) {
					System.out.print(drone);
					return;
					
				}
				
			}
			System.out.print(" ");	
		}
		

	
}
