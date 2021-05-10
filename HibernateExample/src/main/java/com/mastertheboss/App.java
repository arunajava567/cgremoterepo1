package com.mastertheboss;
 
import java.util.List;
 
 
import com.mastertheboss.domain.Employee;
import com.mastertheboss.domain.Department;
import com.mastertheboss.util.*;
 
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
 
public class App {
 
public static void main(String[] args) {
          
       // Session session = HibernateUtil.getSessionFactory().openSession();
       Session session= new Configuration().configure().buildSessionFactory().openSession();
      
       
       session.beginTransaction();
 
        Department department = new Department("j2ee");
        session.save(department);
 
        session.save(new Employee("akhila Reddy",department));
        session.save(new Employee("aruna",department));
        Employee e3=new Employee("xyz",department);
        session.save(e3);
       session.delete(e3);
        session.getTransaction().commit();
 
        Query q = session.createQuery("From Employee ");//HQL
                 
        List<Employee> resultList = q.list();
        System.out.println("num of employess:" + resultList.size());
        for (Employee next : resultList) {
            System.out.println("next employee: " + next);
        }
 
    }
    
}
