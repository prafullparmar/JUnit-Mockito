import java.util.List;

public class Student {
   private BookService bookService;
   private List<Book> books;
   
   public BookService getBookService() {
	return bookService;
}


public void setBookService(BookService bookService) {
	this.bookService = bookService;
}


public List<Book> getBooks() {
	return books;
}


public void setBooks(List<Book> books) {
	this.books = books;
}

   
   public int getBooksPrice(List<Book> books){
      int booksPrice = 0;
      
      for(Book book:books){
         booksPrice += bookService.getPrice(book);
      }
      return booksPrice;
   }
}