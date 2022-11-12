package src;

import java.io.Console;

public class ConsoleCanvas  {

    char[][] myarr;
    private int canvasX;
    private int canvasY;

    public ConsoleCanvas(int x, int y){

        canvasX = x ;
        canvasY = y;
        myarr = new char[canvasX][canvasY];

        createArena();
    }

    public void createArena() {


        for(int i = 0; i < canvasX; i++){
            for(int j = 0; j < canvasY; j++){
                if(i > canvasX-2 || i == 0 || j == 0 || j == canvasY-1){
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
    
    public void showIt(int droneX, int droneY, char c) { 
    	myarr[droneX][droneY] = c; // adds the char representing the drone to the array that prints the canvas, and instead of printing empty char ' ' it now print a drone char. 
    }
    

    public String toString() {
    
        String canvas = "";
        
        for(int i = 0; i < canvasX; i++) {
        	for(int j = 0; j < canvasY; j++) {
        		
        		System.out.println("i:" + canvasY);
        		canvas += myarr[i][j] + " ";
        	}
        	canvas += "\n";
        }
        return canvas;

    }
    
    public static void main(String[] arg) {
    	ConsoleCanvas n = new ConsoleCanvas(10, 10);
    	System.out.println(n.toString());
    }

   
}
