package kang.set;

public class IntegerSet {

	boolean[] arr = new boolean[101];	
	
	public IntegerSet() {
		for (int i = 0; i < arr.length; i++) {
		    arr[i] = false;
		}
	}
	
	public void insertElement(int k) {
		arr[k] = true;
	}
	
	public void deleteElement(int m) {
		arr[m] = false;
	}	
}
