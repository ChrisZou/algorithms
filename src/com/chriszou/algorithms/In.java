package com.chriszou.algorithms;

import static com.chriszou.algorithms.Print.println;

import java.io.BufferedReader;
import java.io.FileReader;

public class In {
	private String mFilePath;

	public In(String file) {
		mFilePath = file;
	}

	/**
	 * @return
	 */
	public int[] readAllInts() {
		int[] results = null;
		try {
			FileReader fileReader = new FileReader(mFilePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			String line = bufferedReader.readLine();
			while (line != null) {
				list.add(Integer.parseInt(line));
				line = bufferedReader.readLine();
			}
			results = new int[list.size()];
			int i = 0;
			for(Integer integer:list) {
				results[i++] = integer;
			}
			
			bufferedReader.close();
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return results;
	}
}
