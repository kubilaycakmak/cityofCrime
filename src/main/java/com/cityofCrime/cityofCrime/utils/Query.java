package com.cityofCrime.cityofCrime.utils;

import com.cityofCrime.cityofCrime.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class Query{
    static Session session;
    static Transaction transaction;
    private static Query query;
    private Query() {

    }

    public boolean register(String username,String firstName,String lastName,String email,String password) {
        boolean check = true;
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User",User.class).list();
        for(User user : users) {
            if(user.getEmail().equals(email) || user.getUsername().equals(username))
                check = false;
        }
        if(check) {
            User user = new User(username, firstName, lastName, email, password);
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
        }
        return check;
    }
    public boolean login(String email,String password) {
        boolean check = false;
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User",User.class).list();
        for(User user : users) {
            if(user.getEmail().equals(email) && user.getPassword().equals(password))
                check = true;
        }

        return  check;
    }
    public static Query getQuery() {
        if(query == null)
            query = new Query();

        return query;
    }
}