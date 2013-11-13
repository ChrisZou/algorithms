package com.chriszou.algorithms;

import com.chriszou.algorithms.stdlib.StdIn;
import com.chriszou.algorithms.stdlib.StdOut;

/**
 * 
 * Reads in a sequence of real numbers, and computes their average.
 * @author Chris
 *
 */
public class Average {
	public static void main(String[] args){
		int count = 0;
		double sum = 0.0;
		
		//Input number to calculate, input end to end input.
		while(!StdIn.isEmpty()) {
			String str = StdIn.readString();
			if(str.toLowerCase().equals("end")) {
				break;
			} else {
				double d = Double.valueOf(str);
				sum += d;
				count++;
			}
		}
		
		StdOut.println(sum/count);
	}
}
