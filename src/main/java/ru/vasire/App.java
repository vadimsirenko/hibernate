package ru.vasire;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.vasire.model.Item;
import ru.vasire.model.Person;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class).addAnnotatedClass(Item.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session =  sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            person.setName("Vadim Sirenko");

            System.out.println(person);
            System.out.println("Items:");
            person.getItems().stream().forEach(i-> System.out.println(i));

            Person person3 = session.get(Person.class, 3);
            Item item = session.get(Item.class, 3);
            item.setName("Телефон");
            item.setOwner(person3);

            person.getItems().remove(person.getItems().stream().filter(i->i.getId()==3).findFirst());

            person3.setItems(new ArrayList<>());
            person3.getItems().add(item);



            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }

    }
}
