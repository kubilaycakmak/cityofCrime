package com.cityofCrime.cityofCrime.utils;

import com.cityofCrime.cityofCrime.models.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class Query {
    static Session session;
    static Transaction transaction;
    private static Query query;

    private Query() {

    }

    public boolean register(String username, String firstName, String lastName, String email, String password, int type) {
        boolean check = true;
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User", User.class).list();
        for (User user : users) {
            if (user.getEmail().equals(email) || user.getUsername().equals(username))
                check = false;
        }
        if (check) {
            UserCharacter userCharacter = new UserCharacter(type, 100, 0, 100, 0, 0, 0, 0, 0, 0, null, 0,null, 0);
            User user = new User(username, firstName, lastName, email, password, userCharacter);
            transaction = session.beginTransaction();
            session.save(userCharacter);
            session.save(user);
            transaction.commit();
            session.close();
        }
        return check;
    }

    public boolean login(String email, String password) {
        boolean check = false;
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User", User.class).list();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password))
                check = true;
        }
        session.close();
        return check;
    }

    public User getUser(String email) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User where email = '" + email + "'", User.class).list();
        return users.get(0);
    }


    public boolean doRobbery(String choose, String email) {
        boolean check = false;
        int stamina = 0;
        int respect = 0;
        int money = 0;
        int intelligence = 0;
        int strength = 0;
        int tolerance = 0;
        int charisma = 0;
        List<User> users = session.createQuery("from User where email = '" + email + "'", User.class).list();
        if (choose.equals("job1")) {
            if (users.get(0).getUserCharacter().getPower() >= 0 && users.get(0).getUserCharacter().getPower() < 200){
                stamina = 10;
                money = 10;
                respect = 1;
                intelligence = 1;
                strength = 1;
                tolerance = 1;
                charisma = 1;
            }else if (users.get(0).getUserCharacter().getPower() > 200 && users.get(0).getUserCharacter().getPower() < 300){
                stamina = 10;
                money = 20;
                respect = 2;
                intelligence = 2;
                strength = 2;
                tolerance = 2;
                charisma = 2;
            }else if (users.get(0).getUserCharacter().getPower() > 300){
                stamina = 10;
                money = 30;
                respect = 3;
                intelligence = 4;
                strength = 4;
                tolerance = 5;
                charisma = 6;
            }

        } else if (choose.equals("job2")) {
            stamina = 15;
            money = 20;
            respect = 2;
            intelligence = 1;
            strength = 2;
            tolerance = 1;
            charisma = 1;
        } else if (choose.equals("job3")) {
            stamina = 20;
            money = 30;
            respect = 3;
            intelligence = 2;
            strength = 2;
            tolerance = 2;
            charisma = 1;
        }
        if (users.get(0).getUserCharacter().getStamina() >= stamina) {
            users.get(0).getUserCharacter().setStamina(users.get(0).getUserCharacter().getStamina() - stamina);
            users.get(0).getUserCharacter().setMoney(users.get(0).getUserCharacter().getMoney() + money);
            users.get(0).getUserCharacter().setRespect(users.get(0).getUserCharacter().getRespect() + respect);
            users.get(0).getUserCharacter().setIntelligence(users.get(0).getUserCharacter().getIntelligence() + intelligence);
            users.get(0).getUserCharacter().setStrength(users.get(0).getUserCharacter().getStrength() + strength);
            users.get(0).getUserCharacter().setTolerance(users.get(0).getUserCharacter().getTolerance() + tolerance);
            users.get(0).getUserCharacter().setCharisma(users.get(0).getUserCharacter().getCharisma() + charisma);
            users.get(0).getUserCharacter().setEquipments(null);
            users.get(0).getUserCharacter().getCrew().setBuildings(null);
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
        if (query == null)
            query = new Query();

        return query;
    }

    public void getEquipments(String id, String email) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User where email = '" + email + "'", User.class).list();
        int power = 0;
        int price = 0;
        switch (id) {
            case "1":
                price = 100;
                power = 30;
                users.get(0).getUserCharacter().setEquipment(users.get(0).getUserCharacter().getEquipment() + 1);

                break;
            case "2":
                price = 800;
                power = 42;
                users.get(0).getUserCharacter().setEquipment(users.get(0).getUserCharacter().getEquipment() + 1);
                break;
            case "3":
                price = 1700;
                power = 60;
                users.get(0).getUserCharacter().setEquipment(users.get(0).getUserCharacter().getEquipment() + 1);

                break;
            case "4":
                price = 2500;
                power = 72;

                users.get(0).getUserCharacter().setEquipment(users.get(0).getUserCharacter().getEquipment() + 1);
                break;
            case "5":
                price = 10000;
                power = 0;
                users.get(0).getUserCharacter().setEquipment(users.get(0).getUserCharacter().getEquipment() - 1);
                break;
        }
        if (users.get(0).getUserCharacter().getMoney() >= price && users.get(0).getUserCharacter().getEquipment() < 3) {
            users.get(0).getUserCharacter().setMoney(users.get(0).getUserCharacter().getMoney() - price);
            users.get(0).getUserCharacter().setStrength(users.get(0).getUserCharacter().getStrength() + power);
            users.get(0).getUserCharacter().setPower(users.get(0).getUserCharacter().getPower() + power);
            transaction = session.beginTransaction();
            session.update(users.get(0));
            transaction.commit();
            session.close();
        }
    }

    public void getBuilding(String id, String email) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User where email = '" + email + "'", User.class).list();
        int units = 0;
        int price = 0;
        int feedaily = 0;
        switch (id) {
            case "1":
                price = 50000;
                units = 393211;
                feedaily = 1000;
                break;
            case "2":
                price = 40000;
                units = 10500;
                feedaily = 4000;
                break;
            case "3":
                price = 250000;
                units = 1380;
                feedaily = 25000;

                break;
            case "4":
                price = 150000;
                units = 2850;
                feedaily = 15000;
                break;
        }
        if (users.get(0).getUserCharacter().getMoney() >= price) {
            users.get(0).getUserCharacter().setMoney(users.get(0).getUserCharacter().getMoney() - price);
            transaction = session.beginTransaction();
            session.update(users.get(0));
            transaction.commit();
            session.close();
        }
    }
    public void CreateCrew(String email, String crewName){
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User where email = '"+email+"'",User.class).list();
        if (users.get(0).getUserCharacter().getRespect() >= 150 && users.get(0).getUserCharacter().getMoney() >= 120){
            users.get(0).getUserCharacter().setMoney(users.get(0).getUserCharacter().getMoney() - 120);
            List<Building> buildings = null;
            Crew crew = new Crew(crewName,0,0, buildings);
            users.get(0).getUserCharacter().setCrew(crew);
            transaction = session.beginTransaction();
            session.save(crew);
            session.update(users.get(0));
            transaction.commit();
            session.close();
        }else{
            System.out.println("Not enought money!");
        }
    }
    public void dropCrew(String email){
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User where email = '"+email+"'",User.class).list();
            users.get(0).getUserCharacter().setCrew(null);
            users.get(0).getUserCharacter().setMoney(users.get(0).getUserCharacter().getMoney() + 36);
            transaction = session.beginTransaction();
            session.update(users.get(0));
            transaction.commit();
            session.close();
    }
    public void donateCrew(String email, int money){
        session = HibernateUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("from User where email = '"+email+"'",User.class).list();
        if (users.get(0).getUserCharacter().getMoney() >= money){
            users.get(0).getUserCharacter().getCrew().setBudget(users.get(0).getUserCharacter().getCrew().getBudget() + money);
            users.get(0).getUserCharacter().setMoney(users.get(0).getUserCharacter().getMoney() - money);
            transaction = session.beginTransaction();
            session.update(users.get(0));
            transaction.commit();
            session.close();
        }
    }


}