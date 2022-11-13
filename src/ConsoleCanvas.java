package src;

import java.io.Console;

public class ConsoleCanvas  {

    char[][] myarr;
    private int canvasX;
    private int canvasY;

    public ConsoleCanvas(int x, int y, char border){

        canvasX = x ;
        canvasY = y;
        myarr = new char[canvasX][canvasY];

        createArena(border);
    }

    public void createArena(char border) {


        for(int i = 0; i < canvasX; i++){
            for(int j = 0; j < canvasY; j++){
            	/** 
            	 in the if statement, each check draws a border, 
            	 the first check draws the bottom border, 
            	 the second check draws the top border,
            	 the third check draws the left border, 
            	 the fourth check draws the right border. 
            	 **/
                if(i > canvasX-2 || i == 0 || j == 0 || j == canvasY-1){
                    myarr[i][j] = border;
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
    
    public void showIt(int droneX, int droneY, char c) { 
    	myarr[droneX][droneY] = c; // adds the char representing the drone to the array that prints the canvas, and instead of printing empty char ' ' it now print a drone char. 
    }
    

    public String toString() {
    
        String canvas = "";
        
        for(int i = 0; i < canvasX; i++) {
        	for(int j = 0; j < canvasY; j++) {
        		
        		canvas += myarr[i][j] + " "; //fills the canvas string with array items + 1 space. 
        	}
        	canvas += "\n";
        }
        return canvas;

    }
    
    public static void main(String[] arg) {
    	ConsoleCanvas n = new ConsoleCanvas(5, 15, '#');
    	System.out.println(n.toString());
    }

   
}
