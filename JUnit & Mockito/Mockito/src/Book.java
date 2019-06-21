
public class Book {
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
	
}