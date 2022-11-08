package src;

import src.DroneArena;

public class Main {

	public static void main(String[] args) {

		

//		DroneArena arena = new DroneArena(20, 5);
		
//		arena.moveTest();



		int width = 40;
		int height = 10;

		char[][] myarr = new char[height][width];

		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				if(j > width-2 || j == 0 || i == 0 || i == height-1){
					myarr[i][j] = '#';
				}else{
					myarr[i][j] = ' ';
				}
			}
		}


		for(int i = 0; i < myarr.length; i++){
			System.out.println(myarr[i]);
		}

	}

}





