package Challenges;

import java.util.ArrayList;
import java.util.List;
//Eight houses, represented as cells, are arranged in straight line. Each day every cell competes with its 
//adjacent cells (neighbors). An integer value of 1 represents an active cell and a value of 0 represents an 
//inactive cell. If the neighbors on both the sides of a cell are either active or inactive, the cell becomes
//inactive on the next day; otherwise the cell becomes active.The two cells on each end have a single adjacent
//cell, so assume that the unoccupied space on the opposite side is an inactive cell. Even after updating the 
//cell state, consider its previous state when updating the state of other cells. The state information of all
//cells should be updated simultaneously.
//	Write an algorithm to output the state of the cells after the given number of days.
public class EightHousesInactiveActiveCells {
	
public static List<Integer> cellCompete(int[] states, int days){
		
		for (int j = 0; j < days; j++) {
			int[] firstState = new int[states.length];
			System.arraycopy(states, 0, firstState, 0, states.length);

			if(firstState[1]==0) states[0] = 0; //manage the first cell case
			else states[0]=1;
			if(firstState[states.length - 2]==0) states[states.length - 1] = 0;  //manage the last cell case
			else states[states.length - 1] = 1;
			for (int x = 0; x < states.length-2; x++) {   //manage middle cells cases
				if (firstState[x] == firstState[x+2]) states[x+1]=0;
				else states[x+1]=1;
			}			
		}
		List<Integer> finalState = new ArrayList<>();
		for (int i = 0; i < states.length; i++) {
			finalState.add(states[i]);
		}		
		return finalState;
	}
	
	public static void main(String[] args) {
		int[] cells1 = new int[]{1,0,0,0,0,1,0,0};
		int[] cells2 = new int[]{1,1,1,0,1,1,1,1};
		List<Integer> outputState = new ArrayList<>();
		outputState = cellCompete(cells2, 2);
		System.out.print(outputState);
	}
	
}
