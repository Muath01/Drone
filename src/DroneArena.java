package src;




public class DroneArena extends Drone{
	
	char myDrone = 'X';
	char border = '-';
	boolean showDrone = true;
	int w;
	int h;
	
	
	public DroneArena(int w, int h) {
		super(20, 1);
//		super(w, h, border);
		
		this.w = w;
		this.h = h;
	
		horizental(w, border);
		
		for(int i = 0; i < h; i++) {
			
						
			vertical(w, i, border);
			
		}
		
		horizental(w, border);
	}
	
	
	
	public void draw() {
		horizental(this.w, border);
		
       for(int i = 0; i < this.h; i++) {
			
			
			vertical(this.w, i, border);
			
		}
         showDrone = false;
		
		horizental(this.w, border);
		
		
	}
	
	public void addDrone() {
		showDrone = true;
	}

		
		void vertical(int w,int h, char border) {
			System.out.print(border);
			for(int i = 0; i < w - 2; i++) {
				
				
				if(showDrone == true) {
					showIt(h, i, 'D');
					
				}else {
					System.out.print(" ");
				}
				
				
					
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
