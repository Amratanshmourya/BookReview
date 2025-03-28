package com.java.bookreview.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	    
	    @ManyToOne
	    @JoinColumn(name = "book_id")
	    private Book book;
	    
	    public void setBook(Book book) {
	    	this.book = book;
	    }
	    public int getId() {
	    	return id;
	    }
	    public Book getBook() {
	    	return book;
	    }
	    private String reviewer;
	    private int rating;
	    private String comment;
		public String getReviewer() {
			return reviewer;
		}
		public void setReviewer(String reviewer) {
			this.reviewer = reviewer;
		}
		public int getRating() {
			return rating;
		}
		public void setRating(int rating) {
			this.rating = rating;
		}
		public String getComment() {
			return comment;
		}
		public void setComment(String comment) {
			this.comment = comment;
		}
	    
}
