package src;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DroneInterface {
	
	private Scanner scanner;
	DroneArena myArena;
	ConsoleCanvas myCanvas;
	private char borderSign; 
//	ConsoleCanvas myCanvas;
//	ConsoleCanvas canvas = new ConsoleCanvas();
	
	
	
	public DroneInterface() {
		super();
		scanner = new Scanner(System.in);
		myArena = new DroneArena(0, 0);
		int canvasW = 0;
		int canvasY = 0;
		
		
		
		
	
	char ch = ' ';
	
	do {
		System.out.print("Enter (A)dd drone, (D)isplay arena with Drones, (S)how arena without drones,  (M)ove Drone, (S)ize, (V)iew Arena with no drones, get (I)nformation or e(X)it : ");
		ch = scanner.next().charAt(0);
		
		switch(ch) {
		case 'A':
		case 'a':
			
	if(!ArenaExist(myArena.getH(), myArena.getW())) {
				
			}else {
				myArena.addDrone(); // Adds a drone in a unique random position
				
			}
			break;
		
		case 'c':
		case 'C':
			// Choose the dimension of the array. Number must be whole. 
			
			System.out.println("Enter width: ");
			canvasW = scanner.nextInt();
			System.out.println("Enter Height: ");
			canvasY = scanner.nextInt();
			System.out.println("Enter a sign or a letter to represent the border: ");
			borderSign = scanner.next().charAt(0);
			
			// Draw an Arena based on the inputted values. 
			
			myArena = new DroneArena(canvasW, canvasY);
			break;
		
		case 'd':
		case 'D':
				
			if(!ArenaExist(myArena.getH(), myArena.getW())) {
				
			}else {
				displayInterface();
				
			}
				

			break;
		case 'I':
		case 'i':
			if(!ArenaExist(myArena.getH(), myArena.getW())) {
				
			}
			System.out.println(myArena.toString());
			break;
		case 'V':
		case 'v':
			viewOnly(); // Display arena with no drones. 
			break;
	
		case 'M':
		case 'm':
			
			if(!ArenaExist(myArena.getH(), myArena.getW())) {
				
			}else {
				myArena.moveAllDrones(myArena);
				displayInterface();

				
			}
			break;
		case 'S':
		case 's':
			myCanvas.draw();
			break;
		case 'K':
		case 'k':
			for(int i = 0; i < 150; i++) {
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				myArena.moveAllDrones(myArena);
				displayInterface();				
			}
			break;
		case 'x':
			ch = 'X';
			break;

		}
		
		
	}while(ch != 'X');
	
		scanner.close(); 
	
	}
	
	// displays arena with drones. 
	public void displayInterface(){
		ConsoleCanvas field = new ConsoleCanvas(myArena.getW(), myArena.getH(), borderSign);
		myArena.showDrones(field);
		System.out.println(field.toString());
	}
	
	
	//Displays arena with no drones. 
	public void viewOnly(){
		ConsoleCanvas field = new ConsoleCanvas(myArena.getW(), myArena.getH(), borderSign);
		System.out.println(field.toString());
	}
	
	/*small Utility functions.*/ 
	
	// check if an arena exists
	public boolean ArenaExist(int height, int width) {
		if(height == 0 || width == 0) {
			System.out.println("Please Create a new Arena by pressing the letter c for Create!");
			return false;
		}
		return true;
	}
	
	public DroneArena getArena() {
		return myArena;
	}
	
	public static void main(String[] args) {
//		System.out.println("hello");
		DroneInterface cc = new DroneInterface();
	}
}
