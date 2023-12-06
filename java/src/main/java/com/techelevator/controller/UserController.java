package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin
public class UserController {

    private UserDao userDao;

//    @RequestMapping(path = "/currentUser", method = RequestMethod.GET)
//    public int getCurrentUser(Principal currentUser){
//
//    }

}
