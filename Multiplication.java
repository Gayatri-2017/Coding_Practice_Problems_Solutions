/*
a is n bit number and b is kn bit number. Devise an algorithm for multiplication.

*/
import java.util.*;

class Multiplication{
	public static void main(String args[]){
		double a = 100;
		double b = 123456789;
		double n = 2;
		double prod = 0;
		double temp = (int)Math.pow(10, 0);
		while(b!=0){
			System.out.println("b = "+ b);
			double r = (int)(b%(double)Math.pow(10, n));
			System.out.println("r = "+ r);
			prod += a*r*temp;
			temp *= ((double)Math.pow(10, n));
			System.out.println("prod = "+ prod);
			// b = (int)(b/(double)Math.pow(10, n));
			b = (int)(b/(double)Math.pow(10, n));
		}
	}
}

/*
temp = Math.pow(10, 0);
while(b!=0){
	r = (b%Math.pow(10, n));
	prod += a*r*temp;
	temp *= (Math.pow(10, n));
	b = (b/Math.pow(10, n));
}
*/
