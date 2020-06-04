package blatt6.interator;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class TestIterator
{

	public static void main(String[] args)
	{
		TestIterator test = new TestIterator();
		test.testIteration();
		test.testRemove();
		test.testExceptions();
	}
	
	public void testIteration() {
		MyList<Integer> list = new MyList<Integer>();		
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(7);
		
		MyIterator<Integer> iterator = (MyIterator<Integer>) list.iterator();
		
		int count = 0;
		while(iterator.hasNext()) {
			count++;
			iterator.next();
		}		
		assertInt(count, 4,"The iterator is not at the end in testIteration");
	}
	
	public void testRemove() {
		MyList<Integer> list = new MyList<Integer>();		
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(7);
		list.add(1);
		list.add(9);
		
		MyIterator<Integer> iterator = (MyIterator<Integer>) list.iterator();
		
		iterator.next();
		iterator.remove();
		iterator.next();
		iterator.remove();
		iterator.next();
		iterator.remove();
		
		int count = 0;
		list.reset();
		while(!list.endpos()) {
			list.advance();
			count++;
		}
		assertInt(count,3,"deletion of elements using iterator doesnt return the correct number of remaining elements");
	}
	
	
	public void testExceptions() {
		MyList<Integer> list = new MyList<Integer>();	
		MyIterator<Integer> iterator = (MyIterator<Integer>) list.iterator();
		int i = 0;

		try {
			iterator.remove();
		} catch (IllegalStateException e) {
			i = 1;
		}
		assertInt(i,1,"The Illegal State exception when calling remove without using next is not thrown.");

		i = 0;
		list.add(5);
		try {
			iterator.next();
		} catch (ConcurrentModificationException c) {
			i = 1;
		}
		assertInt(i,1,"The Concurrent Modification exception when calling next on a modified list is not thrown");

		i = 0;
		iterator = (MyIterator<Integer>) list.iterator();
		try {
			iterator.next();
			iterator.next();
		} catch (NoSuchElementException n){
			i = 1;
		}
		assertInt(i,1,"The no such elem Exception  when calling next while there is no next is not thrown");
		
		
	}

	public void assertInt(int actual, int expected, String errMsg) {
		if(actual != expected) {
			System.out.println(errMsg);
		}
	}

}
