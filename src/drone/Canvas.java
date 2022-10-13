package drone;

public class Canvas {
	
	
	
	public Canvas(int w, int h, char border) {
		horizental(w, border);
		
		for(int i = 0; i < h; i++) {
			vertical(w, border);
			
		}
		
		horizental(w, border);
	}

		void showIt(int w, int h, char drone) {
			System.out.print("hello");
			for(int i = 0; i < h; i++) {
				
				if(h == 5) {
					System.out.print(drone);
				}
				
			}
		}
		
		
		void vertical(int w, char border) {
			System.out.print(border);
			
			for(int i = 0; i < w - 2; i++) {
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


