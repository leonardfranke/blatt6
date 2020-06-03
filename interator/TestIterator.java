package blatt6.interator;

public class TestIterator
{

	public static void main(String[] args)
	{
		TestIterator test = new TestIterator();
		test.testDurchlauf();
		test.testRemove();
		test.testException();
	}
	
	public void testDurchlauf() {
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
		assert count == 4;		
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
		
		iterator.remove();
		iterator.remove();
		iterator.remove();
		iterator.remove();
		
		int count = 0;
		while(iterator.hasNext()) {
			count++;
			iterator.next();
		}		
		assert count == 2;	
		
		
	
	}
	
	
	public void testException() {
		MyList<Integer> list = new MyList<Integer>();	
		MyIterator<Integer> iterator = (MyIterator<Integer>) list.iterator();
		list.add(3);
		//iterator.next();
		
		list.add(5);
		iterator = (MyIterator<Integer>) list.iterator();
		list.delete();
		//iterator.hasNext();
		
		iterator = (MyIterator<Integer>) list.iterator();
		list.add(2);
		//iterator.remove();
		
		
	}

}
