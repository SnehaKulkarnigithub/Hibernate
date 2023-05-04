package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class FetchDataUsingLoad {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session sessionOne = factory.openSession();
		sessionOne.beginTransaction();

		// Create new Employee object
		Employee employee = new Employee("Darshit", "Rabadiya", 100);
		// Save employee
		sessionOne.save(employee);
		// store the employee id generated for future use
		Integer empId = employee.getId();
		sessionOne.getTransaction().commit();

		/*****************************************************/

		// Let's open a new session to test load() methods
		Session sessionTwo = factory.openSession();
		sessionTwo.beginTransaction();
		// first load() method example
		Employee emp1 = (Employee) sessionTwo.load(Employee.class, empId);
		System.out.println(emp1.getFirstName() + " - " + emp1.getLastName());
		// Let's verify the entity name
		System.out.println(sessionTwo.getEntityName(emp1));
		sessionTwo.getTransaction().commit();

		/************************************************************************/

		Session sessionThree = factory.openSession();
		sessionThree.beginTransaction();

		// second load() method example
		Employee emp2 = (Employee) sessionThree.load("com.entity.Employee", empId);
		System.out.println(emp2.getFirstName() + " - " + emp2.getLastName());

		sessionThree.getTransaction().commit();

		/************************************************************************/

		Session sessionFour = factory.openSession();
		sessionFour.beginTransaction();

		// third load() method example
		Employee emp3 = new Employee();
		sessionFour.load(emp3, empId);
		System.out.println(emp3.getFirstName() + " - " + emp3.getLastName());

		sessionFour.getTransaction().commit();

	}
}
