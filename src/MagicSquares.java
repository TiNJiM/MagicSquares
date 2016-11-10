import java.util.*;
import java.io.*;
public class MagicSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner n1 = new Scanner (System.in);
		boolean isMagicSquare = true; //starts true; if false, skips every loop
		int array[][] = new int [4][4]; //will always be 4x4
		for (int c1 = 0; c1<4;c1++) { //rows
			for (int c2 = 0; c2<4; c2++) { //columns
				System.out.print("Row: " + (c1+1) + " Column: " + (c2+1) + " Please input value: ");
				array[c1][c2] = n1.nextInt();
			}
		}
		int prevRowSum = 0;
		for (int cRow = 0; cRow < 4; cRow++) { //checks the equality of rows
			int rowSum = 0;
			for (int cCol = 0; cCol < 4; cCol++) {
				rowSum += array[cRow][cCol];
			}
			if (cRow != 0) { //doesn't check the first row, since there's nothing to compare it to yet
				if (rowSum != prevRowSum) { //if they're not equal;
					isMagicSquare = false;
					System.out.println ("Rows are unequal");
					break;
				}
			}
			prevRowSum = rowSum;
		}
		int prevColSum = 0;
		for (int cCol2 = 0; cCol2 < 4; cCol2++) { //checks the equality of columns
			int colSum = 0;
			for (int cRow2 = 0; cRow2 < 4; cRow2++) {
				colSum += array[cRow2][cCol2];
			}
			if (cCol2 != 0) {
				if (colSum != prevColSum) {
					isMagicSquare = false;
					System.out.println("Columns are unequal");
					break;
				}
			}
			prevColSum = colSum;
		}
		int dia0 = array[0][0] + array[1][1] + array[2][2] + array[3][3];
		int dia1 = array[0][3] + array[1][2] + array[2][1] + array[3][0];
		if (dia0 != dia1) {
			isMagicSquare = false;
			System.out.println("Diagonals are unequal");
		}
		if (prevRowSum != prevColSum || prevRowSum != dia0 || prevColSum != dia0) {
			isMagicSquare = false;
			System.out.println("Sums are unequal");
		}
		if (prevRowSum == prevColSum && prevRowSum == dia0 && isMagicSquare != false) { //as long as isMagicSquare == true, the other parts work. if isMagicSquare == false, the other parts might still be equal, but it would be wrong anyway
			System.out.println("This is a magic square!");
		}
		else {
			System.out.println("This is not a magic square");
		}
	}
}