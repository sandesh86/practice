package com.test;

import java.util.Scanner;

public class Reverse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();
		
		for (int test_case = 0; test_case < testCase; test_case++) {
			
			int [] mainSet = {1, 4, 3, 9, 5, 3 , 6, 5, 22, 33, 7, 12};
			int [] set1 = {1, 3, 5, 3 , 5, 33, 7};
			int [] set2 = {4, 9, 5, 6, 22, 12};
			int idx1 = 0;
			int idx2 = 0;
			boolean isSet1 = false;
			boolean isSet2 = false;
			for (int i = 0; i < mainSet.length; i++) {				
				if(!isSet1 && set1[idx1] == mainSet[i]){
					idx1++;
					if(idx1 == set1.length)
						isSet1 = true;										
				}
				else if(!isSet2 && set2[idx2] == mainSet[i]){
					idx2++;
					if(idx2 == set2.length)
						isSet2 = true;					
				}
			}
			if(isSet1)
				System.out.println(1);
			else
				System.out.println(0);
			idx1 = 0;
			idx2 = 0;
			if((isSet1 && !isSet2) || (!isSet1 && isSet2)){
				isSet1 = false;
				isSet2 = false;
				for (int i = 0; i < mainSet.length; i++) {
					
					if(!isSet2 && set2[idx2] == mainSet[i]){
						idx2++;
						if(idx2 == set2.length)
							isSet2 = true;
					}
					else if(!isSet1 && set1[idx1] == mainSet[i]){
						idx1++;
						if(idx1 == set1.length)
							isSet1 = true;	
					}
				}
			}
			
			if(isSet2)
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

}
