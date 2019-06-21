import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class Tester {
	
   Student student;	
   BookService bookService;
	   
   
   public static void main(String[] args){
      Tester tester = new Tester();
      tester.setUp();
      System.out.println(tester.testBookPrice()?"pass":"fail");
   }
   
   public void setUp(){
      //Create a student object which is to be tested		
      student = new Student();		
  
      //Create the mock object of book service
      bookService = mock(BookService.class);		
  
      //set the bookService to the student
      student.setBookService(bookService);
   }
   
   public boolean testBookPrice(){
    	   
      //Creates a list of books to be added(issued) to student
      List<Book> books = new ArrayList<Book>();
      Book b1 = new Book("To kill a mocking bird","Harper Lee",1);
	  Book b2 = new Book("The Great Gatsby","F. Scott Fitzgerald",2);
	  Book b3 = new Book("Invisible Man","Novel by Ralph Ellison",1);
 
      books.add(b1);
      books.add(b2);
      books.add(b3);

      //add  books to the student
      student.setBooks(books);

      //mock the behavior of book service to return the value of various books
      when(bookService.getPrice(b1)).thenReturn(350);
      when(bookService.getPrice(b2)).thenReturn(100);
      when(bookService.getPrice(b3)).thenReturn(250);		

                   
      int booksPrice = student.getBooksPrice(books);		
      return booksPrice == 700;
   }
}