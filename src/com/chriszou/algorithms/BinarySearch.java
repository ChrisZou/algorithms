package com.chriszou.algorithms;

import static com.chriszou.algorithms.utils.Print.println;
import java.util.Arrays;
import com.chriszou.algorithms.stdlib.In;
import com.chriszou.algorithms.stdlib.StdIn;
import com.chriszou.algorithms.stdlib.StdOut;

/**
 * A Binary Search Java implementation with reference to Algs4
 * 
 * @author Chris
 * 
 */
public class BinarySearch {
	/**
	 * This class should not be initiated
	 */
	private BinarySearch() {
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		int[] whitelist = in.readAllInts();
		Arrays.sort(whitelist);
		for (int i : whitelist) {
			println(i);
		}

		while (!StdIn.isEmpty()) {
			int key = StdIn.readInt();
			if (rank(key, whitelist) == -1) {
				StdOut.println("not found: " + key);
			} else {
				StdOut.println("found " + key);
			}
		}
	}

	public static int rank(int key, int[] data) {
		if (data.length == 0) {
			return -1;
		}

		int start = 0;
		int end = data.length - 1; //Be careful: the starting point of end should be data.lenth-1 rather than data.length
		while (start <= end) {
			int mid = (start + end) / 2;
			if (data[mid] == key) {
				return mid;
			} else if (key > data[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}
}
