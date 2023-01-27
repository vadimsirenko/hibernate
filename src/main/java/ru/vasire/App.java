package ru.vasire;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.vasire.model.Item;
import ru.vasire.model.Passport;
import ru.vasire.model.Person;
import ru.vasire.model.Subscribetion;

import java.awt.color.ICC_Profile;
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
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class).addAnnotatedClass(Item.class)
                .addAnnotatedClass(Passport.class).addAnnotatedClass(Subscribetion.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session =  sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
/*
            Person person = new Person("Григорий 1", 38);
            person.addItem(new Item("Шапка 1"));
            person.addItem(new Item("Ботинки 1"));
            person.addItem(new Item("Кружка 1"));

            person.setPassport(new Passport("ASDF456789"));

            session.persist(person);
*/

            Person person = session.get(Person.class, 1);

            System.out.println(person);
            System.out.println("Пдодписки:");
            person.getSubscribetions().forEach(i->System.out.println(i));

            //session.remove(person);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }

    }
}
