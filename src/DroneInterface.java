package src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
		System.out.print("Enter (A)dd drone, N to add custom amount of drones,  (D)isplay arena with Drones, (S)how arena without drones,  (M)ove Drone, (S)ize, (V)iew Arena with no drones, get (I)nformation or e(X)it : ");
		ch = scanner.next().charAt(0);
		scanner.nextLine();
		
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
			scanner.nextLine(); // This line you have to add (It consumes the \n character)

			System.out.println("Enter Height: ");
			canvasY = scanner.nextInt();
			scanner.nextLine(); // This line you have to add (It consumes the \n character)

			System.out.println("Enter a sign or a letter to represent the border: ");
			borderSign = scanner.next().charAt(0);
			scanner.nextLine(); // This line you have to add (It consumes the \n character)

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
			
		case 'n':
		case 'N':
			System.out.println("Enter the amount of drones you want to add: ");
			int customNumDrones = scanner.nextInt();
			scanner.nextLine(); // This line you have to add (It consumes the \n character)

			
			if(!ArenaExist(myArena.getH(), myArena.getW())) {
				
			}else {
				myArena.addDrone();
				for(int i = 0; i < customNumDrones; i++) {
					myArena.addDrone();
					}
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
			
		case 'f':
		case 'F':
			char action;
			do{
			
			System.out.println("Welcome to the file control system, you can (C)reate a file, (S)ave a file,  (l)oad a file");
			action = scanner.next().charAt(0);
			scanner.nextLine(); // This line you have to add (It consumes the \n character)

				switch(action) {
				case 'c':
				case 'C':
					System.out.println("enter a file name to store the drones in: ");
					String fileName = scanner.nextLine();
					System.out.println("here");
					try {
						BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt"));
						
						
						for(Drone d: myArena.dronesArray) {
							writer.write(d + "\n");
						}
						
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					break;
				}
			}while(action != 'b');
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
