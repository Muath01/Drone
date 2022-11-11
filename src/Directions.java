package src;

import java.util.Random;

public class Directions {
	
	
	public enum direction{
		
		NORTH, EAST, SOUTH, WEST;
		
		public static direction getRandomDirection() {
			
			Random random = new Random();
            return values()[random.nextInt(values().length)];
		    
		}
	}

}
