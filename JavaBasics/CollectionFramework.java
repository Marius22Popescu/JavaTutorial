package JavaBasics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionFramework {
	
	public static void main(String args[]) {
		
		System.out.println("******** Sorting Arrays:");
		//Sorting Array
		int numbers [] = {11, 9, 3 , 5, 6, 1, 2, 10, 8, 7, 12, 4};
//		Arrays.parallelSort(numbers);
		Arrays.sort(numbers);
		print(numbers);
		
		System.out.println("******** Sorting a List:");
		//Sorting a List
		List <List <Integer>> allLocations = new ArrayList <List <Integer>> ();
		allLocations.add(Arrays.asList(1, 2));
		allLocations.add(Arrays.asList(3, 4));
		allLocations.add(Arrays.asList(2, -1));
		
		Collections.sort(allLocations, new Comparator <List<Integer>> () {
			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.get(0).compareTo(o2.get(0));
			}			
		});
		
		System.out.println(allLocations);
		
		System.out.println("******** Strings:");
		//StringsBuffeer
		StringBuffer enc = new StringBuffer();
		enc.append("a");
		enc.append("3");

		//Strings
		String stt = "vffsc";
		String stt2 = "fsfd";
		String str7 = "aa bb ccc";
		stt.length();
		char [] arrc = stt.toCharArray(); //will convert the string in a char array {'v', 'f', 'f', 's', 'c'}
		String [] arrs = str7.split("\\s"); //will split the string by spaces and insert in an array {"aa", "bb", "ccc"}
		Arrays.sort(arrc); //will sort an array of char
		stt.equals(stt2);  // stt == stt2 will not work
		String stl;		
		stl = stt.replace(stt.charAt(1), 'p');  // will replace all occurrences of charAt(1) that is 'f' with 'p' => "vppsc"
		stl = stt.substring(0, 2)+ 'p' + stt.substring(3, 5); // => "vfpsc"
		System.out.println(arrc);
		System.out.println(stl);
		System.out.println(stt.equals(stl));
		
		System.out.println("******** Conversions:");
		//Conversions
		boolean b = true; 
		String str = "12345";
		char c = '5';
		int i = 0;
		i = Integer.parseInt(str); 		  // from    String to Integer
		i = Character.getNumericValue(c); // from Character to Integer
		c = str.charAt(0);  	  //  from  String to Character
		c = (char)(i + '0');      //  from Integer to Character
		str = String.valueOf(i);   // from Integer to String 1
		str = Integer.toString(i); // from Integer to String 2
		str = String.valueOf(c);	 // from Character to String 1
		str = Character.toString(c); // from Character to String 2
		str = String.valueOf(b);  	//from Boolean to String
		b = Boolean.parseBoolean(str); //from String to Boolean 1
		b = Boolean.valueOf(str);  	   //from String to Boolean 2
		b = (i != 0);			   	// from Integer to Boolean
		long lg = 67;
		i = (int) lg;              			//  from long to Integer
		str = String.valueOf(lg);  			//  from long to String
		lg = i;								//  from int to long
		lg = Long.parseLong(str);  			//  from String to long
		lg = Character.getNumericValue(c);  //  from Character to long
		double d = 23.5;
		i = (int) d;				      // from Double to Integer
		int in = (int) Math.round(d);	  // from Double to Integer
		d = i;					    	  // from int to double
		d = Double.parseDouble(str); 	  // from String to double
		d = Character.getNumericValue(c); // from Character to double
		System.out.println("It is: "+ d);
		
		System.out.println("******** Array integers:");
		//array
		int arr1[] = new int[5];
		arr1[0] = 3;
		arr1[1] = 2;
		int l = arr1.length; //LENGTH
		for (int x : arr1) {
		System.out.print(x + ", ");
		}
		System.out.println("\n******** Array strings:");
		String arr2[];
		arr2 = new String[4];
		arr2[0] = "aaa";
		arr2[1] = "bbb";
		arr2[2] = arr2[0]+arr2[1];
		for(String s: arr2) {
			if (s=="aaa") System.out.print("gdghhghj");
				
		System.out.print(s + ", ");
		}
		System.out.println("\n******** Array char:");
		String ini = "dfsdfsdf";
		char[] arrC = new char[5];
		for(int j = 0; j < arrC.length; j++) {
			arrC[j] = ini.charAt(j);
		}
		arrC[0] = 'A';
		for(char x: arrC) {
			System.out.print(x + " ");
		}
		
		//2D Array
		System.out.println("\n******** 2D Array:");
		int queries[][]= new int [3][3];
		queries[0][0]= 1;
		queries[0][1]= 5;
		queries[0][2]= 3;
		queries[1][0]= 4;
		queries[1][1]= 8;
		queries[1][2]= 7;
		queries[2][0]= 6;
		queries[2][1]= 9;
		queries[2][2]= 1;
		l = queries.length; //LENGTH
		
		int queries2 [][] = { { 1, 2, 100},
							  { 2, 5, 100},
							  { 3, 4, 100} };
		queries = queries2;		
		print2D(queries);
		print2D(queries2);
		
		// 2D ArrayList		
		System.out.println("\n******** 2D Array List");
		List <List<Integer>> arlst = new ArrayList <List<Integer>> ();
		arlst.add(Arrays.asList(6, 2, 8));
		arlst.add(Arrays.asList(2, 5, 0));
		arlst.add(Arrays.asList(1, 3, 7));

		System.out.println(arlst.get(1).get(1)); //get an element from an array list
		
		//array list strings
		System.out.println("\n******** Array List String:");
		ArrayList<String> arr3 = new ArrayList<String>();
		arr3.add("mmm");
		arr3.add("ccc");
		arr3.remove("ccc"); //remove the object
		arr3.remove(0); //remove object found at index
		arr3.add("mmm");
		arr3.add("ccc");
		l = arr3.size(); //LENGTH
		arr3.equals(arrC); //EQUALS
		str = arr3.get(0);  //GET
		arr3.isEmpty();  //IS EMPTY
		for(String s: arr3) {
		System.out.print(s+ ", ");
		}
		
		System.out.println("\n******** Array List Character:");
		
		//array list char
		ArrayList<Character> arrLc = new ArrayList<Character>();
		arrLc.add('a');
		arrLc.add('b');
		for(char s: arrLc) {
			System.out.print(s+ ", ");
			}
		System.out.println("\n******** Array List Integer:");
		ArrayList<Integer> arrInt = new ArrayList<Integer>();
		arrInt.add(3);
		arrInt.add(2);
		System.out.println(arrInt.get(0));
		
		//list
		System.out.println("\n******** List String:");
		List<String> list = new ArrayList<String>();
		list.add("bla");
		list.add("dgFg");
		l = list.size();  //SIZE
		list.equals("fgdg"); //EQUALS
		list.isEmpty(); //IS EMPTY
		System.out.println(list.get(1));  //GET
		
		System.out.println("\n******** List Character:");
		List<Character> listChar = new ArrayList<Character>();
		listChar.add('a');
		listChar.add('b');
		listChar.add(0, 'c');
		System.out.println(listChar.get(0));
		
		//Iterator
		System.out.println("\n******** Iterator:");
		Iterator<Character> it = listChar.listIterator(); 
        while (it.hasNext()) { 
            char n = it.next(); 
            System.out.println(n);
        } 
		
		//Linked List
		System.out.println("\n******** Linked List:");
		LinkedList <String> myLList = new LinkedList <String>();
		myLList.add("element");
		myLList.add("car");
		myLList.size(); //size
		myLList.isEmpty(); // is Empty
		myLList.getFirst().equals("sdsd");  //EQUALS
		System.out.println(myLList.getFirst());
		System.out.println(myLList.getLast());
		System.out.println(myLList.removeFirst());
		
		//stack
		System.out.println("\n******** Stack Strings:");
		Stack <String >stac = new Stack<String>();
		stac.push("Happy");
		stac.push("New");
		stac.push("Year");
		stac.isEmpty();  //is Empty
		System.out.println(stac.size());  // SIZE
		System.out.println(stac.capacity()); // CAPACITY
		while(!stac.isEmpty()) {
			System.out.println(stac.pop());  
		}
		System.out.println("\n******** Stack Doubles:");
		Stack<Double>stackDouble = new Stack<Double>();
		stackDouble.push(3.32);
		stackDouble.push((double) 2);
		stackDouble.push(0.1);
		while(!stackDouble.isEmpty()) {
			System.out.print(stackDouble.pop() + ", ");
		}
		
		//Queue
		System.out.println("\n******** Queue:");
		Queue<Comparable> que1 = new LinkedList<Comparable>();
		que1.add(1);
		que1.add("as");
		que1.add(2);
		que1.add('c');
		que1.peek().equals(1);  //EQALS
		que1.size();  // SIZE
		que1.contains('d'); //CONTAINS
		que1.isEmpty(); // is Empty
		que1.peek();  //retrive but not remuve had
		que1.poll();  //retrive and remove, if nothing return null
		System.out.print(que1.remove() + ", "); //remove, if nothing get error
		System.out.print(que1.remove() + ", ");
		System.out.print(que1.remove() + ", ");
		System.out.print(que1.poll());
		
		//priority queue
		System.out.println("\n******** Priority Queue:");
		PriorityQueue<String> namePriorityQueue = new PriorityQueue<String>();
        namePriorityQueue.add("Lisa");
        namePriorityQueue.add("Robert");
        namePriorityQueue.add("John");
        namePriorityQueue.add("Chris");
        namePriorityQueue.add("Angelina");
        namePriorityQueue.add("Joe");
        while (!namePriorityQueue.isEmpty()) {
            System.out.println(namePriorityQueue.remove());
        }
        System.out.println("\n******** Priority Queue with comparator:");
        
        // A custom comparator that compares two Strings by their length.
        Comparator<String> stringLengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        };
        PriorityQueue<String> namePriorityQueue2 = new PriorityQueue<String>(stringLengthComparator);
        namePriorityQueue2.add("Lisa");
        namePriorityQueue2.add("Robert");
        namePriorityQueue2.add("John");
        namePriorityQueue2.add("Chris");
        namePriorityQueue2.add("Angelina");
        namePriorityQueue2.add("Joe");
        while (!namePriorityQueue2.isEmpty()) {
            System.out.println(namePriorityQueue2.remove());
        }
		
        //Hash table
        System.out.println("\n******** Hash Table:");
		Hashtable<Integer, String> h = new Hashtable<Integer, String>();
		h.put(1, "bum bum");
		h.put(2, "trilu lilu");
		h.put(1, "bum bum");
		h.size(); //SIZE
		h.isEmpty(); //is Empty
		h.containsKey(1); //Contains Key
		h.containsValue("bum"); // Contains value
		System.out.println(h.get(2));
		System.out.println(h); // GET
		
		//Hash map  - much faster like a tree map 
		System.out.println("\n******** Hash Map:");
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(2, "Apple");
		hm.put(3, "Google");
		hm.put(2, "Appple");
		hm.size(); //SIZE
		hm.isEmpty(); //is Empty
		hm.containsKey(2); //Contains Key
		hm.containsValue("Apple"); // Contains value
		System.out.println(hm.get(2));  // GET
		System.out.println(hm);
		for (int k : hm.keySet())  //Iterate through hash map
			System.out.println(hm.get(k));
		
		//Hash set - much faster O(1) for insert, dell, add but do not keep the natural order
		System.out.println("\n******** Hash Set:");
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(3);
		hs.add(4);
		hs.add(1);
		hs.add(3);
		hs.add(1);
		hs.size(); //SIZE
		hs.isEmpty(); //is Empty
		System.out.println(hs.contains(3)); //Contains
		System.out.println(hs.contains(5));
		hs.remove(4); //Remove
		Iterator <Integer> hit = hs.iterator();   //iterating through a hash set
		while(hit.hasNext()) System.out.println(hit.next());
	//	System.out.println(hs);
		
		//Tree set  - hash set much faster but not keep order, tree set keeps natural order
		System.out.println("\n******** Tree Set:");
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(5);
		ts.add(3);
		ts.add(4);
		ts.add(4);
		ts.add(1);
		ts.add(6);
		ts.add(0);
		ts.size(); //SIZE
		ts.isEmpty(); //is Empty
		System.out.println(ts.contains(5)); //Contains
		ts.remove(3); //Remove
		ts.first();
		ts.last();
		System.out.println(ts);
		
		//Tree map  - use beater a hash map because is faster
		System.out.println("\n******** Tree Map:");
		TreeMap<Integer, Character> tm = new TreeMap<Integer, Character>();
		tm.put(1, 'a');
		tm.put(2, 'x');
		tm.put(1, 'c');
		tm.size(); //SIZE
		tm.isEmpty(); //is Empty
		tm.containsKey(1); //Contains Key
		System.out.println(tm.containsKey(1)); // Contains value
		System.out.println(tm.get(2)); // GET
		System.out.println(tm.keySet());
		tm.remove(2); //Remove
		System.out.println(tm);
		
		//Dynamic Programming
		System.out.println("\n***********Dynamic Programing");
		Scanner console = new Scanner(System.in); 
		int nr;
		//Prompting the user for a number in order to find the factorial
		System.out.print("Please enter a number: ");
		nr = console.nextInt(); 
		System.out.println("You entered: "+ nr);
		
	}
	
	//method that prints an 2D array
	static void print2D(int[][] queries) {
		for (int x =0; x < queries.length; x++) {
			for (int j =0; j < queries.length; j++) {
				System.out.print(queries[x][j]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void print( int[] numbers ) {
		 for(int i = 0; i < numbers.length; i++) {
		    System.out.print(numbers[i]);
		 }
		 System.out.println();
		 }
}