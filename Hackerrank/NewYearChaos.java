package Hackerrank;

public class NewYearChaos {

	public static void main(String[] args) {
		int que[] = {1, 2, 5, 3, 7, 8, 6, 4};
		minimumBribes(que);
	}

	static void minimumBribes(int[] q) {
		int bribes = 0;
		int temp = 0;
		boolean chaos = false;
		int l = q.length; //store the queue length
		//check if is chaos
		for (int i = 0; i < l-1; i++) if ((q[i]-i-1)>2) chaos = true;
		//if a nr is greater than the next one swap and update the bribes
		int j = 0;
		boolean sorted = false; //check if the array was sorted
		while (j < l-1 && !sorted) {
			sorted = true; //assume that the array is sorted and check
			for (int i = 0; i < l-1; i++) {
				if(q[i]>q[i+1]) {
					bribes++;
					temp = q[i]; //swap
					q[i]=q[i+1];
					q[i+1]= temp;
					sorted = false; //if we are here the array is not sorted yet
				}
			}
			j++;
		}
		if(!chaos)  System.out.println(bribes);
		else System.out.println("Too chaotic");
	}
}
