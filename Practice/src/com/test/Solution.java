package com.test;

import java.util.Queue;

class Solution {
	int end = 0;
	
	int [] myQueue = null;
	
	public static void main(String[] args) {
		int A[] = {1,2,4,5,7,24,25,29,30};
		System.out.println(new Solution().solution("3 DUP 5 - -"));
	}
	
	public int solution(String S) {
		
		String opr[] = S.split(" ");
		
		myQueue = new int[opr.length];
		
		for (int i = 0; i < opr.length; i++) {
			try {
				int value = Integer.parseInt(opr[i]);
				push(value);
			}
			catch (Exception e) {
				if ("DUP".equals(opr[i])) {
					int node = pop();
					push(node);
					push(node);
				}
				else if ("POP".equals(opr[i])) {
					if (end == 0) {
						return -1;
					}
					pop();
				}
				else if ("+".equals(opr[i])) {
					if (end == 1) {
						return -1;
					}
					int node1 = pop();
					int node2 = pop();
					push((node1+node2));
				}
				else if ("-".equals(opr[i])) {
					if (end == 1) {
						return -1;
					}
					int node1 = pop();
					int node2 = pop();
					push((node1-node2));
				}
			}
		}
		
		return myQueue[end-1];
	}
    public int solution(int[] A) {
        // write your code in Java SE 8
    	
        int result = 0;
        
        int noDays = A.length;
        
        if (noDays >= 23) {
        	return 25;
        }
        
        int diff = 0;
        for (int i = 0; i < noDays-3; i++) {
        	diff = (A[i+3] - A[i+2]) + (A[i+2] - A[i+1]) + (A[i+1] - A[i]);
        	if (diff > 6) {
        		result += 2;
        	}
        	else {
        		result +=7;
        		int val = A[i+3];
        		for (int j = i + 4; j < noDays; j++) {
        			diff += (A[j] - val);
        			if (diff <= 6) {
        				i++;
        			}
        			else {
        				break;
        			}
        			val = A[j];
        		}
        		i = i + 3;
        		if (i > (noDays-4)) {
        			result += (((noDays-1) - i) * 2);
        		}
        	}
        }       
        
    	return result; 
    }
    
    public void push(int value) {
    	myQueue[end++] = value;
    }
    
    public int pop() {
    	return myQueue[--end];
    }
}
