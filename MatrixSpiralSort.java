// Sort the border of a matrix. Go around and successively sort all the borders. 

import java.util.*;

class MatrixSpiralSort{
	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter value of n");
		int n = sc.nextInt();

		int numberOfBorders = n/2;
		int numberOfMaxElements = 4*(n-1);

		// int borderArray[] = new int[numberOfMaxElements];

		int matrix[][] = new int[n][n];

		System.out.println("Enter matrix");

		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		System.out.println("The input matrix is");

		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		int borderArrayMaxLength = 4*(n-1);

		// int borderArrayIndex = 0;
		for (int k=0; k<numberOfBorders; k++) {
			int borderArray[] = new int[borderArrayMaxLength];		
			int borderArrayIndex = 0;

			System.out.println("borderArray.length = " + borderArray.length);

			System.out.println("k = " + k);
			System.out.println("borderArrayIndex = " + borderArrayIndex);
			
			for (int i=k, j=k; j<n-k-1; j++) {
				//first row
				System.out.println("In for loop 1, (i,j) = (" + i + "," + j + "), borderArrayIndex = " + borderArrayIndex);
				borderArray[borderArrayIndex++] = matrix[i][j];
 			}
 			for (int j=n-1-k, i=k; i<n-k-1; i++) {
 				// last column
 				System.out.println("In for loop 2, (i,j) = (" + i + "," + j + "), borderArrayIndex = " + borderArrayIndex);
				borderArray[borderArrayIndex++] = matrix[i][j];
 			}
 			for (int i=n-1-k, j=n-1-k; j>=k+1; j--) {
 				// last row
 				System.out.println("In for loop 3, (i,j) = (" + i + "," + j + "), borderArrayIndex = " + borderArrayIndex);
				borderArray[borderArrayIndex++] = matrix[i][j];
 			}
 			for (int j=k, i=n-1-k; i>=k+1; i--) {
 				// first column
 				System.out.println("In for loop 4, (i,j) = (" + i + "," + j + "), borderArrayIndex = " + borderArrayIndex);
				borderArray[borderArrayIndex++] = matrix[i][j];
 			}

 			Arrays.sort(borderArray);

 			System.out.println("Sorted BorderArray");
 			for (int i=0; i<borderArray.length; i++ ) {
 				System.out.print(borderArray[i] + " ");
 			}
 			System.out.println();

 			borderArrayIndex = 0;

 			for (int i=k, j=k; j<n-k-1; j++) {
				//first row
				System.out.println("In for loop 5, (i,j) = (" + i + "," + j + "), borderArrayIndex = " + borderArrayIndex);
				matrix[i][j] = borderArray[borderArrayIndex++];
 			}
 			for (int j=n-1-k, i=k; i<n-k-1; i++) {
 				// last column
 				System.out.println("In for loop 6, (i,j) = (" + i + "," + j + "), borderArrayIndex = " + borderArrayIndex);
				matrix[i][j] = borderArray[borderArrayIndex++];
 			}
 			for (int i=n-1-k, j=n-1-k; j>=k+1; j--) {
 				// last row
 				System.out.println("In for loop 7, (i,j) = (" + i + "," + j + "), borderArrayIndex = " + borderArrayIndex);
				matrix[i][j] = borderArray[borderArrayIndex++];
 			}
 			for (int j=k, i=n-1-k; i>=k+1; i--) {
 				// first column
 				System.out.println("In for loop 8, (i,j) = (" + i + "," + j + "), borderArrayIndex = " + borderArrayIndex);
				matrix[i][j] = borderArray[borderArrayIndex++];
 			}

 			borderArrayMaxLength -= 8;

		}

		System.out.println("Spirally Sorted matrix");

		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

	}
}