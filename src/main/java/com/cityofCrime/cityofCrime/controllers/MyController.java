package com.cityofCrime.cityofCrime.controllers;

import com.cityofCrime.cityofCrime.models.User;
import com.cityofCrime.cityofCrime.utils.Query;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
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
        session = request.getSession();
        query = Query.getQuery();
        if (query.register(username, firstName, lastName, email, password))
            return "register";
        else {
            session.setAttribute("warning", "Email or nickname already exists.");
            return "register";
        }
    }

    @RequestMapping("/home")
    public String getHome() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String callLogin() {
        return "register";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String getLogin(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        query = Query.getQuery();
        if (query.login(email, password, username) || query.login(username, password, email)) {
            session.setAttribute("password",password);
            session.setAttribute("email",email);
            session.setAttribute("username",username);
            return "index";
        } else {
            return "warning";
        }

    }

    @RequestMapping(value = {"/register", "/"}, method = RequestMethod.GET)
    public String callRegister() {
        return "register";
    }

}
