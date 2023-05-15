package com.test;

import org.hibernate.Session;
import com.entity.Authors;
import com.entity.Books;
import com.entity.Employees;
import com.entity.Projects;
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
		
		 // Add subscription 
			SubscriptionEntity subOne = new SubscriptionEntity();
			subOne.setSubscriptionName("Amazon"); 
			SubscriptionEntity subTwo = new SubscriptionEntity(); 
			subTwo.setSubscriptionName("Netflix");
			SubscriptionEntity subThree = new SubscriptionEntity();
			subThree.setSubscriptionName("Hotstar"); 
			Set<SubscriptionEntity> subs = new
			HashSet<SubscriptionEntity>(); subs.add(subOne); subs.add(subTwo);
			subs.add(subThree);
		  
		  // Add readers 
			ReaderEntity readerOne = new ReaderEntity();
			readerOne.setEmail("Darshit@gmail.com"); readerOne.setFirstName("Darshit");
			readerOne.setLastName("Rabadiya");
		  
		  ReaderEntity readerTwo = new ReaderEntity();
		  readerTwo.setEmail("abc@gmail.com"); readerTwo.setFirstName("abc");
		  readerTwo.setLastName("abc");
		  
		  Set<ReaderEntity> readers = new HashSet<ReaderEntity>();
		  readers.add(readerOne); readers.add(readerTwo);
		  
		  readerOne.setSubscriptions(subs); 
		  readerTwo.setSubscriptions(subs);
		  
		  session.save(readerOne);
		 session.save(readerTwo);
		  
		*/  
		
		// Many to Many mapping of AUTHORS - BOOKS
		// Add Books
		Books book1 = new Books();
		book1.setBookname("automichabits"); 
		Books book2 = new Books();
		book2.setBookname("wingsoffier"); 
		Books book3 = new Books();
		book3.setBookname("onedaylifewillchange"); 
		Set<Books> books = new HashSet<Books>(); 
		books.add(book1); books.add(book2);
		books.add(book3);
		
		// Add Authors
		Authors auth1 = new Authors();
		auth1.setAuthname("Jamesclear");
	  
		Authors auth2 = new Authors();
		auth2.setAuthname("APJAbdulKalam");
		Set<Authors> authors = new HashSet<Authors>();
		authors.add(auth1); 
		authors.add(auth2);
	  
		auth1.setBooks(books); 
		auth2.setBooks(books);
	  
		session.save(auth1);
		session.save(auth2);
		
		
		/*
		//Many to Many mapping between Employees and Projects
		
		// Add Projects 
					Projects project1 = new Projects();
					project1.setPname("abcd"); 
					Projects project2 = new Projects();
					project1.setPname("pqrs"); 
					Projects project3 = new Projects();
					project1.setPname("xyz"); 
					Set<Projects> projects = new HashSet<Projects>(); 
					projects.add(project1); projects.add(project2);
					projects.add(project3);
				  
				  // Add Employees
					Employees emp1 = new Employees();
					emp1.setEmpname("jhfdafdhg");
				  
					Employees emp2 = new Employees();
					emp1.setEmpname("kjgityur");
				  Set<Employees> employees = new HashSet<Employees>();
				  employees.add(emp1); 
				  employees.add(emp2);
				  
				  emp1.setProjects(projects); 
				  emp2.setProjects(projects);
				  
				  session.save(emp1);
				 session.save(emp2);
				 
				 */
				  

		session.getTransaction().commit();
		
		session.close();

	}
}