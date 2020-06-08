package blatt6.persistence;

import java.io.File;

public class TestWrapper
{

	public static void main(String[] args)
	{
		TestWrapper test = new TestWrapper();
		test.testGeneratesFile();
		test.testGetArrayFromFileName();
		test.testChanges();
		test.testOverwritingWholeFile();

	}
	
	public void testGeneratesFile() {
		int[] arr = {1,3,5,7,3,9,3,5,2};
		Wrapper wrapper = new Wrapper(arr, "myArray.txt");
		
		File checkerFile = new File("myArray.txt");
		assert checkerFile.exists();
	}
	
	
	public void testGetArrayFromFileName() {		//Legt eine Datei an die das Array enthaelt. Anschliessend wir getestet ob ein neuer Wrapper die vorhandene Datei richtig ausliest
		int[] arr = {3,6,9,2,4,6,8};
		Wrapper wrapper = new Wrapper(arr, "myArray2.txt");
		
		Wrapper wrapperTester = new Wrapper("myArray2.txt");		
		for(int i = 0; i < wrapperTester.size(); i++) {
			assert wrapperTester.get(i) == arr[i];
		}		
	}
	
	public void testChanges() {									//Legt zuerst eine Datei an, die das Array enthaelt.
		int[] arr = {1,3,5,7,3,9,3,5,2};						//Dann wird der Wrapper bearbeiten und anschliessend ueberprueft ob die Veraenderung auch in der Datei gemacht wurden
		Wrapper wrapper = new Wrapper(arr, "myArray3.txt");
		
		for(int i = 0; i < arr.length; i++) {
			wrapper.set(i, i*2);
		}		
		
		Wrapper wrapperTester = new Wrapper("myArray3.txt");		
		for(int i = 0; i < wrapperTester.size(); i++) {
			assert wrapperTester.get(i) == i*2;
		}	
	}
	
	public void testOverwritingWholeFile() {						//Legt zuerst eine Datei an, mit einem (alten) Array
		int[] arrAlt = {3,6,9,2,4,6,8};								//ueberschreibt dann die Datei mit einem komplett anderen Array und prueft ob die Werte in der Datei und die groesse des Arrays stimmen
		Wrapper wrapper1 = new Wrapper(arrAlt, "myArray4.txt");
		
		int[] arrNeu = {1,2,3,4};
		Wrapper wrapper2 = new Wrapper(arrNeu, "myArray4.txt");
		
		Wrapper wrapperTester = new Wrapper("myArray4.txt");		
		for(int i = 0; i < wrapperTester.size(); i++) {
			assert wrapperTester.get(i) == i+1;
		}
		assert wrapperTester.size() == arrNeu.length;
	}

}
