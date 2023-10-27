package library;

import java.util.ArrayList;
import java.util.List;

public class Patron {
	public static int patronIdCounter=1;
	private int patronId;
    private String name;
    private List<Book> borrowedBooks;

    // Constructor
    public Patron(String name) {
        this.patronId = patronIdCounter++;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

	public int getPatronId() {
		return patronId;
	}

	public void setPatronId(int patronId) {
		this.patronId = patronId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}

	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
    
}
