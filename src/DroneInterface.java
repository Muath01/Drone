package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
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
			
			System.out.println("Enter Height: ");
			canvasW = scanner.nextInt();
			scanner.nextLine(); // This line you have to add (It consumes the \n character)

			System.out.println("Enter Width: ");
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
			
			System.out.println("Welcome to the file control system, you can (C)reate a file, (L)oad a file,  go (B)ack to the Arena control centre");
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
						
						writer.write(myArena.w + " " + myArena.h + " " + borderSign + "\n");
						for(Drone d: myArena.dronesArray) {
							writer.write(d.droneX + " " + d.droneY + " " + d.getDirection().toString() + "\n");
						}
						
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
					break;
					
				case 'l':
				case 'L':
					System.out.println("Enter the name of the files you want to load? ");
					fileName = scanner.nextLine();
					fileName.substring(0, fileName.lastIndexOf('.'));

					try {
						BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt")); 
						String line = reader.readLine();
						
						String[] loadArena = line.split(" ");
						
						
						int ax = Integer.parseInt(loadArena[0]);
						int ay = Integer.parseInt(loadArena[1]);
						borderSign = loadArena[2].charAt(0);
						myArena = new DroneArena(ax, ay);
						
						
						
						while((line = reader.readLine()) != null) {
							String[] numbers = line.split(" ");
							int x = Integer.parseInt(numbers[0]);
							int y = Integer.parseInt(numbers[1]);
							String droneDirection = numbers[2];
							
							myArena.dronesArray.add(new Drone(x, y, src.Directions.direction.valueOf(droneDirection)));
							
						}
						reader.close();
						
					} catch(IOException e) {
						System.out.println("\n\nError! No file with such name exists, here is a list of existing files, choose one:\n ");
//						 Array to store the names of the files names in them, and present them to the user as a choice: 
						try {
							
							
							File f = new File("C:\\Users\\muath\\java-projects\\drone");
							
							FilenameFilter filter = new FilenameFilter() {
				                @Override
				                public boolean accept(File f, String name) {
				                    // We want to find only .c files
				                    return name.endsWith(".txt");
				                }
				                
				            };
				            
				            File[] files = f.listFiles(filter);
				            
				            for(int i = 0; i < files.length; i++) {
				            	System.out.println(files[i].getName().split("."));
				            }
				            
							
						} catch(Exception er) {
				            System.err.println(e.getMessage());

						}
						
						
					}
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
//		System.out.println("hello");
	}
}
