package com.test;

import java.io.IOException;
import java.util.Scanner;

public class MagicSquare {

	// Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] square, int n) {
    	
		int magicQube[][][] = { { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } }, 
							{ { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } },
							{ { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } }, 
							{ { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } },
							
							{ { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } }, 
							{ { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } },
							{ { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } }, 
							{ { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } } };
		
		int magic[] = new int[8];
		int min1 = 0;
		for (int k = 0; k < 8; k++) {
			magic[k] = 0;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (square[i][j] != magicQube[k][i][j]) {
						magic[k] += Math.abs(square[i][j] - magicQube[k][i][j]);
					}
				}
			}

		}
		min1 = magic[0];
		for (int i = 1; i < 8; i++) {
			if (magic[i] < min1) {
				min1 = magic[i];
			}
		}

		return min1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] s = new int[3][3];

        for (int i = 0; i < 3; i++) {           
            for (int j = 0; j < 3; j++) {
                s[i][j] = scanner.nextInt();
            }
        }

        int result = formingMagicSquare(s, 3);
        System.out.println(result);
        scanner.close();
    }
}
