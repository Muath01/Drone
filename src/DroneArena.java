package src;

import java.util.*;

/**
 * @author muath
 *
 */
public class DroneArena extends Drone{
	
	char border = '#';
	static boolean showDrone = false;
	static int w;
	static int h;
	private Drone newDrone;
	char[][] myarr;

	static ArrayList<Drone> dronesArray = new ArrayList<Drone>();
	
	
	public DroneArena(int w, int h) {
		super(10, 10);

		this.myarr = new char[h][w];
		newDrone = new Drone(10, 16);
		DroneArena.w = w;
		DroneArena.h = h;
		this.createArena();

//		this.addDrone();
		
//		this.draw();
	
	}
	public DroneArena(String s){
		super(0, 0);
		StringSplitter ss = new StringSplitter(s, ";");
		StringSplitter sbp = new StringSplitter(ss.getNth(0, "5 10"), " ");
		w = sbp.getNthInt(0, 5);
		h = sbp.getNthInt(1, 8);
		newDrone = new Drone(ss.getNth(1, "2 5"));
	}
	
	public void moveTest() {
		
		Drone myFinalDrone = new Drone(50, 43);
		dronesArray.add(myFinalDrone);
		
		System.out.println(dronesArray.get(0).droneX);
	}
	
	public void moveArena() {
		newDrone.moveDrone(this);
	}
	
	
	public int canGoHere(int x, int y) {
		int status = 0;
		
		if(x < 0 || x >= w) status += 1;
		if(y < 0 || y >= h) status += 2;
		return status;
	}
	
//	@Override
//	public String toString() {
//		return "DroneArena size " + w + " by " + h + " with Drone " + newDrone.droneId + " at " + newDrone.droneX + ", " + newDrone.droneY ;
//	}




	public int getW() {
		return w;
	}


	public int getH() {
		System.out.println("Lets gooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo");
		return h;
	}




	
	
	
	public void createArena() {


		for(int i = 0; i < DroneArena.h; i++){
			for(int j = 0; j < DroneArena.w; j++){
				if(j > DroneArena.w-2 || j == 0 || i == 0 || i == DroneArena.h-1){
					myarr[i][j] = '#';
				}else{
					myarr[i][j] = ' ';
				}
			}


		}


		
		
	}

	public void draw(){
		for(int i = 0; i < myarr.length; i++){
			System.out.println(myarr[i]);
		}
	}

	public String toString() {
		String arena = "";
		for (int i = 0; i < myarr.length; i++) {
			arena += myarr[i];
		}

		return arena;
	}

	
	public void addDrone(int w, int y) {


		
		Random rand = new Random();

		int[] arr = {y, w};

		
		String errorMessage = "The position (" + w + "," + y + ") is occupied, please choose a different coordinate";
		
	if(dronesArray.size() >= 1) {
		
		checkForDuplicate(dronesArray.size(), w, y, arr, errorMessage);
		dronesArray.add(new Drone(y, w));
	}else {
		System.out.println("size: " + dronesArray.size());
		dronesArray.add(new Drone(y, w));
		}
	
	showDrone = true;
	
}
	

	
	public void DroneLocationOccupied(int droneSize, int w, int y, int[] arr, Random rand) {
		
			w = rand.nextInt(DroneArena.w - 3);
			y = rand.nextInt(DroneArena.h - 1);
			
			arr[0] = y;
			arr[1] = w;
			
			checkForDuplicate(droneSize,w, y, arr,  rand);
	}
	
	public void checkForDuplicate(int droneSize, int w, int y, int[] arr, String errorMessage) {
		
		for(int i = 0; i < dronesArray.size() ; i++) {
			
			if((dronesArray.get(i).droneY) == y && dronesArray.get(i).droneX == w) {
			System.out.println(errorMessage);
			System.exit(y);
			
				
		}
	}
}
	
	public void checkForDuplicate(int droneSize, int w, int y, int[] arr, Random rand) {
		
		for(int i = 0; i < dronesArray.size() ; i++) {
			
			if((dronesArray.get(i).droneY) == y && dronesArray.get(i).droneX == w) {
			DroneLocationOccupied(droneSize,w, y, arr, rand);
			

			
			}else {
//				System.out.println("not Equalx: " + i);
				
			}
//			System.out.println("-------------------------------");
		}
}
	
	
	public void addDrone() {
		
		
//		System.out.println("inside the add Drone function");
		
		Random rand = new Random();
		
		
		int yd = 12;
		int w = rand.nextInt(DroneArena.w - 3);
		
		int y = rand.nextInt(DroneArena.h - 1); /* we subtract 3 because we don't loop over the whole arena in our vertical function. 
												 we don't loop over the whole arena so the sides of the arena are drawn within instead of 
												 of it */
		
		
		int[] arr = {y, w};
		
		
		if(dronesArray.size() >= 1) {
			
			
			checkForDuplicate(dronesArray.size(), w, y, arr, rand);
			
			dronesArray.add(new Drone(y, w));
			droneId++;
	}
		
		else {
//				System.out.println("size: " + dronesArray.size());
			dronesArray.add(new Drone(y, w));


			droneId++;
			}
		
		
		droneY = y;
		droneX = w;
		showDrone = true;
		this.draw();
		
	}
	
	

		
//	Vertical function draws the sides of the arena and the space with in it.

	public void showDrone() {

		for (int i = 0; i < dronesArray.size(); i++) {

			for (int j = 0; j < DroneArena.h; j++) {

				for (int k = 0; k < DroneArena.w; k++) {
//					System.out.print(DroneArena.h + " ");
					if ((j == dronesArray.get(i).droneX) && (k == dronesArray.get(i).droneY)) {
						myarr[j][k]= 'D';


					}

				}

			}
		}
	}
		
		


		public static void main(String[] args){

			DroneArena drone = new DroneArena(40, 10);

			drone.addDrone(10, 8);
			drone.showDrone();
			drone.draw();

		}
		

}
