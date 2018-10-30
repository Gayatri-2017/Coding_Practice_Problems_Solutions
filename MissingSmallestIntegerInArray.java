/*

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].

*/
import java.util.Scanner;
import java.util.Arrays;

class MissingSmallestIntegerInArray{
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter noOfElements");
		int noOfElements = sc.nextInt();
		System.out.println("Enter the elements");
		int array[] = new int[noOfElements];
		for (int i=0; i<noOfElements; i++) {
			array[i] = sc.nextInt();
		}
		//Sort the array
		Arrays.sort(array);
		//Find the difference between the consecutive elements in the array from lhs
		//If difference is greater than 1, then the missing value is smaller integer + 1
		int ans = diff(array);
		System.out.println("The diff is " + ans);
	}
	static int diff(int array[]){
		for (int i=0; i<array.length; i++) {
			if(array[i] < 0){
				array[i] = 0;
			}
		}
		//if min value is greater than 1 return 1
		int minvalue = Integer.MAX_VALUE;
		for (int i=0; i<array.length; i++) {
			if(array[i] < minvalue){
				minvalue = array[i];
			}
		}
		if (minvalue > 1) {
			return 1;
		}
		for (int i=0; i<array.length-1; i++) {

			if(array[i+1] - array[i] > 1){
				
				return (array[i] + 1);
			}
		}
		
		return (array[array.length-1] + 1);
	}
}