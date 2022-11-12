package src;

import java.util.Random;

public class Directions {
	
	
	public enum direction{
		
		NORTH, EAST, SOUTH, WEST;
		
		public static direction getRandomDirection() {
			
			Random random = new Random();
            return values()[random.nextInt(values().length)]; //code provided to us in week 4. 
		    
		}
		
		 public direction nextDirection() { 

			        int change = direction.values().length - 1;
			        if (this.ordinal() == change)
			            return values()[0];
			        else
			            return values()[this.ordinal() + 1];
			    }
	}

}
