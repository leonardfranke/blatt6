package blatt6;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestComplexity
{

	Collection<Integer> collection;
	
	Random random = new Random();	
	final int testSize = 1000000;
	
	public static void main(String[] args)
	{
		TestComplexity testLinkedList = new TestComplexity(new LinkedList<Integer>());
		testLinkedList.testAdd();
		testLinkedList.testContains();
		testLinkedList.testRemove();

	}
	
	public TestComplexity(Collection<Integer> collection) {
		this.collection = collection;
				
	}
	
	public void testAdd() {
		this.collection.removeAll(collection);
		long startTime = System.nanoTime();
		for(int i = 0; i < testSize; i++) {
			this.collection.add(random.nextInt(testSize));
		}
		long endTime = System.nanoTime();
		
		System.out.println("Collection took on average " + (endTime - startTime)/testSize + " nanoseconds for each element to add");
	}
	
	public void testContains() {
		this.collection.removeAll(collection);
		for(int i = 0; i < testSize; i++) {
			this.collection.add(random.nextInt(testSize));
		}		
		
		long startTime = System.nanoTime();
		for(int j = 0; j < 1000; j++) {
			this.collection.contains(j);
		}
		long endTime = System.nanoTime();
		
		System.out.println("Collection took on average " + (endTime - startTime)/testSize + " nanoseconds for each element to check");
	}
	
	public void testRemove() {
		this.collection.removeAll(collection);
		for(int i = 0; i < testSize; i++) {
			this.collection.add(random.nextInt(testSize));
		}
		
		long startTime = System.nanoTime();
		for(int i = 0; i < testSize; i++) {
			collection.contains(random.nextInt(testSize));
		}
		long endTime = System.nanoTime();
		
		System.out.println("Collection took on average " + (endTime - startTime)/testSize + " nanoseconds for each element to remove");
	}

}
