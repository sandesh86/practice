package com.test;

import java.util.Scanner;

public class MazeDFS {

	static class Node {
		int row = 0;
		int col = 0;
	}
	static int N;
	
	static int [][] maze;
	static int front = 0;
	static int rear = 0;
	static Node[] myQueue;
	
	static int [] mRow = {0, 1, 0, -1};
	static int [] mCol = {1, 0, -1, 0};
	
	public static void main(String[] args) {
		mazeDFS();
	}
	
	public static void mazeDFS() {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		maze = new int [N][N];
		myQueue = new Node[N*N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maze [i][j] = sc.nextInt();
			}
		}
		int count = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (maze[i][j] != 0 && maze[i][j] != -1) {
					int cnt = searchBlock(i, j);
					if (cnt > max) {
						max = cnt;
					}
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println(max);
		sc.close();
	}
	
	public static int searchBlock(int row, int col) {
		Node node = new Node();
		node.row = row;
		node.col = col;
		enqueue(node);
		int cnt = 0;
		while (!isEmpty()) {
			Node currNode = dequeue();
			row = currNode.row;
			col = currNode.col;
			if (maze[row][col] != 0 && maze[row][col] != -1) {
				maze[row][col] = -1;
				cnt++;
			}
			for (int i = 0; i < 4; i++) {
				int currRow = row + mRow[i];
				int currCol = col + mCol[i];
				
				if (currRow >= 0 && currCol >= 0 && currRow < N && currCol < N) {
					if (maze[currRow][currCol] != 0 && maze[currRow][currCol] != -1) {
						Node newNode = new Node();
						newNode.row = currRow;
						newNode.col = currCol;
						maze[currRow][currCol] = -1;
						cnt++;
						enqueue(newNode);
					}
				}
			}
		}
		return cnt;
	}
	
	public static void enqueue(Node node) {
		myQueue[rear++] = node;
	}
	
	public static Node dequeue() {
		return myQueue[front++];
	}
	
	public static boolean isEmpty() {
		if (front == rear) {
			return true;
		}
		else {
			return false;
		}
	}
}
