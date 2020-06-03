package blatt6.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Wrapper
{
	int[] array;
	String fileName;
	RandomAccessFile file;
	
	public Wrapper(int[] array, String fileName) {
		this.file = getFileFromFileName(fileName);
		this.fileName = fileName;
		this.array = array;
		writeArrayIntoFile();
	}
	
	public Wrapper(String fileName) {
		this.file = getFileFromFileName(fileName);
		this.fileName = fileName;
		this.array = getArrayFromFile(this.file);
	}	
	
	private RandomAccessFile getFileFromFileName(String fileName) {
		try {
			return new RandomAccessFile(fileName,"rw");
		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public int get(int pos) {
		return this.array[pos];
	}
	
	public int size() {
		return this.array.length;
	}
	
	public void set(int pos, int val) {
		this.array[pos] = val;
				
	}
	
	public void closeFile() {
		try {
			this.file.close();
		} catch (IOException e) {
			System.err.println("Could not close the file!");
			e.printStackTrace();
		}
	}
	
	private void writeArrayIntoFile() {
		this.file.
	}
	
	
}
