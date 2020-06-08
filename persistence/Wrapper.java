package blatt6.persistence;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Wrapper
{
	int[] numbers;
	String fileName;
	RandomAccessFile file;
	
	public Wrapper(int[] array, String fileName) {
		this.file = getFileFromFileName(fileName);
		this.fileName = fileName;
		this.numbers = array;
		writeArrayIntoFile();
	}
	
	public Wrapper(String fileName) {
		this.file = getFileFromFileName(fileName);
		this.fileName = fileName;
		this.numbers = getArrayFromFile(this.file);
	}	
	
	private RandomAccessFile getFileFromFileName(String fileName) {
		RandomAccessFile f = null;
		try {
			f = new RandomAccessFile(fileName,"rw");
			return f;
		} catch (FileNotFoundException e) {
			System.err.println("File not found!");
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	public int get(int pos) {
		return this.numbers[pos];
	}
	
	public int size() {
		return this.numbers.length;
	}
	
	public void set(int pos, int val) {
		this.numbers[pos] = val;
		try {
			this.file.seek(pos*4);
			this.file.writeInt(val);
		} catch (IOException e) {
			System.err.println("Error while overwriting new value in file!");
			e.printStackTrace();
		}
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
		try {
			this.file.setLength(0);
			this.file.seek(0);
			for(int i = 0; i < this.numbers.length; i++) {
				this.file.writeInt(this.numbers[i]);
			}			
		} catch (IOException e) {
			System.err.println("Error while overwriting the new array");
			e.printStackTrace();
		}		
	}
	
	private int[] getArrayFromFile(RandomAccessFile file) {
		int[] arr = null;
		try {
			arr = new int[(int) (file.length()/4)];
			for(int i = 0; i < file.length()/4 ; i++) {
				file.seek((i*4));
				arr[i] = file.readInt();				
			}
		} catch(IOException e) {
			System.err.println("Error while reading the file!");
			e.printStackTrace();
		}
		return arr;
	}
	
	
}
