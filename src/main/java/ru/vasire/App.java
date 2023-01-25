package ru.vasire;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.vasire.model.Person;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session =  sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            person.setName("Vadim Sirenko");

            System.out.println(person);

            Person person2 = new Person("Elena", 34);
            session.persist(person2);

            session.remove(person);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }

    }
}
