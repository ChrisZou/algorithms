package com.chriszou.algorithms;

import com.chriszou.algorithms.stdlib.StdRandom;
import static com.chriszou.algorithms.utils.Print.*;
/**
 * A random seq implementation with reference to Algs4
 * @author Chris
 *
 */
public class RandomSeq {
	private RandomSeq() {}
	
	public static void main(String[] args){
		
		int count = Integer.parseInt(args[0]);
		double low = Double.valueOf(args[1]);
		double high = Double.valueOf(args[2]);
		
		for(int i=0; i<count; i++) {
			double d = StdRandom.uniform(low, high);
			println(d);
		}
	}
}
