package blatt6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PerformanceTest
{

	private Collection<Integer> arrayList = new ArrayList<>();
	private Collection<Integer> linkedList = new LinkedList<>();
	private Collection<Integer> hashSet = new HashSet<>();
	private Collection[] subjects = new Collection[3];


	Random random = new Random();
	final int testSize = 10000;

	public static void main(String[] args)
	{
		PerformanceTest test = new PerformanceTest();
		test.before();
		for(Collection c : test.subjects) {
			test.testAdd(c);
			test.testContains(c);
			test.testRemove(c);
			System.out.println();
		}


	}

	public void before () {
		subjects[0] = arrayList;
		subjects[1] = linkedList;
		subjects[2] = hashSet;
	}

	public void testAdd(Collection<Integer> collection) {
		collection.removeAll(collection);
		long startTime = System.nanoTime();
		for(int i = 0; i < testSize; i++) {
			collection.add(random.nextInt(testSize));
		}
		long endTime = System.nanoTime();

		System.out.println(collection.getClass().getSimpleName() + " took on average " + (endTime - startTime)/testSize + " nanoseconds for each element to add");
	}

	public void testContains(Collection<Integer> collection) {
		collection.removeAll(collection);
		for(int i = 0; i < testSize; i++) {
			collection.add(random.nextInt(testSize));
		}

		long startTime = System.nanoTime();
		for(int j = 0; j < testSize; j++) {
			collection.contains(j);
		}
		long endTime = System.nanoTime();

		System.out.println(collection.getClass().getSimpleName() + " took on average " + (endTime - startTime)/testSize + " nanoseconds for each element to check");
	}

	public void testRemove(Collection<Integer> collection) {
		collection.removeAll(collection);
		for(int i = 0; i < testSize; i++) {
			collection.add(random.nextInt(testSize));
		}

		long startTime = System.nanoTime();
		for(int i = 0; i < testSize; i++) {
			collection.contains(random.nextInt(testSize));
		}
		long endTime = System.nanoTime();

		System.out.println(collection.getClass().getSimpleName() + " took on average " + (endTime - startTime)/testSize + " nanoseconds for each element to remove");
	}

}

