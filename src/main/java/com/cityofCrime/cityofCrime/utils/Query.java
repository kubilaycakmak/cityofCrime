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


    public boolean doRobbery(String choose, String email){
        boolean check = false;
        int stamina = 0;
        int respect = 0;
        int money = 0;
        int intelligence = 0;
        int strength = 0;
        int tolerance = 0;
        int charisma = 0;
        List<User> users = session.createQuery("from User where email = '"+email+"'",User.class).list();
        if(choose.equals("job1")){
            stamina = 10;
            money = 10;
            respect = 1;
            intelligence = 1;
            strength = 1;
            tolerance = 1;
            charisma = 1;
        }
        else if(choose.equals("job2")){
            stamina = 15;
            money = 20;
            respect = 2;
            intelligence = 1;
            strength = 2;
            tolerance = 1;
            charisma = 1;
        }
        else if(choose.equals("job3")){
            stamina = 20;
            money = 30;
            respect = 3;
            intelligence = 2;
            strength = 2;
            tolerance = 2;
            charisma = 1;
        }
        if(users.get(0).getUserCharacter().getStamina() >= stamina){
            users.get(0).getUserCharacter().setStamina(users.get(0).getUserCharacter().getStamina()-stamina);
            users.get(0).getUserCharacter().setMoney(users.get(0).getUserCharacter().getMoney()+money);
            users.get(0).getUserCharacter().setRespect(users.get(0).getUserCharacter().getRespect()+respect);
            users.get(0).getUserCharacter().setIntelligence(users.get(0).getUserCharacter().getIntelligence()+intelligence);
            users.get(0).getUserCharacter().setStrength(users.get(0).getUserCharacter().getStrength()+strength);
            users.get(0).getUserCharacter().setTolerance(users.get(0).getUserCharacter().getTolerance()+tolerance);
            users.get(0).getUserCharacter().setCharisma(users.get(0).getUserCharacter().getCharisma()+charisma);
            users.get(0).getUserCharacter().setEquipments(null);
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(users.get(0).getUserCharacter());
            session.update(users.get(0));
            transaction.commit();
            session.close();
            check = true;
        }
        return check;
    }

    public static Query getQuery() {
        if(query == null)
            query = new Query();

        return query;
    }
}