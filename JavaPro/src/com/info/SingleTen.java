package com.info;

public class SingleTen {

	private static SingleTen singleTen ;
	
	static{
		singleTen = new SingleTen();
	}
	
	private SingleTen(){
		
	}
	public static SingleTen getInstance(){
		return singleTen;
	}

	public void testMe(){
		System.out.println("yay its working");
	}
	
	public static void main(String args[]){
		SingleTen sin = getInstance();
		
		sin.testMe();
	}
}
