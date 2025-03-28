package com.java.bookreview.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.bookreview.entities.Book;
import com.java.bookreview.entities.Review;
import com.java.bookreview.util.HibernateUtil;

public class ReviewDAO {

	 public void addReview(int bookId, String reviewer, int rating, String comment) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = session.beginTransaction();

	        Book book = session.get(Book.class, bookId);
	        if (book != null) {
	            Review review = new Review();
	            review.setBook(book);
	            review.setReviewer(reviewer);
	            review.setRating(rating);
	            review.setComment(comment);

	            session.persist(review);
	            tx.commit();
	            System.out.println("Review added successfully!");
	        } else {
	            System.out.println("Book not found!");
	        }

	        session.close();
	    }

	    // Get all reviews for a book
	    public List<Review> getReviewsByBook(int bookId) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        List<Review> reviews = session.createQuery("FROM Review WHERE book.id = :bookId", Review.class)
	                                      .setParameter("bookId", bookId)
	                                      .list();
	        session.close();
	        return reviews;
	    }

	    // Delete a review
	    public void deleteReview(int reviewId) {
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        Transaction tx = session.beginTransaction();

	        Review review = session.get(Review.class, reviewId);
	        if (review != null) {
	            session.remove(review);
	            tx.commit();
	            System.out.println("Review deleted successfully!");
	        } else {
	            System.out.println("Review not found!");
	        }

	        session.close();
	    }
}
