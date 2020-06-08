package blatt6.visitor;

public class TestVisitor
{

	public static void main(String[] args)
	{
		TestVisitor test = new TestVisitor();
		test.testVisitor1();
		test.testVisitor2();
	}

	
	public void testVisitor1() {					//erster Visitor durchlaeuft alle Elemente und sollte somit alle 4 Elemente in der Konsole ausgeben
		MyVisitor1<Integer> visitor1 = new MyVisitor1<Integer>();
		MyList<Integer> list = new MyList<Integer>();
		list.add(3);		
		list.add(5);		
		list.add(2);
		list.add(7);
		list.accept(visitor1);
	}
	
	public void testVisitor2() {				//zweiter Visitor durchlaeuft das Array bis er den String "Ende" gefunden hat und gibt dann aus ob es gefunden wurde
		MyVisitor2<String> visitor2 = new MyVisitor2<String>();
		MyList<String> list = new MyList<String>();
		list.add("Du");
		list.advance();
		list.add("bist");
		list.advance();		
		list.add("am");
		list.advance();
		list.add("Ende");
		list.advance();	
		list.add("angekommen");	
		list.accept(visitor2);
	}
}
