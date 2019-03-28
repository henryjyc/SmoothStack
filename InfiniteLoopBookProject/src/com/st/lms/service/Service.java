package com.st.lms.service;

import com.st.lms.model.*;
import com.st.lms.dao.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {
	private static DAOBookImpl bookdao = new DAOBookImpl();
	private static DAOAuthorImpl authordao = new DAOAuthorImpl();
	private static DAOPublisherImpl publisherdao = new DAOPublisherImpl();
	
	//cmds to manipulate book table
	public static void printBooks() {
		List<Book> books = new ArrayList<Book>();
		DAOBookImpl bd = new DAOBookImpl();
		try {
			books = bd.loadBooks();
			for(Book book : books) {
				System.out.println("Book ID:" + book.getID() + ", Book Title:" + book.getName());
			}
		} catch(IOException e) {
			System.out.println("ERROR: UNABLE TO PRINT BOOK ITEMS FROM TABLE.");
		}
		
	}
	
	public static String addBook(int bookID, String bookTitle, int authorID, int publisherID) {
		//this method adds a book with the given params into the book database
		//returns empty String if the book's author and publisher already exist in the database
		//returns a String containing "a" if the book's author does not exist in the author database
		//returns a String containing "p" if the book's author does not exist in the publisher database
		//if it returns "ap" then both the author and publisher are not in database
		String result = "";
		Book book = new Book(bookTitle, bookID, authorID, publisherID);
		try {
			bookdao.addBook(book);
		}catch(IOException e) {
			System.out.println("ERROR: WAS UNABLE TO ADD BOOK INTO TABLE.");
		}
		try {
			if(!authordao.hasAuthor(authorID))
				result += "a";
			if(!publisherdao.hasPublisher(publisherID))
				result += "p";
		}catch(IOException e) {
			System.out.println("ERROR: UNABLE TO CHECK AUTHOR OR PUBLISHER TABLE!");
		}
		return result;
	}
	
	public static void removeBook(int bookID) {
		try {
			bookdao.delete(bookID);
		}catch(IOException e) {
			System.out.println("ERROR: UNABLE TO REMOVE BOOK FROM RECORDS!");
		}
	}
	
	public static Book getBook(int bookID) { //returns null if no matching records are found
		Book book = null;
		try {
			book = bookdao.getBook(bookID);
		}catch(IOException e){
			System.out.println("ERROR: UNABLE TO RETRIEVE BOOK FROM RECORDS!");
		}
		return book;
	}
	
	//cmds to manipulate publisher table
	public static void printPublishers() {
		List<Publisher> publishers = new ArrayList<Publisher>();
		try {
			publishers = publisherdao.loadPublishers();
			for(Publisher publisher : publishers) {
				System.out.println("Publisher ID:" + publisher.getID() + ", Publisher's name:" + publisher.getName());
			}
		} catch(IOException e) {
			System.out.println("ERROR: UNABLE TO PRINT CONTENTS FROM TABLE.");
		}
	}
	
	public static void addPublisher(int publisherID, String publisherName, String publisherAddr, long publisherPhone) {
		try {
			publisherdao.addPublisher(new Publisher(publisherName, publisherID, publisherAddr, publisherPhone));
		}catch(IOException e) {
			System.out.println("ERROR: UNABLE TO ADD PUBLISHER TO PUBLISHER TABLE!");
		}
	}
	
	public static void removePublisher(int publisherID) { //also removes all books under this publisher
		try {
			publisherdao.delete(publisherID);
			bookdao.removePublisher(publisherID);
		}catch(IOException e) {
			System.out.println("ERROR: UNABLE TO REMOVE PUBLISHER FROM RECORDS!");
		}
	}
	
	public static Publisher getPublisher(int publisherID) { //returns null if no matching records are found
		Publisher publisher = null;
		try {
			publisher = publisherdao.getPublisher(publisherID);
		}catch(IOException e){
			System.out.println("ERROR: UNABLE TO RETRIEVE BOOK FROM RECORDS!");
		}
		return publisher;
	}
	
	//cmds to manipulate author table
	public static void printAuthors() {
		List<Author> authors = new ArrayList<Author>();
		try {
			authors = authordao.loadAuthors();
			for(Author author : authors) {
				System.out.println("Author ID:" + author.getID() + ", Author's name:" + author.getName());
			}
		} catch(IOException e) {
			System.out.println("ERROR: UNABLE TO PRINT CONTENTS FROM TABLE.");
		}
	}
	
	public static void addAuthor(int authorID, String authorName) {
		try {
			authordao.addAuthor(new Author(authorName, authorID));
		}catch(IOException e) {
			System.out.println("ERROR: UNABLE TO ADD AUTHOR TO AUTHOR TABLE!");
		}
	}
	
	public static void removeAuthor(int authorID) { //also removes all books under this author
		try {
			authordao.delete(authorID);
			bookdao.removeAuthor(authorID);
		}catch(IOException e) {
			System.out.println("ERROR: UNABLE TO REMOVE AUTHOR FROM RECORDS!");
		}
	}
	
	public static Author getAuthor(int authorID) { //returns null if no matching records are found
		Author author = null;
		try {
			author = authordao.getAuthor(authorID);
		}catch(IOException e){
			System.out.println("ERROR: UNABLE TO RETRIEVE BOOK FROM RECORDS!");
		}
		return author;
	}
	
	
	
}