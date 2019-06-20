package Challenges;
//Given an array representing the locations of N steak houses in the city, implement an algorithm to find the
//nearest X steak houses to the customer's location. 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SteakHouses {
	public static void main (String[] args) {
		List <List <Integer>> allLocations = new ArrayList <List <Integer>> ();
		allLocations.add(Arrays.asList(1, 2));
		allLocations.add(Arrays.asList(3, 4));
		allLocations.add(Arrays.asList(1, -1));
		
		List <List <Integer>> nearSteakeHouses = new ArrayList <List <Integer>> ();
		nearSteakeHouses = nearestXsteakHouses(3, allLocations, 2);
		
		System.out.println(nearSteakeHouses);
	}
	
	private static List<List<Integer>> nearestXsteakHouses(int l, List<List<Integer>> allLocations, int j) {
		List<List<Double>> sth = new ArrayList<List<Double>> ();
		List<List<Integer>> sthOrdered = new ArrayList<List<Integer>> ();
		double dist = 0;
		double x = 0; 
		double y = 0;
		//add the distance to the list 
		for (int i = 0; i < l; i++) {
			x = allLocations.get(i).get(0);
			y = allLocations.get(i).get(1);
			dist = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
			sth.add(Arrays.asList(dist, x, y));
		}
		//sort the list
		Collections.sort(sth, new Comparator <List <Double>> () {
			@Override
			public int compare(List<Double> o1, List<Double> o2) {
				return o1.get(0).compareTo(o2.get(0));
			}			
		});
		//copy just last two elements to the returning list and convert from double to int
		for (int i = 0; i < j; i ++) {
			int a = (int) Math.round(sth.get(i).get(1));
			int b = (int) Math.round(sth.get(i).get(2));
			sthOrdered.add(Arrays.asList(a, b));
		}
		return sthOrdered;
	}
}