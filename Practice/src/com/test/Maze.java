package com.test;

import java.util.Scanner;

public class Maze {
	static class Node{
		int row = 0;
		int col = 0;
		public Node(){
			this.row = 0;
			this.col = 0;
		}
	}
	static int [][] maze;
	static int front = 0;
	static int rear = 0;
	static Node[] myQueue;
	static int [] dRow = {0, 1, 0, -1};
	static int [] dCol = {1, 0, -1, 0};
	static int N;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for (int test_case = 0; test_case < testCase; test_case++) {
			
			N = sc.nextInt();
			maze = new int[N][N];
			myQueue = new Node[N*N];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					maze[i][j] = sc.nextInt();
				}
			}
			int count = 0;
			int newArr [];
			int [] tempArr = new int[1];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(maze[i][j] != 0 && maze[i][j] != -1){
						int curMax = searchBlock(i, j);
						count++;
						
						newArr = new int[count];
						System.arraycopy(tempArr, 0, newArr, 0, count-1);
						newArr[count-1] = curMax;
						tempArr = new int[count];
						System.arraycopy(newArr, 0, tempArr, 0, count);
					}
				}
			}
			
			System.out.println("#Case"+(test_case+1));
			System.out.println(count);
			for (int i = 0; i < tempArr.length; i++) {
				System.out.print(tempArr[i] + " ");
			}
		}
	}

	public static int searchBlock(int row, int col){
		Node node = new Node();
		node.row = row;
		node.col = col;
		enqueue(node);
		int max = maze[row][col];
		while(!isEmpty()){
			Node xNode = dequeue();
			row = xNode.row;
			col = xNode.col;
			maze[row][col] = -1;
			             
			for (int i = 0; i < 4; i++) {
				int curRow = row + dRow[i];
				int curCol = col + dCol[i];
				
				if(curRow >= 0 && curCol >=0 && curRow < N && curCol < N){					
					if(maze[curRow][curCol] != 0 && maze[curRow][curCol] != -1){
						if(maze[curRow][curCol] > max){
							max = maze[curRow][curCol];
						}
						Node myNode = new Node();
						myNode.row = curRow;
						myNode.col = curCol;
						enqueue(myNode);
						maze[curRow][curCol] = -1;
					}
				}
			}
		}
		
		return max;
	}
	
	public static void enqueue(Node node){
		myQueue[rear++] = node;
	}
	
	public static Node dequeue(){
		return myQueue[front++];
	}
	
	public static boolean isEmpty(){
		if(front == rear)
			return true;
		else
			return false;
	}
}
