package com.test;

import org.hibernate.Session;

import com.entity.Authors;
import com.entity.Books;
import com.entity.ReaderEntity;
import com.entity.SubscriptionEntity;
import com.utils.HibernateUtil;
import java.util.HashSet;
import java.util.Set;

public class AppTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		/*
		 * Add subscription SubscriptionEntity subOne = new SubscriptionEntity();
		 * subOne.setSubscriptionName("Amazon"); SubscriptionEntity subTwo = new
		 * SubscriptionEntity(); subTwo.setSubscriptionName("Netflix");
		 * SubscriptionEntity subThree = new SubscriptionEntity();
		 * subThree.setSubscriptionName("Hotstar"); Set<SubscriptionEntity> subs = new
		 * HashSet<SubscriptionEntity>(); subs.add(subOne); subs.add(subTwo);
		 * subs.add(subThree);
		 * 
		 * // Add readers ReaderEntity readerOne = new ReaderEntity();
		 * readerOne.setEmail("Darshit@gmail.com"); readerOne.setFirstName("Darshit");
		 * readerOne.setLastName("Rabadiya");
		 * 
		 * ReaderEntity readerTwo = new ReaderEntity();
		 * readerTwo.setEmail("abc@gmail.com"); readerTwo.setFirstName("abc");
		 * readerTwo.setLastName("abc");
		 * 
		 * Set<ReaderEntity> readers = new HashSet<ReaderEntity>();
		 * readers.add(readerOne); readers.add(readerTwo);
		 * 
		 * readerOne.setSubscriptions(subs); readerTwo.setSubscriptions(subs);
		 * 
		 * //session.save(readerOne); //session.save(readerTwo);
		 * 
		 */

		// Add Authors
		Authors auth1 = new Authors();
		auth1.setAuthname("abc");
		auth1.setCity("mumbai");

		Authors auth2 = new Authors();
		auth2.setAuthname("pqr");
		auth2.setCity("nagpur");

		Authors auth3 = new Authors();
		auth3.setAuthname("xyz");
		auth3.setCity("pune");

		Set<Authors> author = new HashSet<Authors>();
		author.add(auth1);
		author.add(auth2);
		author.add(auth3);

		// Add Books
		Books book1 = new Books();
		book1.setBookname("agfhgd");
		book1.setPrice(100);

		Books book2 = new Books();
		book2.setBookname("ajhjgfd");
		book2.setPrice(200);

		Set<Books> book = new HashSet<Books>();
		book.add(book1);
		book.add(book2);

		book1.setAuthor(author);
		book2.setAuthor(author);

		session.save(auth1);
		session.save(auth2);
		session.save(book1);
		session.save(book2);

		session.getTransaction().commit();

	}
}