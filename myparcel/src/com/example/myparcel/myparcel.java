package com.example.myparcel;

import android.os.Parcel;
import android.os.Parcelable;

public class myparcel implements Parcelable {
	data obj;
	
	public data getObject() {	
		return obj;
	}
	
	//Is used to reconstruct the object
	private myparcel(Parcel in) {
		obj = new data(in.readInt(), in.readFloat(), in.readString());
	}
	
	public myparcel(data obj) {
		this.obj = obj;
	}
	
	public int describeContents() {
		//returns the hashcode
		return (int)(obj.getInt()+obj.getFloat()+obj.hashCode()) % 10;
	}
	
	
	//Flattening happens here
	public void writeToParcel(Parcel in, int flags) {
		in.writeInt(obj.getInt());
		in.writeFloat(obj.getFloat());
		in.writeString(obj.getStr());
	}
	
	public static final Parcelable.Creator<myparcel> CREATOR = new Parcelable.Creator<myparcel>() {
		public myparcel createFromParcel(Parcel in) {
			return new myparcel(in);
		}
		
		public myparcel[] newArray(int size) {
			return new myparcel[size];
		}
	};
}
