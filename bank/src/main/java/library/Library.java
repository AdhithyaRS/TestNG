package library;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import customException.InvalidValueException;
import customException.NotAvailableException;

public class Library {
	private List<Book> books;
    private List<Patron> patrons;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    // Methods
    public void addBook(String title, String author) {
        // Implement logic to add a book to the library
    }

    public void addPatron(String name) {
        // Implement logic to add a patron to the library
    }

    public void borrowBook(int patronId, int bookId) throws InvalidValueException, NotAvailableException{
    	if(bookId<=0 || bookId>=Book.bookIdCounter) {
    		throw new InvalidValueException(111, "Invalid bookId");
    	}else if(patronId<=0 || patronId>=Patron.patronIdCounter) {
    		throw new InvalidValueException(222, "Invalid patronId");
    	}
    	Book getBook = null;
    	for (Book book : books) {
    		if (book.getBookId() == bookId) {
    			if(book.isAvailable()) {
    				getBook=book;
    			}else {
    				throw new NotAvailableException(111, "Book Not Available");
    			}
    		}
    	}
    	if(getBook==null) throw new NotAvailableException(110,"Book Not in DB");
    	Patron getPatron=null;
    	for (Patron patron : patrons) {
    		if (patron.getPatronId() == patronId) {
    			getPatron= patron;
    		}
    	}
    	if(getPatron == null) throw new NotAvailableException(222, "Patron not Available in DB");
    	getBook.setAvailable(false);
    	getBook.setDueDate(calculateDueDate());
    }
    
    private Date calculateDueDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date()); // Set the current date
        calendar.add(Calendar.DAY_OF_YEAR, 14); // Add 14 days for the due date
        return calendar.getTime();
    }
    	

    public void returnBook(int patronId, int bookId) {
        // Implement logic for a patron to return a book
    }

    public List<Book> getAvailableBooks() {
        // Implement logic to get available books
        return new ArrayList<>();
    }

    public List<Book> getPatronBorrowedBooks(int patronId) {
        // Implement logic to get books borrowed by a patron
        return new ArrayList<>();
    }

    public List<Book> getOverdueBooks() {
        // Implement logic to get overdue books
        return new ArrayList<>();
    }

    // Other methods as needed
}
