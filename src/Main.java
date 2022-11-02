package src;

public class Main {

	public static void main(String[] args) {
		
		DroneArena arena = new DroneArena(40, 20);
		arena.addDrone();
		System.out.println(arena.showDrone);
		arena.toString();
	
	}

}



