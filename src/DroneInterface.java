package src;

import java.util.Scanner;

public class DroneInterface {
	
	private Scanner s;
	DroneArena myArena;
	ConsoleCanvas myCanvas;
//	ConsoleCanvas myCanvas;
//	ConsoleCanvas canvas = new ConsoleCanvas();
	
	
	
	public DroneInterface(int w, int y) {
		super();
		s = new Scanner(System.in);
		myArena = new DroneArena(w, y);
		myCanvas = new ConsoleCanvas(w, y);
	
	
	
	
	
	char ch = ' ';
	
	do {
		System.out.print("Enter (A)dd drone, (D)isplay arena with Drones, (S)how arena without drones,  (M)ove Drone, (S)ize, (V)iew Arena with no drones, get (I)nformation or e(X)it : ");
		ch = s.next().charAt(0);
		
		switch(ch) {

			case 'd':
			case 'D':
				myArena.draw();
				break;
			case 'V':
			case 'v':
				myCanvas.draw();
				break;
			case 'A':
			case 'a':
				myArena.addDrone(); // Adds a drone in a unique random position
				break;
			case 'M':
			case 'm':
				myArena.moveArena();
				break;
			case 'I':
			case 'i':
				System.out.println(myArena.toString());
				break;
			case 'S':
			case 's':
				myCanvas.draw();
				break;
			case 'K':
			case 'k':
				myArena.moveDrones();
				break;
			case 'x':
				ch = 'X';
				break;

		}
		
		
	}while(ch != 'X');
	
		s.close(); 
	
	}
	
	public DroneArena getArena() {
		return myArena;
	}
}
