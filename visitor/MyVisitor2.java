package blatt6.visitor;

public class MyVisitor2<E extends String> implements Visitor<E>
{
	private boolean found = true;
	private int foundAt = 0;
	
	@Override
	public boolean visit(E o)
	{		
		foundAt++;
		if(o.equals("Ende")){
			System.out.println("Element gefunden bei Position " + foundAt);
			found = false;
		}
		// TODO Auto-generated method stub
		return found;
	}

	

}
