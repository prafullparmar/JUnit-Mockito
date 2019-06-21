package Generics;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class testGenerics{
	Book b1 ;
	Book b2 ;
	Book b3 ;
	
	ArrayList<Book> item1 = new ArrayList<Book>();
	ArrayList<Book> item2 = new ArrayList<Book>();
	Bag<Book> bag1 ;
	Bag<Book> bag2;
@Before
public void beforemethod()
{
	 b1 = new Book("To kill a mocking bird","Harper Lee",1);
	 b2 = new Book("The Great Gatsby","F. Scott Fitzgerald",2);
	 b3 = new Book("Invisible Man","Novel by Ralph Ellison",1);
	 bag1 = new Bag<Book>();
	 bag2 = new Bag<Book>();
	   item1.add(b1);
		item1.add(b2);
		
		item2.add(b1);
		item2.add(b2);
	    bag1.setItems(item1);
	    bag2.setItems(item2);
	    System.out.println("Called before Test Case");
	
}

@Test
public void checkWeights()
{
   assertEquals( 3,  bag1.getWeight());
     assertEquals(3,bag2.getWeight());
}
@Test
public void checkBags()
{
	assertEquals(true,bag1.equals(bag2));
	bag2.addItem(b3);
	assertEquals(false,bag1.equals(bag2));
}
@After
public void aftermethod()
{
	System.out.println("Called after Test Case");
}
 }

