package blatt6.interator;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<E> implements Iterator<E>
{
	
	MyList<E> list;
	MyEntry<E> elemBefore;
	MyEntry<E> currentEntry;
	
	private int modCountAtCreation;
	
	
	public MyIterator(MyList<E> list, MyEntry<E> first){
		this.list = list;
		this.currentEntry = first;
		this.elemBefore = null;
		this.modCountAtCreation = list.getModCount();
	}

	@Override
	public boolean hasNext()
	{
		if(modCountAtCreation != list.getModCount()) {
			throw new ConcurrentModificationException();
		}
		
		return currentEntry.next != null;
	}

	@Override
	public E next()
	{
		if(modCountAtCreation != list.getModCount()) {
			throw new ConcurrentModificationException();
		}
		
		if(!this.hasNext()) {
			throw new NoSuchElementException();
		}
		
		elemBefore = currentEntry;
		currentEntry = currentEntry.next;
		return elemBefore.o;
	}
	
	@Override
	public void remove() {
		if(modCountAtCreation != list.getModCount()) {
			throw new ConcurrentModificationException();
		}
		
		if(elemBefore == null) {
			list.reset();
			list.begin = currentEntry.next;
		} else {
			elemBefore.next = currentEntry.next;
		}
	}

}
