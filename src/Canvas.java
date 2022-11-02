package src;

import java.util.Random;


public class Canvas {
	
	char myDrone = 'X';
    Random rand = new Random(); //instance of random class

	
	public Canvas(int w, int h, char border) {
		
		
		
		horizental(w, border);
		
		for(int i = 0; i < h; i++) {
			
			
			vertical(w, i, border);
			
		}
		
		horizental(w, border);
	}
	
	// Show the Drone

		void showIt(int w, int h, char drone) {
			int int_random = rand.nextInt(14); 
			if(w == int_random && h == int_random) {

			      System.out.print(h);

			}
		}
		
		
		void vertical(int w,int h, char border) {
			System.out.print(border);
			
			for(int i = 0; i < w - 2; i++) {
				
				showIt(h, i , 'D');
				
				
				System.out.print(' ');
			}
			System.out.println(border);
			
		}
		

		
		void horizental(int w, char border) {
			
			for(int i = 0; i < w -1; i++) {
				
				System.out.print(border);
			}
			System.out.println(border);
		}

	}


