/*package whatever //do not write package name here */

/*
Given two encoded strings str1 and str2 consisting of upper-case English alphabets and the character ‘#’, decode the string based on the following operation:
Whenever a ‘#’ is encountered, increment the previously encountered alphabet by 1 (in a cyclic fashion i.e. A -> B, B -> C, ….., Z -> A). Finally, print Yes if both the strings are equal, else print No.
Note: Every string will begin with an English alphabet.

https://practice.geeksforgeeks.org/contest-problem/the-manipulator/0/

*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Manipulator {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int noOfTests = 0;
		char alphaA = 'A';
		noOfTests = sc.nextInt();
		while(noOfTests>0){
			String str1 = sc.next();
			String str2 = sc.next();
			// System.out.println(str1.charAt(0)+0);
			// System.out.println(str1.charAt(0)+1);
			// if(str1.length() != str2.length()){
			// 	System.out.println("No");
			// }
			// else{
			int strLength1 = str1.length();
			char arr1[] = new char[strLength1];
			
			int indArr1 = 0;
			
			for (int i=0; i<strLength1; i++) {
				if(Character.isLetter(str1.charAt(i))){
					arr1[indArr1] = str1.charAt(i);
					indArr1++;
					// for (int j=0; j<arr1.length; j++) {
					// 	System.out.print(arr1[j]);
					// }
					// System.out.println();
				}
				else if (str1.charAt(i) == '#'){
					if(arr1[indArr1-1] == 'Z'){
						arr1[indArr1-1] = 'A';
					}
					else{
						arr1[indArr1-1]++;
					}
					// for (int j=0; j<arr1.length; j++) {
					// 	System.out.print(arr1[j]);
					// }
					// System.out.println();
				}
				// }
				

			}

			int strLength2 = str2.length();
			char arr2[] = new char[strLength2];
			int indArr2 = 0;

			for (int i=0; i<strLength2; i++) {
				
				if(Character.isLetter(str2.charAt(i))){
					arr2[indArr2] = str2.charAt(i);
					indArr2++;
					// for (int j=0; j<indArr2; j++) {
					// 	System.out.print(arr2[j]);
					// }
					// System.out.println();
				}
				else if (str2.charAt(i) == '#'){
					if(arr2[indArr2-1] == 'Z'){
						arr2[indArr2-1] = 'A';
					}
					else{
						arr2[indArr2-1]++;
					}
					// for (int j=0; j<indArr2; j++) {
					// 	System.out.print(arr2[j]);
					// }
					// System.out.println();
				}

			}

			String output = "Unset";
			if(indArr1 != indArr2){
				// System.out.println("No");
				output = "No";
			}
			else{
				for (int i=0; i<indArr1; i++) {
					if(arr1[i] != arr2[i]){
						// System.out.println("No");	
						output = "No";
						break;		
					}
				}
			}
			if(output.equals("Unset")){
				output = "Yes";
			}
			System.out.println(output);
			noOfTests--;
		}

	}
}
