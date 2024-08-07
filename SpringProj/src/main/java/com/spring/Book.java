package com.spring;

public class Book {
	private int bookId;
	private String bookName;

	// Constructor injection
	public Book(int bookId, String bookName) {
		this.bookId = bookId;
		this.bookName = bookName;
	}

	public Book() {

	}

//	public String toString() {
//		return bookId + " " + bookName;
//	}
}