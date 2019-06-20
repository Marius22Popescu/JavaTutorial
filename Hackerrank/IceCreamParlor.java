package Hackerrank;

import java.util.HashMap;

public class IceCreamParlor {
	public static void main(String[] args) {
		int cost[] = {1, 4, 5, 3, 2};
		int money = 4;
		whatFlavors(cost, money);
	}

	private static void whatFlavors(int[] cost, int money) {
		   HashMap<Integer, Integer> map = new HashMap<>();
		    for(int i = 0; i < cost.length; i++){
		       int ice2 = money-cost[i];  //find the price for the second ice cream 
		       if(cost[i] < money){  //just if there are enough money
		           if(map.containsKey(ice2)) {
		                System.out.println(map.get(ice2) + " " + (i+1));
		                break;
		            }
		            else
		                map.put(cost[i], i+1);
		        }
		   }
	}
}
