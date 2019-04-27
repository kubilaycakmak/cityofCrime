package com.cityofCrime.cityofCrime.controllers;

import com.cityofCrime.cityofCrime.models.User;
import com.cityofCrime.cityofCrime.utils.Query;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    User user;
    Query query;
    HttpSession session;

    @RequestMapping("/*")
    public String get404() {
        return "404";
    }

    @RequestMapping(value = {"/register", "/"}, method = RequestMethod.POST)
    public String getRegister(HttpServletRequest request) {
        String username = request.getParameter("username");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int type = Integer.parseInt(request.getParameter("type"));
        session = request.getSession();
        query = Query.getQuery();
        if (query.register(username, firstName, lastName, email, password,type))
            return "register";
        else {
            session.setAttribute("warning", "Email or nickname already exists.");
            return "register";
        }
    }

    @RequestMapping("/home")
    public String getHome(HttpServletRequest request) {
        session = request.getSession();
        session.setAttribute("user", query.getUser((String)session.getAttribute("email")));
        return "index";
    }



    @RequestMapping("/nightlife")
    public String getNightlife(HttpServletRequest request) {
        session = request.getSession();
        session.setAttribute("user", query.getUser((String)session.getAttribute("email")));
        return "nightlife";
    }

    // @RequestMapping("/quest")
    // public String getQuest(HttpServletRequest request) {
    //     session = request.getSession();
    //     session.setAttribute("user", query.getUser((String)session.getAttribute("email")));
    //     return "quest";
    // }

    // @RequestMapping("/equipment")
    // public String getEquipment(HttpServletRequest request) {
    //     session = request.getSession();
    //     session.setAttribute("user", query.getUser((String)session.getAttribute("email")));
    //     return "equipment";
    // }

    // @RequestMapping("/buildings")
    // public String getBuildings(HttpServletRequest request) {
    //     session = request.getSession();
    //     session.setAttribute("user", query.getUser((String)session.getAttribute("email")));
    //     return "buildings";
    // }

    // @RequestMapping("/bank")
    // public String getBank(HttpServletRequest request) {
    //     session = request.getSession();
    //     session.setAttribute("user", query.getUser((String)session.getAttribute("email")));
    //     return "bank";
    // }

    // @RequestMapping("/hospital")
    // public String getHospital(HttpServletRequest request) {
    //     session = request.getSession();
    //     session.setAttribute("user", query.getUser((String)session.getAttribute("email")));
    //     return "hospital";
    // }

    // @RequestMapping("/casino")
    // public String getCasino(HttpServletRequest request) {
    //     session = request.getSession();
    //     session.setAttribute("user", query.getUser((String)session.getAttribute("email")));
    //     return "casino";
    // }

    // @RequestMapping("/prison")
    // public String getPrison(HttpServletRequest request) {
    //     session = request.getSession();
    //     session.setAttribute("user", query.getUser((String)session.getAttribute("email")));
    //     return "prison";
    // }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String callLogin() {
        return "register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getLogin(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        query = Query.getQuery();
        if (query.login(email,password)) {
            session = request.getSession();
            session.setAttribute("email",email);
            session.setAttribute("user",query.getUser(email));
            return "index";
        } else {
            return "warning";
        }
    }
    @RequestMapping("/user")
    public String getUser(){
        return "user";
    }

    @RequestMapping(value = {"/register", "/"}, method = RequestMethod.GET)
    public String callRegister() {
        return "register";
    }

    @RequestMapping("/logout")
    public String goOut(){
        session.invalidate();
        return "register";
    }

    @RequestMapping(value = "/robbery",method=RequestMethod.GET)
    public String getRobbery(HttpServletRequest request) {
        session = request.getSession();
        session.setAttribute("user", query.getUser((String)session.getAttribute("email")));
        return "robbery";
    }
    
    @RequestMapping(value = "/robbery",method=RequestMethod.POST)
    public String doRobbery(HttpServletRequest request){
        session = request.getSession();
        String email = (String) session.getAttribute("email");
        query = Query.getQuery();
        if(query.doRobbery(request.getParameter("robberyChoose"),email)){
            session.setAttribute("job", "Robbery Successful!");
        }
        else{
            session.setAttribute("job", "Robbery Failed!");
        }
        session.setAttribute("email", email);
        session.setAttribute("user", query.getUser(email));
        return "robbery";
    }

}
