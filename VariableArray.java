/**
 * Helper class to make arrays easier to work with
 * @author Owen Edmundson
 */
public class VariableArray {
	private int len;
	private int[] values;
	
	/**
	 * Creates the array
	 * @param maxLen the max length that the array can be
	 */
	public VariableArray(int maxLen) {
		this.len = 0;
		this.values = new int[maxLen];
	}
	
	/**
	 * Gets the current length of the array
	 * @return the length of the array
	 */
	public int len() {
		return len;
	}
	
	/**
	 * Gets the value at a location in the array
	 * @param loc the location in the array to get
	 * @return The value at that location
	 */
	public int get(int loc) {
		return values[loc];
	}
	
	/**
	 * Adds a value onto the end of the array
	 * @param value the value to add
	 */
	public void append(int value) {
		values[len] = value;
		len += 1;
	}
	
	/**
	 * Removes a value from the array
	 * @param value the value to be removed
	 */
	public void del(int value) {
	    int count = 0;
	    for (int i = 0; i < len; i++) {
	        if (values[i] == value) {
	        	count++;
	        } else {
	            values[i - count] = values[i];
	        }
	    }
	    len -= count;
	    for (int i = 0; i < count; i++) {
	        values[len + i] = 0;
	    }
	}
	
	/**
	 * Checks if a value is in an array
	 * @param value the value to find
	 * @return True if the value is in the array, false otherwise
	 */
	public boolean in(int value) {
	    for (int i = 0; i < len; i++) {
	        if (values[i] == value) {
	        	return true;
	        }
	    }
	    return false;
	}
}