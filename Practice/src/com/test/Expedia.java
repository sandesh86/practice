package com.test;

public class Expedia {

	public static void main(String[] args) {
		B a = (B) new A();
		a.m1();
	}
}

class A {
	public static void m1(){
		System.out.println("A");
	}
}

class B extends A {
	public static void m1(){
		System.out.println("B");
	}
}