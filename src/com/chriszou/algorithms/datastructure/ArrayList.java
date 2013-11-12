package com.chriszou.algorithms.datastructure;

import java.util.Iterator;

import javax.naming.OperationNotSupportedException;

public class ArrayList<E> implements Iterable<E> {

	/**
	 * Default container size
	 */
	private static final int DEFAULT_SIZE = 20;
	private E[] mElemments;
	
	/**
	 * Element count;
	 */
	private int mSize;
	
	public ArrayList() {
		mElemments = (E[]) new Object[DEFAULT_SIZE];
		mSize = 0;
	}
	
	public int size() {
		return mSize;
	}
	
	public void add(E e) {
		mElemments[mSize++] = e;
		checkScale();
	}
	
	/**
	 * Check if current element count has reach the container size, if so, enlarge the container
	 */
	private void checkScale() {
		if(mSize>=mElemments.length) {
			int newSize = mElemments.length*2;
			@SuppressWarnings("unchecked")
			E[] newArray = (E[]) new Object[newSize];
			for(int i=0; i<mSize; i++) {
				newArray[i]= mElemments[i]; 
			}
			
			mElemments = newArray;
		}
	}
	
	/**
	 * Add an element at the given position
	 * @param location
	 * @param e
	 */
	public void add(int location, E e){
		if(location<0) {
			throw new IndexOutOfBoundsException("Found index: "+location);
		}
		
		for(int i=mSize-1; i>=location; i--) {
			mElemments[i+1] = mElemments[i];
		}
		mSize++;
		
		checkScale();
	}
	
	/**
	 * Remove element at the given position
	 * @param index
	 */
	public void remove(int index) {
		if(index<0||index>mSize) {
			throw new IndexOutOfBoundsException("Found index: "+index+", size: "+mSize);
		}
		
		for(int i=index+1; i<mSize; i++) {
			mElemments[i-1] = mElemments[i];
		}
		mSize--;
		mElemments[mSize] = null;
		
		checkShrink();
	}
	
	/**
	 * If the current size is less than container/4 and containner is less than {@link DEFAULT_SIZE}, shrink to save space.
	 */
	private void checkShrink() {
		if(mSize<mElemments.length/4&&mElemments.length>DEFAULT_SIZE) {
			@SuppressWarnings("unchecked")
			E[] newArray = (E[])new Object[mElemments.length/2];
			for(int i=0; i<mSize; i++) {
				newArray[i] = mElemments[i]; 
			}
			
			mElemments = newArray;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {

			private int index = 0;
			private final int size = mSize;
			@Override
			public boolean hasNext() {
				return index<size;
			}

			@Override
			public E next() {
				return mElemments[index++];
			}

			@Override
			public void remove() {
				throw new RuntimeException("Operation not supported");
			}
		};
	}
}
