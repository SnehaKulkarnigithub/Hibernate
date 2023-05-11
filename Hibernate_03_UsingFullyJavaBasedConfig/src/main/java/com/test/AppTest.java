package com.test;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entity.Product;
import com.entity.Student;
import com.entity.University;
import com.utils.HibernateUtil;
public class AppTest {
    public static void main(String[] args) {
       
    	// transient state
    	//Student student = new Student("urvi", "d", "urvi@gmail.com");
       // Student student1 = new Student("kajal", "k", "kajal@gmail.com");
       // Product product1= new Product(1,"ndftd","gfhdf");
    	University uni1=new University("svpuniversity","boroda","www.nvshdgfx.com");
    	//University uni2=new University(2,"sppu","pune","www.unip.com");
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            //session.save(uni1);
            //session.saveOrUpdate("2", uni2);
            session.saveOrUpdate(uni1);
            
            // persistent state 
            // save the student objects
           // session.save(student);
            //session.save(student1);
            
            //session.saveOrUpdate("1",product1);
            //session.saveOrUpdate(product1);
           // product1.setProductName("TV unit");
           // product1.setProductdescription("agdhg dfhgjv");
           
            
        
            
            // use saveorupdate() explore
                   
            //--------------------------------------------
            // commit transaction
            transaction.commit();
            
       // detached state
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        
       
               
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           // List<Student> students = session.createQuery("from Student", Student.class).list();
           //List<Product> product = session.createQuery("from Product", Product.class).list();
        	List<University> univ= session.createQuery("from University", University.class).list();
        	

           // students.forEach(s->System.out.println("FirstName >>>	"+ s.getFirstName() +   "	LastName>>>	"  + s.getLastName() +  "	Email>>>	" +   s.getEmail()));
           // product.forEach(p->System.out.println("ProductName>>>	" + p.getProductName() + "	ProductDescription>>>		" + p.getProductdescription()));
            univ.forEach(u->System.out.println("University Name>>> "+ u.getUniname() + "  City >>>" + u.getCity() + "  Website>>>" + u.getWebsite()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
