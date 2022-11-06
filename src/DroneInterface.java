package src;

import java.util.Scanner;

public class DroneInterface {
	
	private Scanner s;
	DroneArena myArena;
//	ConsoleCanvas canvas = new ConsoleCanvas();
	
	
	
	public DroneInterface(int w, int y) {
		super();
		s = new Scanner(System.in);
		this.myArena = new DroneArena(w, y);
	
	
	
	
	
	char ch = ' ';
	
	do {
		System.out.print("Enter (A)dd drone, get (I)nformation or e(X)it : ");
		ch = s.next().charAt(0);
		
		switch(ch) {
		
		case 'A':
		case 'a':
			myArena.addDrone(); // Adds a drone in a unique random position
			break;
		case 'I':
		case 'i':
			myArena.toString();
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
