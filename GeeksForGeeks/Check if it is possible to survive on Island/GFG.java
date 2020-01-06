/*

Ishika got stuck on an island. There is only one shop on this island and it is open on all days of the week except for Sunday. Consider following constraints:

N – The maximum unit of food you can buy each day.
S – Number of days you are required to survive.
M – Unit of food required each day to survive.
Currently, it’s Monday, and she needs to survive for the next S days.
Find the minimum number of days on which you need to buy food from the shop so that she can survive the next S days, or determine that it isn’t possible to survive.

https://practice.geeksforgeeks.org/problems/check-if-it-is-possible-to-survive-on-island/0

*/

/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner sc = new Scanner(System.in);
		int noOfCases = sc.nextInt();
		while(noOfCases-- >0){
			int noOfSurvDays = sc.nextInt();
			int maxFoodPerDay = sc.nextInt();
			int foodEachDay = sc.nextInt();
			int remFood = maxFoodPerDay;
			int noOfFoodDays;

			if(foodEachDay>maxFoodPerDay){
				System.out.println("-1");
			}
// 			else if(foodEachDay==maxFoodPerDay && noOfSurvDays > 6){
// 				System.out.println("-1");
// 			}
			else{
				int buyCount = 0;
				
				// System.out.println(noOfFoodDays);
				// buyCount++;

				// if(( ((remFood%foodEachDay)*6)) < foodEachDay && (remFood+maxFoodPerDay) && noOfSurvDays > 6){
				//     buyCount = -1;
				    // break;
				// }
				
				// System.out.println("remFood = " + remFood + " (remFood%foodEachDay) = " + (remFood%foodEachDay));
				// System.out.println("((remFood%foodEachDay)*6) = " + ((remFood%foodEachDay)*6));
				// System.out.println("foodEachDay = " + foodEachDay);
				// System.out.println("maxFoodPerDay = " + maxFoodPerDay);
				// System.out.println("(remFood%foodEachDay)+maxFoodPerDay = " + (remFood%foodEachDay)+maxFoodPerDay);
				// System.out.println("noOfSurvDays = " + noOfSurvDays);
				// System.out.println("If condition is: \n(((remFood%foodEachDay)*6)<foodEachDay) && ((remFood%foodEachDay)+maxFoodPerDay<foodEachDay) && noOfSurvDays > 6");

				if( (((remFood-foodEachDay)*6)+maxFoodPerDay<2*foodEachDay) && noOfSurvDays > 6){
				    buyCount = -1;
				    // break;
				}
				int noOfDaysPassed = 0;
				while(noOfSurvDays>0 && buyCount >= 0){
					noOfFoodDays = remFood / foodEachDay;
					noOfSurvDays -= noOfFoodDays;
					remFood %= foodEachDay;

					// buyCount++;
				// 	System.out.println("noOfFoodDays = " + noOfFoodDays + " noOfSurvDays = " + noOfSurvDays + " remFood = " + remFood + " foodEachDay = " + foodEachDay + " buyCount = " + buyCount);
					
					if(remFood < foodEachDay){
						buyCount++;
						remFood += maxFoodPerDay;
					}

				}
				System.out.println(buyCount);
			}
		}
	}
}
