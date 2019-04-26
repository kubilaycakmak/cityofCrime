package com.cityofCrime.cityofCrime.utils;
import com.cityofCrime.cityofCrime.models.User;
import com.cityofCrime.cityofCrime.models.UserCharacter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class Query{
    static Session session;
    static Transaction transaction;
    private static Query query;
    private Query() {

    }

    public boolean register(String username,String firstName,String lastName,String email,String password,int type) {
        boolean check = true;
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User",User.class).list();
        for(User user : users) {
            if(user.getEmail().equals(email) || user.getUsername().equals(username))
                check = false;
        }
        if(check) {
            UserCharacter userCharacter = new UserCharacter(type,100,0,100,0,0,0,0,0,0,null,0);
            User user = new User(username, firstName, lastName, email, password, userCharacter);
            transaction = session.beginTransaction();
            session.save(userCharacter);
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
        session.close();
        return  check;
    }

    public User getUser(String email){
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User where email = '"+email+"'",User.class).list();
        return users.get(0);
    }

    public static Query getQuery() {
        if(query == null)
            query = new Query();

        return query;
    }
}