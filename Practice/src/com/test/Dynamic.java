package com.test;

public class Dynamic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2};
		int arrNew [] = new int[2];
		
		System.arraycopy(arr, 0, arrNew, 0, 1);
		arrNew[1] = 5;
		System.out.println(arrNew[1]);
	}

}
