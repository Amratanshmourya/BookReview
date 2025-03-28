package com.java.bookreview.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.java.bookreview.entities.Book;
import com.java.bookreview.util.HibernateUtil;

public class BookDAO {

	
	 // Add a new book
    public void addBook(String title, String author,int publishedyear) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublishedyear(publishedyear);

        session.persist(book);
        tx.commit();
        session.close();

        System.out.println("Book added successfully!");
    }

    // Get all books
    public List<Book> getAllBooks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Book> books = session.createQuery("FROM Book", Book.class).list();
        session.close();
        return books;
    }

    // Update book
    public void updateBook(int bookId, String newTitle, String newAuthor,int publishedyear) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, bookId);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
            book.setPublishedyear(publishedyear);
            session.merge(book);
            tx.commit();
            System.out.println("Book updated successfully!");
        } else {
            System.out.println("Book not found!");
        }

        session.close();
    }

    // Delete book
    public void deleteBook(int bookId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Book book = session.get(Book.class, bookId);
        if (book != null) {
            session.remove(book);
            tx.commit();
            System.out.println("Book deleted successfully!");
        } else {
            System.out.println("Book not found!");
        }

        session.close();
    }
}
