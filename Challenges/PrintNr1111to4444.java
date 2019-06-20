package Challenges;
//Print all numbers from 1111 to 4444 that include just the following digits: 1, 2, 3  and 4.
public class PrintNr1111to4444 {
	public static void main (String[] args) {
		
 
		for (int i =1; i<= 4; i++) {
			int nr = 0;
			nr = i*1000;
			for (int j =1; j<= 4; j++) {
				int nr2 = nr;
				nr2 = nr + j*100;
				for (int k =1; k<= 4; k++) {
					int nr3 = nr2;
					nr3 = nr2 + k*10;
					for (int l = 1; l<= 4; l++) {
						int nr4;
						nr3 = nr3 + 1;
						System.out.println(nr3);
					}
				}				
			}
		}
	}

}
