package blatt6.visitor;

public class MyVisitor2<E extends String> implements Visitor<E>
{
	private boolean found = false;
	
	@Override
	public boolean visit(E o)
	{
		if(o.equals("Ende"));{
			System.out.println("Element gefunden");
			found = true;
		}
		// TODO Auto-generated method stub
		return found;
	}

	

}
