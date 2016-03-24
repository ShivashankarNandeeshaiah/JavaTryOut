package com.info;

public class DuplicateCharsInString {

	public static void main(String[] args) {

	
		if(null != args){
			char[] chartest = args[0].toCharArray();
			System.out.println("Input String " + args[0]);
			int lenth = chartest.length;
			char[] duplicatechar = new char[lenth];
			int n = 0;
			for(int i=0;i<lenth;i++){
				char one =chartest[i];
				int s = 0;
			for (int j=0;j<lenth;j++){
				
				if(one == chartest[j]){
					s++;
					if(s>1){
						duplicatechar[n] = one ;
						n++;
						System.out.println("Duplicate found " + one);
					}
				}
			}
			}
		}
	}

}
