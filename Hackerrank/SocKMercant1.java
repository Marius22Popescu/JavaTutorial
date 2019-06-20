package Hackerrank;
// foo version to pass hackerrank.com test 
public class SocKMercant1 {
	public static void main(String[] args) {
		int[] ar = {1, 2, 1, 2, 1, 3, 2};
		int n = ar.length;
		int x = sockMerchant(n, ar);
		System.out.println("The number of socks is: " + x);
	}

	private static int sockMerchant(int n, int[] ar) {
		int[] arr = ar;
		int pairs = 0;
		for (int i = 0; i < n - 1; i++) {
			for(int j = i+1; j < n; j ++) {
				if((arr[i]==arr[j])&&(arr[i] != -123456)) {
					pairs++;
					arr[j] = -123456;
					break;
				}
			}
		}
		return pairs;
	}
}
