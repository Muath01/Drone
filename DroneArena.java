package drone;
import java.util.Random;


public class DroneArena {
	
	int w;
	int h;
	boolean addDrone = false;
	
	
	
	
	public DroneArena(int w, int h, char sign){
		this.w = w;
		this.h = h;
		
		horizental(this.w, sign);
		
		
		for(int i = 0; i < h; i++) {
			vertical(this.w, sign);
		}
		
		horizental(this.w, sign);
	}
	
	void addDrone() {
		
		Random rand = new Random();
		
		int dronePosition = rand.nextInt(25);
		
		System.out.print("The Drone is positioned at: " + dronePosition);
		
		
		
	}

	
	void vertical(int w, char sign) {
		System.out.print(sign);
		for(int i = 0; i < w -2; i++) {
			System.out.print(" ");
		}
		System.out.println(sign);
	}
	
	void horizental(int w, char sign) {
		
		for(int i = 0; i < w-1; i++) {
			System.out.print(sign);
		}
		System.out.println(sign);
	}
	

	public static void main(String[] args) {
		
		
		
		
		

	}

}
