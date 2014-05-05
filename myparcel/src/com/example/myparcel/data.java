package com.example.myparcel;

public class data {
	
	int iNum;
	float fNum;
	String myStr;
	
	public data(int iNum, float fNum, String myStr) {
		this.iNum = iNum;
		this.fNum = fNum;
		this.myStr = myStr;
	}
	
	public int getInt() {
		return iNum;
	} 
	
	public float getFloat() {
		return fNum;
	}
	
	public String getStr() {
		return myStr;
	}

}
