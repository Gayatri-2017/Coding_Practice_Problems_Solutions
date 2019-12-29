import java.util.*;

class Anagram{
	public static void main(String args[]){

		int MAXCHAR = 26;
		// System.out.println("Hello!");
		String str1 = "aHOZhello";
		String str2 = "alhZhOEEo";

		if (str1.length() != str2.length()){
			System.out.println("Not a match");
			return;
		}
		// else{
		// 	System.out.println("Can be a match");
		// }

		int count[] = new int[MAXCHAR];

		String str1Lower = str1.toLowerCase();
		String str2Lower = str2.toLowerCase();

		// System.out.println("str1 \n" + str1Lower);
		// System.out.println("str2 \n" + str2Lower);

		for (int i = 0; i < str1.length(); i++) {
			// System.out.println("i = " + i);
		
			// System.out.println("str1 \n" + (((int)str1Lower.charAt(i))-97));
			// System.out.println("str2 \n" + (((int)str2Lower.charAt(i))-97));

			count[(((int)str1Lower.charAt(i))-97)]++;
		}

		for (int i = 0; i < str1.length(); i++) {
			// System.out.println("i = " + i);
		
			// System.out.println("str1 \n" + (((int)str1Lower.charAt(i))-97));
			// System.out.println("str2 \n" + (((int)str2Lower.charAt(i))-97));

			count[(((int)str2Lower.charAt(i))-97)]--;
			// System.out.println(str2Lower.charAt(i)+" count["+"] = "+count[(((int)str2Lower.charAt(i))-97)]);
			if (count[(((int)str2Lower.charAt(i))-97)] < 0) {
				System.out.println("Not a match");
				return;
			}
		}
		
		// for (int i = 0; i < MAXCHAR; i++) {
		// 	if (count[i] != 0){
		// 		System.out.println("Not a match");
		// 		return;
		// 	}
		// }
		System.out.println("Match");
	}
}