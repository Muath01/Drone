package drone;

public class Drone {
	
	int x;
	int y;
	public int uniqueID;
	private static int count = 0;

	
	Drone(int x, int y) {
		
		this.x = x;
		this.y = y;
		
		uniqueID = count++;
	}
	
	public int getId() {
		return uniqueID;
	}
	
	@Override
	public String toString() {
		return "Drone 0 is at " + this.x + ", " + this.y;
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		int hello = 12;
		
	}

}
