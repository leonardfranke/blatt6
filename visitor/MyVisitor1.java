package blatt6.visitor;

public class MyVisitor1<E> implements Visitor<E>
{

	@Override
	public boolean visit(E o)
	{
		System.out.println(o);
		return true;
	}

	

}
