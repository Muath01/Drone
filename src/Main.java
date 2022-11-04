package src;

public class Main {

	public static void main(String[] args) {
		
//		DroneArena arena = new DroneArena(40, 20);
//		arena.addDrone();
//		
//		ConsoleCanvas canvas = new ConsoleCanvas();
//		
//		canvas.draw();
//		
		
		DroneInterface test = new DroneInterface();
		
//		in.arena.addDrone();
		
		DroneArena arena = new DroneArena(40, 20);
		
		test.arena.addDrone();
		test.arena.addDrone();
		test.arena.addDrone();
		test.canvas.draw();
		
	
	}

}





