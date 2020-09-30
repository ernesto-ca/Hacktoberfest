package matrix;

/*****************************************************************************
 *  This is a simple program that read two values N and M
 *  and create a matrix with N columns & M rows then it print the matrix.
 *  Next you are asked to input a number that needed to be a matrix value
 * 	and then it prints out his neighbors.
 * **************************************************************************/

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("input the values for N & M: ");
		int N = in.nextInt();
		int M = in.nextInt();

		int[][] mtx = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mtx[i][j] = in.nextInt();
			}
		}

		System.out.println("\n------------MATRIX------------");
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(mtx[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n------------MATRIX------------");

		System.out.print("Input a number: ");
		int n = in.nextInt();

		for (int i=0; i<mtx.length; i++) {
			for (int j=0; j<mtx[i].length; j++) {
				if (mtx[i][j] == n) {
					System.out.println("Position " + i + "," + j + ":");
					if (j > 0) {
						System.out.println("Left: " + mtx[i][j-1]);
					}
					if (i > 0) {
						System.out.println("Up: " + mtx[i-1][j]);
					}
					if (j < mtx[i].length-1) {
						System.out.println("Right: " + mtx[i][j+1]);
					}
					if (i < mtx.length-1) {
						System.out.println("Down: " + mtx[i+1][j]);
					}
				}
			}
		}

		in.close();

	}

}
