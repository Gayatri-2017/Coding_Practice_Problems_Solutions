/*package whatever //do not write package name here */

/*
Given an array arr of  size n of positive integers, the task is to sort all the special primes in their relative position (without affecting the position of other elements).
Special primes are the prime numbers which can be represented as the sum of two other prime numbers.

https://practice.geeksforgeeks.org/contest-problem/special-primes/0/

*/
import java.util.*;
import java.lang.*;
import java.io.*;

class SpecialPrimes {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int noOfTests = 0;		
		noOfTests = sc.nextInt();
		while(noOfTests>0){
			int arrLength = sc.nextInt();
			int arr[] = new int[arrLength];
			boolean isSpecialPrimeArray[] = new boolean[arrLength];
			
			int indexSort = 0;
			for (int i=0; i<arrLength; i++) {
				isSpecialPrimeArray[i] = false;
			}
			int noOfSpecPrimes = 0;
			for (int i=0; i<arrLength; i++) {
				arr[i] = sc.nextInt();
				// System.out.println(isSpecialPrime(arr[i]));
				if(isSpecialPrime(arr[i])){
					isSpecialPrimeArray[i] = true;
					noOfSpecPrimes++;
				}
			}
			int toBeSorted[] = new int[noOfSpecPrimes];
			for (int i=0; i<arr.length; i++) {
				if(isSpecialPrimeArray[i] == true){
					toBeSorted[indexSort] = arr[i];
					indexSort++;
				}
			}
			Arrays.sort(toBeSorted);
			
	        // int temp;
	        // for (int i=0; i<noOfSpecPrimes/2; i++) {
	        // 	temp = toBeSorted[i];
	        // 	toBeSorted[i] = toBeSorted[noOfSpecPrimes-i-1];
	        // 	toBeSorted[noOfSpecPrimes-i-1] = temp;
	        // }

			indexSort = 0;
			for (int i=0; i<arrLength; i++) {
				if(isSpecialPrimeArray[i] == true){
					arr[i] = toBeSorted[indexSort];
					indexSort++;
				}
			}
			// System.out.println("New array");
			for (int i=0; i<arrLength; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			noOfTests--;
		}

	}
	static boolean isPrime(int num){
		if(num < 2){
			return false;
		}
		for (int i=2; i<= Math.sqrt(num); i++) {
			if(num%i == 0){
				return false;
			}
		}
		return true;
	}

	static boolean isSpecialPrime(int num){
		if(isPrime(num) && isPrime(num-2)){
			return true;
		}
		else{
			return false;
		}
	}
}