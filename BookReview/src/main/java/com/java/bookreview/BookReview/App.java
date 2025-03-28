package com.java.bookreview.BookReview;

import java.awt.print.Printable;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.java.bookreview.dao.BookDAO;
import com.java.bookreview.dao.ReviewDAO;
import com.java.bookreview.entities.Book;
import com.java.bookreview.entities.Review;
import com.java.bookreview.util.*;
public class App 
{
   
	private static BookDAO bookDAO = new BookDAO();
	private static ReviewDAO reviewDAO = new ReviewDAO();
    private static Scanner scanner = new Scanner(System.in);

    	    public static void main(String[] args) {
    	    	while(true) 
    	    	{
    	    		System.out.println("Book Review System");
    	    		System.out.println("1. Book");
    	    		System.out.println("2. Review");
    	    		System.out.println("3. Exit ");
    	    		
    	    		int choice = scanner.nextInt();
    	    		//scanner.nextLine();
    	    		switch (choice)
    	    		{
    	    		
    	    			case 1:
    	    				BookOp();
    	    				break;
    	    			case 2 :
    	    				ReviewOp();
    	    				break;
    	    			case 3 :
    	    				System.out.println("Exiting... Goodbye!");
    	                    System.exit(0);
    	    			 default:
    	                    System.out.println("Invalid choice, try again.");
    	                    
    	    				
    	    		}
    	    		

    	    		
    	    	}
    	    	
    	    	
 
    	        }
    	   





			private static void BookOp() 
			{
				
				while(true) {
				System.out.println("1. Add a Book");
	            System.out.println("2. View All Books");
 	            System.out.println("3. Update a Book");
 	            System.out.println("4. Delete a Book");
 	            System.out.println("5.Back to Previous Menu");
 	            
 	            
 	            
 	           int choice = scanner.nextInt();
	            scanner.nextLine(); 

	            switch (choice) {
	                case 1:
	                	addBook();
	                    break;
	                case 2:
	                    viewAllBooks();
	                    break;
	                case 3:
	                    updateBook();
	                    break;
	                case 4:
	                    deleteBook();
	                    break;
	                case 5:
	                	break;
	                default:
	                	 System.out.println("Invalid choice, try again.");
	                	 
	                	 
	            }
	            if(choice==5) {
	            	break;
	            }
			}
	                	
 	            
				
			}

			
			
			
			private static void ReviewOp() 
			{
				while(true) {
					
					
					
					  System.out.println("1. Add a Review");
	    	            System.out.println("2. View Reviews for a Book");
	    	            System.out.println("3. Delete a Review");
	    	            System.out.println("4. Back to Previous Menu");
	    	            System.out.print("Enter choice: ");
	    	            
	    	            int choice = scanner.nextInt();
	    	            scanner.nextLine(); 

	    	            switch (choice) {
	    	               
	    	                case 1:
	    	                    addReview();
	    	                    break;
	    	                case 2:
	    	                    viewReviews();
	    	                    break;
	    	                case 3:
	    	                    deleteReview();
	    	                    break;
	    	                case 4:
	    	                    break;
	    	                default:
	    	                    System.out.println("Invalid choice, try again.");
	    	            }
	    	            if(choice==4) {
	    	            	break;
	    	            }
				
					
					
					
					
					
					
				}
				
			}
    	    private static void addBook() {
    	        System.out.print("Enter book title: ");
    	        String title = scanner.nextLine();
    	        System.out.print("Enter author name: ");
    	        String author = scanner.nextLine();
    	        System.out.print("Enter Published Year");
    	        int publishedyear = scanner.nextInt();
    	        bookDAO.addBook(title, author,publishedyear);
    	    }

    	    private static void viewAllBooks() {
    	        List<Book> books = bookDAO.getAllBooks();
    	        if (books.isEmpty()) {
    	            System.out.println("No books found.");
    	        } else {
    	            for (Book book : books) {
    	                System.out.println(book.getId() + ": " + book.getTitle() + " by " + book.getAuthor()+" Published On "+book.getPublishedyear());
    	            }
    	        }
    	    }

    	    private static void updateBook() {
    	        System.out.print("Enter book ID to update: ");
    	        int id = scanner.nextInt();
    	        scanner.nextLine();
    	        System.out.print("Enter new title: ");
    	        String newTitle = scanner.nextLine();
    	        System.out.print("Enter new author: ");
    	        String newAuthor = scanner.nextLine();
    	        System.out.print("Enter new Published Year");
    	        int publishedyear = scanner.nextInt();
    	        bookDAO.updateBook(id, newTitle, newAuthor,publishedyear);
    	    }

    	    private static void deleteBook() {
    	        System.out.print("Enter book ID to delete: ");
    	        int id = scanner.nextInt();
    	        bookDAO.deleteBook(id);
    	    }

    	    private static void addReview() {
    	        System.out.print("Enter book ID for the review: ");
    	        int bookId = scanner.nextInt();
    	        scanner.nextLine();
    	        System.out.print("Enter reviewer name: ");
    	        String reviewer = scanner.nextLine();
    	        System.out.print("Enter rating (1-5): ");
    	        int rating = scanner.nextInt();
    	        scanner.nextLine();
    	        System.out.print("Enter review comment: ");
    	        String comment = scanner.nextLine();
    	        reviewDAO.addReview(bookId, reviewer, rating, comment);
    	    }

    	    private static void viewReviews() {
    	        System.out.print("Enter book ID to view reviews: ");
    	        int bookId = scanner.nextInt();
    	        List<Review> reviews = reviewDAO.getReviewsByBook(bookId);
    	        if (reviews.isEmpty()) {
    	            System.out.println("No reviews found.");
    	        } else {
    	            for (Review review : reviews) {
    	                System.out.println(review.getId() + ": " + review.getReviewer() + " rated " + review.getRating() + " - " + review.getComment());
    	            }
    	        }
    	    }

    	    private static void deleteReview() {
    	        System.out.print("Enter review ID to delete: ");
    	        int reviewId = scanner.nextInt();
    	        reviewDAO.deleteReview(reviewId);
    	    }
}
