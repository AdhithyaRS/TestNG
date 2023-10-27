package library;

import java.util.Date;

public class Book {
	public static int bookIdCounter=1;
	private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;
    private Date dueDate;


    public Book( String title, String author) {
        this.bookId = bookIdCounter++;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
        this.dueDate = null;
    }
    
    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public boolean isAvailable() {
		return isAvailable;
	}


	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
    
}
