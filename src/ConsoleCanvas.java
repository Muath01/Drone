package src;

import java.io.Console;

public class ConsoleCanvas  {

    char[][] myarr;
    private int canvasX;
    private int canvasY;

    public ConsoleCanvas(int x, int y){

        canvasX = x ;
        canvasY = y;
        myarr = new char[canvasY][canvasX];

        createArena();
    }

    public void createArena() {


        for(int i = 0; i < canvasY; i++){
            for(int j = 0; j < canvasX; j++){
                if(j > canvasX-2 || j == 0 || i == 0 || i == canvasY-1){
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
    
    public void arenaOnly() {
    	char[][] ao = new char[canvasY][canvasX];
    	
    	for(int i = 0; i < canvasX; i++) {
    		for(int j = 0; j < canvasY; j++) {
    			if(myarr[i][j] == 'D') {
    				myarr[i][j] = ' ';
    			}
    		}
    	}
    	
    }

    public String toString() {
    
        String canvas = "";
        
        for(int i = 0; i < canvasX; i++) {
        	for(int j = 0; j < canvasY; j++) {
        		canvas += myarr[i][j] + " ";
        	}
        	canvas += "\n";
        }
        return canvas;

    }

    public static void main(String[] args){
        ConsoleCanvas mycan = new ConsoleCanvas(20, 5);
        mycan.draw();
        System.out.print(mycan.toString());

    }
}
