package codespaghetti.com;

import java.util.Arrays;

public class CustomArrayList {
	private Object[] arrayPlaceHolder;
	private int actSize = 0;

	public CustomArrayList() {
		arrayPlaceHolder = new Object[10];
	}

	public Object get(int index) {
		if (index < actSize) {
			return arrayPlaceHolder[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	public void add(Object obj) {
		if (arrayPlaceHolder.length - actSize <= 5) {
			increaseListSize();
		}
		arrayPlaceHolder[actSize++] = obj;
	}

	public Object remove(int index) {
		if (index < actSize) {
			Object obj = arrayPlaceHolder[index];
			arrayPlaceHolder[index] = null;
			int tmp = index;
			while (tmp < actSize) {
				arrayPlaceHolder[tmp] = arrayPlaceHolder[tmp + 1];
				arrayPlaceHolder[tmp + 1] = null;
				tmp++;
			}
			actSize--;
			return obj;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}

	}

	public int size() {
		return actSize;
	}

	private void increaseListSize() {
		arrayPlaceHolder = Arrays.copyOf(arrayPlaceHolder, arrayPlaceHolder.length * 2);
		System.out.println("\nNew length: " + arrayPlaceHolder.length);
	}
}
