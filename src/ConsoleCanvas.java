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

    public String toString() {

    
        String myString = "Canvas with size " + canvasX + " by " + canvasY;
    

        return myString;

    }

    public static void main(String[] args){
        ConsoleCanvas mycan = new ConsoleCanvas(20, 5);
        mycan.draw();
        System.out.print(mycan.toString());

    }
}
