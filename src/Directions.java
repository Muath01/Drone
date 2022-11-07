package src;

import java.util.Random;

public class Directions {
	
	
	public enum Direction{
		
		NORTH, EAST, SOUTH, WEST;
		
		public static Direction getRandomDirection() {
			
			Random random = new Random();
            return values()[random.nextInt(values().length)];
		    
		}
	}

}
