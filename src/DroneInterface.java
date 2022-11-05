package src;

public class DroneInterface {
	
	
	DroneArena arena;
//	ConsoleCanvas canvas = new ConsoleCanvas();
	
	
	
	public DroneInterface(DroneArena arena) {
		super();
		this.arena = arena;
	}
	
	public DroneArena getArena() {
		return arena;
	}
	
	
	
}
