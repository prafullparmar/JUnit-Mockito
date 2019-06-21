package Generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

 abstract class weighable{
	
	public abstract int getWeight();
}

class Book extends weighable{
	int weight;
	String name;
	String author;
	
	
	public Book(String name,String author, int weight) {
		super();		
		this.name = name;
		this.author = author;
		this.weight = weight;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getWeight() {
		return this.weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + weight;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weight != other.weight)
			return false;
		return true;
	}
	
	
	
	
}


class Bag<T extends weighable> implements Comparable<Bag>{
	public ArrayList<T> bagItems;
	public int bagWeight=0;
	public Bag() {
		this.bagItems = new ArrayList<T>();
	}
	
	public int getWeight() {
		return bagWeight;
	}
	public ArrayList<?> getItems() {
		return this.bagItems;
	}

	public void setItems(ArrayList<T> items) {
		this.bagItems = items;
		Iterator it = items.iterator();
		while(it.hasNext())
		{
			this.bagWeight+=((T)it.next()).getWeight();
		}
	}
	
	public void addItem(T t) {
		this.bagItems.add(t);
		this.bagWeight += t.getWeight();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bagItems == null) ? 0 : bagItems.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bag other = (Bag) obj;
		if (bagItems == null) {
			if (other.bagItems != null)
				return false;
		} else if (!bagItems.equals(other.bagItems))
			return false;
		return true;
	}

	@Override
	public int compareTo(Bag bag) {
		Integer weight1 =(Integer)this.bagWeight;
		Integer weight2 =(Integer)bag.bagWeight;
		return weight1.compareTo(weight2);
	}
}

public class Generic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book b1 = new Book("To kill a mocking bird","Harper Lee",1);
		Book b2 = new Book("The Great Gatsby","F. Scott Fitzgerald",2);
		Book b3 = new Book("Invisible Man","Novel by Ralph Ellison",1);
		
		ArrayList<Book> item1 = new ArrayList<Book>();
		ArrayList<Book> item2 = new ArrayList<Book>();
		Bag<Book> bag1 = new Bag<Book>();
		Bag<Book> bag2 = new Bag<Book>();
		
		item1.add(b1);
		item1.add(b2);
		
		item2.add(b1);
		item2.add(b2);
	    bag1.setItems(item1);
	    bag2.setItems(item2);
	    System.out.println("Bag1 weight :"+bag1.getWeight());
	    System.out.println("Bag2 weight :"+bag2.getWeight());
		System.out.println("Bag1.equals(Bag2) :" +bag1.equals(bag2));
		System.out.println("Bag1.compareTO(Bag2) :" +bag1.compareTo(bag2));
		
		System.out.println("Adding another book to Bag1");
		
		bag1.addItem(b3);
		System.out.println("Bag1 weight :"+bag1.getWeight());
	    System.out.println("Bag2 weight :"+bag2.getWeight());
		System.out.println("Bag1.equals(Bag2) :" +bag1.equals(bag2));
		System.out.println("Bag1.compareTO(Bag2) :" +bag1.compareTo(bag2));
	}
}

